package ch.qompetence.logistica.infrastructure.web.controller;

import ch.qompetence.logistica.api.dto.SkillDto;
import ch.qompetence.logistica.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAllSkills() {
        final var skills = skillService.getAllSkills();
        return ResponseEntity.ok(skills);
    }
}