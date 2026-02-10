package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.APIResponse;
import com.example.demo.dto.BFHLRequest;
import com.example.demo.service.BFHLService;

@RestController
public class BFHLController {

    private final BFHLService service;
    private final String EMAIL = "aashtha0344.be23@chitkara.edu.in";

    public BFHLController(BFHLService service) {
        this.service = service;
    }

    @PostMapping("/bfhl")
    public ResponseEntity<APIResponse> process(@RequestBody BFHLRequest request) {
        Object result = service.process(request);
        return ResponseEntity.ok(
                new APIResponse(true, EMAIL, result));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {

        return ResponseEntity.ok(
            Map.of(
                "is_success", true,
                "official_email", EMAIL
            )
        );
    }
}