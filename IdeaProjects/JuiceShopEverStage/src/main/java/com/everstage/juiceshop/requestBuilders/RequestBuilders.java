package com.everstage.juiceshop.requestBuilders;
import com.everstage.juiceshop.constants.FrameworkConstants;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public final class RequestBuilders {
    private RequestBuilders(){}

    public static RequestSpecification postCalls(){
        return given()
                .baseUri(FrameworkConstants.getBASE_URI())
                .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdGF0dXMiOiJzdWNjZXNzIiwiZGF0YSI6eyJpZCI6MjIsInVzZXJuYW1lIjoiIiwiZW1haWwiOiJyYWd1c3VuZGFyOTM1QGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiM2UyNzZhZDkxZTk3OWViZjZlZTdhYjQyMDEzYjUwNmIiLCJyb2xlIjoiY3VzdG9tZXIiLCJkZWx1eGVUb2tlbiI6IiIsImxhc3RMb2dpbklwIjoiMC4wLjAuMCIsInByb2ZpbGVJbWFnZSI6Ii9hc3NldHMvcHVibGljL2ltYWdlcy91cGxvYWRzL2RlZmF1bHQuc3ZnIiwidG90cFNlY3JldCI6IiIsImlzQWN0aXZlIjp0cnVlLCJjcmVhdGVkQXQiOiIyMDI0LTA3LTA1IDAyOjQ3OjM2LjU4NCArMDA6MDAiLCJ1cGRhdGVkQXQiOiIyMDI0LTA3LTA1IDAyOjQ3OjM2LjU4NCArMDA6MDAiLCJkZWxldGVkQXQiOm51bGx9LCJpYXQiOjE3MjAxNDc3ODN9.Fcn2gons5OSREwu-0a3aKF1mm7qYc8_KKnfmRct9mbneZgyMk6KwL6pwN_RsAbeL3FolEgn7wNMFwqE65WXqnAgv6nXH7BaRJA5ITQwswDI9vRUVhjFpQoDvjQ8_dl24pBFcqyeYBEZGXlNxVcpjFsiIJOFrLyqmpFW16NnWcks")
                .contentType(ContentType.JSON)
                .body("jds")
                .log()
                .all();
    }

    public static RequestSpecification getCalls(){
        return given()
                .baseUri(FrameworkConstants.getBASE_URI())
                .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdGF0dXMiOiJzdWNjZXNzIiwiZGF0YSI6eyJpZCI6MjIsInVzZXJuYW1lIjoiIiwiZW1haWwiOiJyYWd1c3VuZGFyOTM1QGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiM2UyNzZhZDkxZTk3OWViZjZlZTdhYjQyMDEzYjUwNmIiLCJyb2xlIjoiY3VzdG9tZXIiLCJkZWx1eGVUb2tlbiI6IiIsImxhc3RMb2dpbklwIjoiMC4wLjAuMCIsInByb2ZpbGVJbWFnZSI6Ii9hc3NldHMvcHVibGljL2ltYWdlcy91cGxvYWRzL2RlZmF1bHQuc3ZnIiwidG90cFNlY3JldCI6IiIsImlzQWN0aXZlIjp0cnVlLCJjcmVhdGVkQXQiOiIyMDI0LTA3LTA1IDAyOjQ3OjM2LjU4NCArMDA6MDAiLCJ1cGRhdGVkQXQiOiIyMDI0LTA3LTA1IDAyOjQ3OjM2LjU4NCArMDA6MDAiLCJkZWxldGVkQXQiOm51bGx9LCJpYXQiOjE3MjAxNDc3ODN9.Fcn2gons5OSREwu-0a3aKF1mm7qYc8_KKnfmRct9mbneZgyMk6KwL6pwN_RsAbeL3FolEgn7wNMFwqE65WXqnAgv6nXH7BaRJA5ITQwswDI9vRUVhjFpQoDvjQ8_dl24pBFcqyeYBEZGXlNxVcpjFsiIJOFrLyqmpFW16NnWcks")
                .contentType(ContentType.JSON)
                .log()
                .all();

    }
    public static RequestSpecification deleteCalls(){
        return given()
                .baseUri(FrameworkConstants.getBASE_URI())
                .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdGF0dXMiOiJzdWNjZXNzIiwiZGF0YSI6eyJpZCI6MjIsInVzZXJuYW1lIjoiIiwiZW1haWwiOiJyYWd1c3VuZGFyOTM1QGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiM2UyNzZhZDkxZTk3OWViZjZlZTdhYjQyMDEzYjUwNmIiLCJyb2xlIjoiY3VzdG9tZXIiLCJkZWx1eGVUb2tlbiI6IiIsImxhc3RMb2dpbklwIjoiMC4wLjAuMCIsInByb2ZpbGVJbWFnZSI6Ii9hc3NldHMvcHVibGljL2ltYWdlcy91cGxvYWRzL2RlZmF1bHQuc3ZnIiwidG90cFNlY3JldCI6IiIsImlzQWN0aXZlIjp0cnVlLCJjcmVhdGVkQXQiOiIyMDI0LTA3LTA1IDAyOjQ3OjM2LjU4NCArMDA6MDAiLCJ1cGRhdGVkQXQiOiIyMDI0LTA3LTA1IDAyOjQ3OjM2LjU4NCArMDA6MDAiLCJkZWxldGVkQXQiOm51bGx9LCJpYXQiOjE3MjAxNDc3ODN9.Fcn2gons5OSREwu-0a3aKF1mm7qYc8_KKnfmRct9mbneZgyMk6KwL6pwN_RsAbeL3FolEgn7wNMFwqE65WXqnAgv6nXH7BaRJA5ITQwswDI9vRUVhjFpQoDvjQ8_dl24pBFcqyeYBEZGXlNxVcpjFsiIJOFrLyqmpFW16NnWcks")
                .contentType(ContentType.JSON)
                .log()
                .all();

    }
}
