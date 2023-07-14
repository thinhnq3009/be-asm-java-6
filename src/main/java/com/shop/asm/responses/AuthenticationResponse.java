package com.shop.asm.responses;


import com.shop.asm.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    String token;

    UserDto user;
}
