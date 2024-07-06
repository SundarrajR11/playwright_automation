package com.everstage.juiceshop.utils;

import com.everstage.juiceshop.customexceptions.NullValueSentException;

import java.util.Objects;

public final class DynamicXpath {
    private DynamicXpath(){}

    public static String getDesiredXpath(String baseXpath,String locatorText){
        if(Objects.isNull(baseXpath) || Objects.isNull(locatorText)){
            throw new NullValueSentException("BaseXpath or locatorText must not be a null"+baseXpath+" or "+locatorText);
        }
        return  String.format(baseXpath,locatorText);
    }
}
