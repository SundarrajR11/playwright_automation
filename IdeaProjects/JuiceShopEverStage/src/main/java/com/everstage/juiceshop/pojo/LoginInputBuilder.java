package com.everstage.juiceshop.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginInputBuilder {
    private String email;
    private String password;
    private String product;
    private String nameForAddressSelection;
    private String deliveryType;
    private String cardHolderNameForCardSelection;
}
