package com.shop.asm.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class DemoController {

    ResponseEntity<String> demo(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok( "Hello " + (name == null ? "Spring" : name));
    }


}
