package com.shop.asm.requests;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;

    private String password;

    private String fullname;

    private String phone;

    private String email;
}
