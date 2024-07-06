package com.everstage.juiceshop.constants;

import lombok.Getter;


public final class FrameworkConstants {
    private FrameworkConstants(){}

    @Getter private static final String BASE_URI="http://localhost:3000";
    @Getter private static final String WEB_LOGIN_URL="http://localhost:3000/#/login";
    @Getter private static final int EXP_TIME_WAIT=20;
    @Getter private static final String LOGIN_JSON_PATH  = System.getProperty("user.dir")+"/src/test/resources/jsons/new-user.json";

    /*BEARER value is not the constant one*/
    @Getter private static final String BEARER_AUTH="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdGF0dXMiOiJzdWNjZXNzIiwiZGF0YSI6eyJpZCI6MjIsInVzZXJuYW1lIjoiIiwiZW1haWwiOiJyYWd1c3VuZGFyOTM1QGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiM2UyNzZhZDkxZTk3OWViZjZlZTdhYjQyMDEzYjUwNmIiLCJyb2xlIjoiY3VzdG9tZXIiLCJkZWx1eGVUb2tlbiI6IiIsImxhc3RMb2dpbklwIjoiMC4wLjAuMCIsInByb2ZpbGVJbWFnZSI6Ii9hc3NldHMvcHVibGljL2ltYWdlcy91cGxvYWRzL2RlZmF1bHQuc3ZnIiwidG90cFNlY3JldCI6IiIsImlzQWN0aXZlIjp0cnVlLCJjcmVhdGVkQXQiOiIyMDI0LTA3LTA2IDA0OjQ2OjI0Ljc5NCArMDA6MDAiLCJ1cGRhdGVkQXQiOiIyMDI0LTA3LTA2IDA0OjQ2OjI0Ljc5NCArMDA6MDAiLCJkZWxldGVkQXQiOm51bGx9LCJpYXQiOjE3MjAyNDI4OTF9.tLVf9RRyFvJxzh_87W_tsimNV8rAjW27qCxmWUyB7_oPyKA2Enkgp6P0qiCj2oXzRgX5AzKzv_B1-M8Jb3c4RxUPxNexku20nX96cDbReTEVXn3Xzh9sRSMFFD7r-Q6w87r3mfu9RmaIT4BueFxQARa9XNgslPyv1445e_97qWM";

}
