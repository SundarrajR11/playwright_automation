package com.everstage.juiceshop.requestBuilders;

import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.enums.EHeaders;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
public final class RequestBuilders {
    private RequestBuilders(){}

    public static RequestSpecification postCalls() {
        return given()
                .baseUri(FrameworkConstants.getBASE_URI())
                .header(String.valueOf(EHeaders.AUTHORIZATION),FrameworkConstants.getBEARER_AUTH())
                .contentType(ContentType.JSON)
                .log()
                .all();
    }

    public static RequestSpecification getCalls(){
        return given()
                .baseUri(FrameworkConstants.getBASE_URI())
                .header(String.valueOf(EHeaders.AUTHORIZATION),FrameworkConstants.getBEARER_AUTH())
                .contentType(ContentType.JSON)
                .log()
                .all();

    }
    public static RequestSpecification deleteCalls(){
        return given()
                .baseUri(FrameworkConstants.getBASE_URI())
                .header(String.valueOf(EHeaders.AUTHORIZATION),FrameworkConstants.getBEARER_AUTH())
                .contentType(ContentType.JSON)
                .log()
                .all();

    }
}
