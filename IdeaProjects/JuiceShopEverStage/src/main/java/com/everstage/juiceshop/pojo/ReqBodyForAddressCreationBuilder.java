package com.everstage.juiceshop.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class ReqBodyForAddressCreationBuilder {
    private String city;
    private String country;
    private String fullName;
    private long mobileNum;
    private String state;
    private String streetAddress;
    private String zipCode;
}
