package com.everstage.juiceshop.constants;

import lombok.Getter;


public final class FrameworkConstants {
    private FrameworkConstants(){}

    //private static final String PWD=System.getProperty("user.dir");
    @Getter private static final String SPARK_TARGET_PATH  = System.getProperty("user.dir")+"/test-result/index.html";
    @Getter private static final String SPARK_SETUP_PATH = System.getProperty("user.dir")+"/src/main/resources/reportsetup.json";
    @Getter private static final String BASE_URI="http://localhost:3000";
    @Getter private static final String WEB_LOGIN_URL="http://localhost:3000/#/login";
    @Getter private static final int EXP_TIME_WAIT=20;

}
