package com.example.eurekaclient2.Controller;

import java.util.Random;

public interface OrderNumberGenerator {

    static Integer orderNumberGenerator() {
        Random random = new Random();
        int min = 0;
        int max = 10000;
        int orderNumber = random.nextInt((max - min) + 1) + min;
        return orderNumber;
    }
}
