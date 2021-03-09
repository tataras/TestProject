package com.tatara.second.controller;

import com.tatara.second.dto.SecondDTO;
import com.tatara.second.dto.TestDTO;
import com.tatara.second.service.SecondService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    private final SecondService secondService;

    public SecondController(SecondService secondService) {
        this.secondService = secondService;
    }

    @GetMapping("/second")
    public TestDTO get() {
        return secondService.get();
    }

    @GetMapping("/second2")
    public SecondDTO get2() {
        return secondService.get2();
    }
}
