package com.shop.asm.responses;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public  class RespontObject<T> {

    private String message;

    private String status;

    private T data;



}
