package ch.qompetence.logistica.service;

import ch.qompetence.logistica.domain.entity.PersonnelEntity;
import ch.qompetence.logistica.domain.entity.SkillEntity;
import ch.qompetence.logistica.domain.repository.PersonnelRepository;
import ch.qompetence.logistica.domain.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadService {

    private final PersonnelRepository personnelRepository;
    private final SkillRepository skillRepository;

    @Transactional
    public void processXlsxFile(MultipartFile file) {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            var sheet = workbook.getSheetAt(0);
            var firstRow = true;
            for (var row : sheet) {
                if (firstRow) { // Überspringe Header
                    firstRow = false;
                    continue;
                }
                // Annahme: Spalte 0: Name / Vorname, Spalte 1: Grad Kurzform, Spalte 2: Militärische Führerscheine
                var name = getCellValueAsString(row.getCell(1));
                var grade = getCellValueAsString(row.getCell(0));
                var skillsString = getCellValueAsString(row.getCell(2));

                var personnel = new PersonnelEntity();
                personnel.setId(UUID.randomUUID().toString());
                personnel.setName(name);
                personnel.setGrade(grade);
                personnel.setAvailable(true);

                List<SkillEntity> skills = new ArrayList<>();
                if (skillsString != null && !skillsString.isEmpty()) {
                    var skillNames = skillsString.split(";");
                    for (var skillName : skillNames) {
                        skillName = skillName.trim();
                        if (!skillName.isEmpty()) {
                            var skill = skillRepository.findByName(skillName);
                            if (skill == null) {
                                // Neuer Skill wird nur einmal gespeichert
                                final var skillEntity = SkillEntity.builder().id(UUID.randomUUID().toString()).name(skillName).build();
                                skill = skillRepository.saveAndFlush(skillEntity);
                            }
                            skills.add(skill);
                        }
                    }
                }
                personnel.setSkills(skills);
                personnelRepository.save(personnel);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing XLSX file", e);
        }
    }


    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> DateUtil.isCellDateFormatted(cell)
                    ? cell.getDateCellValue().toString()
                    : Double.toString(cell.getNumericCellValue());
            case BOOLEAN -> Boolean.toString(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> "";
        };
    }
}