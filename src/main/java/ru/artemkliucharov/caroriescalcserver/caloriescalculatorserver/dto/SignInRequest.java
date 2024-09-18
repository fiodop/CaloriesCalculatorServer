package ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
