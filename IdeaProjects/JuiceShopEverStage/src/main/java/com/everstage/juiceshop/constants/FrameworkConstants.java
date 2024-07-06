package com.everstage.juiceshop.constants;

import lombok.Getter;


public final class FrameworkConstants {
    private FrameworkConstants(){}

    //private static final String PWD=System.getProperty("user.dir");

    @Getter private static final String BASE_URI="http://localhost:3000";
    @Getter private static final String WEB_LOGIN_URL="http://localhost:3000/#/login";
    @Getter private static final int EXP_TIME_WAIT=20;
    @Getter private static final String LOGIN_JSON_PATH  = System.getProperty("user.dir")+"/src/test/resources/jsons/new-user.json";

    /*BEARER value is not the constant one*/
    @Getter private static final String BEARER_AUTH="http://localhost:3000/#/login";

}
