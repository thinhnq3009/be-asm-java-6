package com.shop.asm.controllers;

import com.shop.asm.responses.HomePageResponse;
import com.shop.asm.responses.SidebarLayoutResponse;
import com.shop.asm.responses.base.ResponseObject;
import com.shop.asm.responses.base.ResponseObjects;
import com.shop.asm.servicies.RequireDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/requires")


public class RequireDataController {

    private final RequireDataService service;

    @GetMapping("/sidebar")
    ResponseEntity<ResponseObject<SidebarLayoutResponse>> getSidebarData() {

       SidebarLayoutResponse response = service.getSidebarLayoutData();

        return ResponseObjects
                .getResponseEntity(
                        response,
                        "Sidebar data fetched successfully"
                );
    }

    @GetMapping("/home")
    ResponseEntity<ResponseObject<HomePageResponse>> getHomePageData() {

       HomePageResponse response = service.getHomePageData(24);

        return ResponseObjects
                .getResponseEntity(
                        response,
                        "Home page data fetched successfully"
                );
    }
}
