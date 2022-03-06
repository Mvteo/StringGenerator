package com.wojcik.stringgenerator.controller;

import com.wojcik.stringgenerator.dto.GenerateRequest;
import com.wojcik.stringgenerator.service.GeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GeneratorController {
    private GeneratorService generatorService = new GeneratorService();

    @PostMapping("/generate")
    @Transactional(timeout = 20)
    ResponseEntity<String> generateString(@RequestBody GenerateRequest request) {
        try {
            return ResponseEntity.ok(generatorService.generateStrings(request));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/jobs")
    ResponseEntity<String> getCurrentJobs() {
        return ResponseEntity.ok(generatorService.getProcessCounter());
    }
}
