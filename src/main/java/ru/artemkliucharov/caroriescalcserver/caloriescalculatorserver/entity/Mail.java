package ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.service.GenerateRandomNumberService;

@Data
public class Mail {
    private String recipient;
    private String subject = "Verification code";
    private String text;



    public Mail(String recipient){
        this.recipient = recipient;
        int verificationCode = GenerateRandomNumberService.generateRandomNumber(6);
        this.text = String.valueOf(verificationCode);
    }
}
