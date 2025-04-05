package ch.qompetence.logistica.infrastructure.web.controller;

import ch.qompetence.logistica.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload-xlsx")
@RequiredArgsConstructor
public class UploadController {

    private final UploadService personnelUploadService;

    @PostMapping
    public ResponseEntity<?> uploadXlsx(@RequestParam("file") MultipartFile file) {
        personnelUploadService.processXlsxFile(file);
        return ResponseEntity.ok().build();
    }
}
