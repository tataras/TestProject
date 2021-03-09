package com.tatara.first.service;

import com.tatara.first.dto.FirstDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FirstService {

    public String get() {
        return "Text";
    }

    public FirstDTO get2() {
        return new FirstDTO(LocalDateTime.now(), 12, "message");
    }
}
