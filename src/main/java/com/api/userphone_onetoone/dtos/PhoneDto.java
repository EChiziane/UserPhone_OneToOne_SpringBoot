package com.api.userphone_onetoone.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class PhoneDto {
    @NotBlank
    private String number;
    @NotBlank
    private UUID userId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
