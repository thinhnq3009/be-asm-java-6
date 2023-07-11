package com.shop.asm.controllers;


import com.shop.asm.entity.User;
import com.shop.asm.requests.AuthenticateRequest;
import com.shop.asm.requests.RegisterRequest;
import com.shop.asm.responses.AuthenticationResponse;
import com.shop.asm.responses.ResponseObjects;
import com.shop.asm.responses.RespontObject;
import com.shop.asm.servicies.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<RespontObject<AuthenticationResponse>> register(
            @RequestBody RegisterRequest request
    ) {

        AuthenticationResponse response = authService.register(request);

        return ResponseObjects.getResponseEntity(
                response,
                "Đăng ký thành thành công"
        );
    }


    @PostMapping("/authenticate")
    public ResponseEntity<RespontObject<AuthenticationResponse>> authenticate(
            @RequestBody AuthenticateRequest request
            ) {
        AuthenticationResponse response = authService.authenticate(request);

        return ResponseObjects.getResponseEntity(
                response,
                "Xát thực thành công"
        );
    }

}
