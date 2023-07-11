package com.shop.asm.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class DemoController {

    @GetMapping("/api/v1/demo")
    ResponseEntity<String> demo(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok( "Hello " + (name == null ? "Spring" : name));
    }


}
