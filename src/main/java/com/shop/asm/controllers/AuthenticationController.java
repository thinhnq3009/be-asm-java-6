package com.shop.asm.controllers;


import com.shop.asm.requests.AuthenticateRequest;
import com.shop.asm.requests.RegisterRequest;
import com.shop.asm.responses.AuthenticationResponse;
import com.shop.asm.responses.base.ResponseObjects;
import com.shop.asm.responses.base.ResponseObject;
import com.shop.asm.servicies.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseObject<AuthenticationResponse>> register(
            @RequestBody RegisterRequest request
    ) {

        AuthenticationResponse response = authService.register(request);

        return ResponseObjects.getResponseEntity(
                response,
                "Đăng ký thành thành công"
        );
    }


    @PostMapping("/login")
    public ResponseEntity<ResponseObject<AuthenticationResponse>> authenticate(
            @RequestBody AuthenticateRequest request
            ) {
        AuthenticationResponse response = authService.login(request);

        return ResponseObjects.getResponseEntity(
                response,
                "Xát thực thành công"
        );
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseObject<AuthenticationResponse>> authenticate(
            @RequestParam("token") String token){
//            @RequestBody Token token){

        logger.info("token: {}", token);

        AuthenticationResponse response =  authService.authenticate(token);
//        AuthenticationResponse response =  authService.authenticate(token.getToken());

        return ResponseObjects.getResponseEntity(
                response,
                "Xát thực thành công"
        );
    }
}
