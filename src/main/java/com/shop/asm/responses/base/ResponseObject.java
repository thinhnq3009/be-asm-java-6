package com.shop.asm.responses.base;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public  class ResponseObject<T> {
    private String message;

    private String status;

    private T data;



}
