package com.everstage.juiceshop.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class LoginInputBuilder {
    private String email;
    private String password;
}
