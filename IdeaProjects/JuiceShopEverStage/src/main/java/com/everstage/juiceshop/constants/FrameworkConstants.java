package com.everstage.juiceshop.constants;

import lombok.Getter;

import java.io.File;


public final class FrameworkConstants {
    private FrameworkConstants(){}

    @Getter private static final String BASE_URI="http://localhost:3000";
    @Getter private static final String WEB_LOGIN_URL="http://localhost:3000/#/login";
    @Getter private static final int EXP_TIME_WAIT=20;
    @Getter private static final String LOGIN_JSON_PATH  = System.getProperty("user.dir")+"/src/test/resources/jsons/new-user.json";
    @Getter private static final String EXTENT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output/index.html";
    @Getter private static final String SPARK_SETUP_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/reportsetup.json/";

    /*BEARER value is not the constant one*/
    @Getter private static final String BEARER_AUTH="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdGF0dXMiOiJzdWNjZXNzIiwiZGF0YSI6eyJpZCI6MjIsInVzZXJuYW1lIjoiIiwiZW1haWwiOiJyYWd1c3VuZGFyOTM1QGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiM2UyNzZhZDkxZTk3OWViZjZlZTdhYjQyMDEzYjUwNmIiLCJyb2xlIjoiY3VzdG9tZXIiLCJkZWx1eGVUb2tlbiI6IiIsImxhc3RMb2dpbklwIjoiMC4wLjAuMCIsInByb2ZpbGVJbWFnZSI6Ii9hc3NldHMvcHVibGljL2ltYWdlcy91cGxvYWRzL2RlZmF1bHQuc3ZnIiwidG90cFNlY3JldCI6IiIsImlzQWN0aXZlIjp0cnVlLCJjcmVhdGVkQXQiOiIyMDI0LTA3LTA5IDExOjI1OjIyLjA3NyArMDA6MDAiLCJ1cGRhdGVkQXQiOiIyMDI0LTA3LTA5IDExOjI1OjIyLjA3NyArMDA6MDAiLCJkZWxldGVkQXQiOm51bGx9LCJpYXQiOjE3MjA1MjQ0NDB9.Gzo99k8QXQO0qVCx55bv_ey1pNSXGCCBvo25lAvPgOywXMlsVyaDEw78zwVsz-Jw0EKfXmVrhQ6tXq7xCuRVA4LdzJhfjsT3HWlgspmewhgxpbIjcKcemDNvg9kpnpizhBLmFwlqBAZyxhB7IH_TBh39hWRfGMzRUNDf6Q5Z6Ks";

}
