package ch.qompetence.logistica.infrastructure.web.controller;

import ch.qompetence.logistica.api.dto.PersonnelDto;
import ch.qompetence.logistica.service.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnel")
@RequiredArgsConstructor
public class PersonnelController {

    private final PersonnelService personnelService;

    @GetMapping
    public ResponseEntity<List<PersonnelDto>> getAllPersonnel() {
        final var personnelList = personnelService.getAllPersonnel();
        return ResponseEntity.ok(personnelList);
    }
}