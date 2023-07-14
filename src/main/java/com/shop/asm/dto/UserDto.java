package com.shop.asm.dto;

import com.shop.asm.auth.Role;
import com.shop.asm.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullname = user.getFullname();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    private Long id;

    private String username;

    private String fullname;

    private String phone;

    private String email;

    private Role role;


}
