package com.api.userphone_onetoone.dtos;

import jakarta.validation.constraints.NotBlank;

public class PhoneDto {
    @NotBlank
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
