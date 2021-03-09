package com.tatara.second.dto;

public class TestDTO {
    private String text;

    public TestDTO() {
    }

    public TestDTO(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
