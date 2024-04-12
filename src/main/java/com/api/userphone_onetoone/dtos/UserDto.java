package com.api.userphone_onetoone.dtos;

import jakarta.validation.constraints.NotBlank;

public class UserDto {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
