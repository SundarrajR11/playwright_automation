package com.everstage.juiceshop.constants;

import lombok.Getter;


public final class FrameworkConstants {
    private FrameworkConstants(){}

    @Getter private static final String BASE_URI="http://localhost:3000";
    @Getter private static final String WEB_LOGIN_URL="http://localhost:3000/#/login";
    @Getter private static final int EXP_TIME_WAIT=20;
    @Getter private static final String LOGIN_JSON_PATH  = System.getProperty("user.dir")+"/src/test/resources/jsons/new-user.json";

    /*BEARER value is not the constant one*/
    @Getter private static final String BEARER_AUTH="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdGF0dXMiOiJzdWNjZXNzIiwiZGF0YSI6eyJpZCI6MjIsInVzZXJuYW1lIjoiIiwiZW1haWwiOiJyYWd1c3VuZGFyOTM1QGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiM2UyNzZhZDkxZTk3OWViZjZlZTdhYjQyMDEzYjUwNmIiLCJyb2xlIjoiY3VzdG9tZXIiLCJkZWx1eGVUb2tlbiI6IiIsImxhc3RMb2dpbklwIjoidW5kZWZpbmVkIiwicHJvZmlsZUltYWdlIjoiL2Fzc2V0cy9wdWJsaWMvaW1hZ2VzL3VwbG9hZHMvZGVmYXVsdC5zdmciLCJ0b3RwU2VjcmV0IjoiIiwiaXNBY3RpdmUiOnRydWUsImNyZWF0ZWRBdCI6IjIwMjQtMDctMDcgMDg6MjM6MzkuNjg3ICswMDowMCIsInVwZGF0ZWRBdCI6IjIwMjQtMDctMDcgMDg6MjY6MjcuNzI3ICswMDowMCIsImRlbGV0ZWRBdCI6bnVsbH0sImlhdCI6MTcyMDM0MDg1MH0.SQ8O_bfqCjzPOC_d3qYqCZx70zY_iFingq3QYDG7VmaAzWSPwQgZVFuZZTMk-K3vGqnglc2Dw-kYEY54kCHdgT5734D2Gd7ENr3yl193_rSL0X6dE72l5gjhVTiBPMvOd9E9GmgC3uOL33vNYnCftsH0-3Tv_voS6Wh2ROPCTjg";

}
