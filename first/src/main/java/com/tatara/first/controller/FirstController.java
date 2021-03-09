package com.tatara.first.controller;

import com.tatara.first.dto.FirstDTO;
import com.tatara.first.service.FirstService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    private final FirstService firstService;

    public FirstController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/first")
    public String get() {
        return firstService.get();
    }

    @GetMapping("/first2")
    public FirstDTO get2() {
        return firstService.get2();
    }
}
