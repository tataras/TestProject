package com.tatara.second.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class SecondDTO {
    @JsonFormat(pattern="HH:mm:ss yyyy-MM-dd")
    private LocalDateTime time;
    private Float number;
    private String message;

    public SecondDTO() {
    }

    public SecondDTO(LocalDateTime time, Float number, String message) {
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

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
