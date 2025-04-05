package ch.qompetence.logistica.infrastructure.web.controller;

import ch.qompetence.logistica.api.dto.AssignmentDto;
import ch.qompetence.logistica.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping
    public ResponseEntity<List<AssignmentDto>> getAllAssignments() {
        final var assignments = assignmentService.getAllAssignments();
        return ResponseEntity.ok(assignments);
    }

    @PutMapping
    public ResponseEntity<List<AssignmentDto>> updateAssignments(@RequestBody List<AssignmentDto> assignments) {
        final var updated = assignmentService.updateAssignments(assignments);
        return ResponseEntity.ok(updated);
    }
}