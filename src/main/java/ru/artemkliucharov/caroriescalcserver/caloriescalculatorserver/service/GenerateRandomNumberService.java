package ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateRandomNumberService {
    /**
     * GEnerating random number with given length
     * @param length length of number
     * @return generated number
     */
    public static int generateRandomNumber(int length){
        long min = (long) Math.pow(10, length - 1);
        long max = (long) Math.pow(10, length) - 1;

        Random random = new Random();
        return (int) (min + random.nextDouble() * (max - min));
    }
}
