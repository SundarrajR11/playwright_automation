package com.everstage.juiceshop.utils;

public final class DynamicXpath {
    private DynamicXpath(){}

    public static String getDesiredXpath(String baseXpath,String replaceableText){
        return  String.format(baseXpath,replaceableText);
    }
}
