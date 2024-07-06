package com.everstage.juiceshop.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    private FakerUtils(){}

    private static final Faker faker =new Faker();
    protected static String fullName(){
        return faker.name().fullName();
    }
    protected static long cardNumber(int digit){
        return  faker.number().randomNumber(digit,true);
    }
    protected static int expMonth(int mStart,int mEnd){
        return faker.number().numberBetween(mStart,mEnd);
    }
    protected static int expYear(int yStart,int yEnd){
        return faker.number().numberBetween(yStart,yEnd);
    }
}
