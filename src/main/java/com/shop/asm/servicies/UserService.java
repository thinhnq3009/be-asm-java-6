package com.shop.asm.servicies;

import com.shop.asm.dto.UserDto;
import com.shop.asm.entity.User;
import com.shop.asm.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsernameOrEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    public UserDto convertToDto(User user) {
        return UserDto
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullname(user.getFullname())
                .phone(user.getPhone())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
