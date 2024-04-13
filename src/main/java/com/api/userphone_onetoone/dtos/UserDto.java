package com.api.userphone_onetoone.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class UserDto {
    @NotBlank
    private String name;
    @NotBlank
    private UUID phoneId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(UUID phoneId) {
        this.phoneId = phoneId;
    }
}
