package com.everstage.juiceshop.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadAndWriter {
    private FileReadAndWriter(){}

    @SneakyThrows
    public static String readJsonAndReturnAsString(String filePath){
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        return new String(bytes);
    }

    @SneakyThrows
    public static void writeJsonAndStoreAsString(String filePath, Response responseBody){
        Files.write(Paths.get(filePath),responseBody.asByteArray());
    }
}
