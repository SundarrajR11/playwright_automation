package com.everstage.juiceshop.utils;

import com.github.javafaker.Faker;

public class RandomValueProvider {
    private RandomValueProvider(){}

    public static String randomFullName(){
        return FakerUtils.fullName();
    }
    public static long randomCardNumber(){
       return FakerUtils.cardNumber(16);
    }
    public static int randomExpMonth(){
        return FakerUtils.expMonth(1,12);
    }
    public static int randomExpYear(){
       return FakerUtils.expYear(2080,2099);
    }
}
