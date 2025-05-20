package edu.fbansept.estiam25cidc.controller;

import edu.fbansept.estiam25cidc.dto.HealthMetrics;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health-check")
    public ResponseEntity<HealthMetrics> getHealth() {

        return ResponseEntity.ok(new HealthMetrics(
                true,
                (int)(Math.random() * 100),
                (int)(Math.random() * 2048)));
    }
}
