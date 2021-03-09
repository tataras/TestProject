package com.tatara.first.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class FirstDTO {
    @JsonFormat(pattern="HH:mm:ss yyyy-MM-dd")
    private LocalDateTime time;
    private int number;
    private String message;

    public FirstDTO() {
    }

    public FirstDTO(LocalDateTime time, int number, String message) {
        this.time = time;
        this.number = number;
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
