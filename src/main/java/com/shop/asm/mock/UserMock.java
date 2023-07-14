package com.shop.asm.mock;

import com.shop.asm.auth.Role;
import com.shop.asm.entity.User;
import com.shop.asm.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class UserMock {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Bean
    public CommandLineRunner userMockData() {
        return  args -> {
            List<User> users = new ArrayList<>();

            User user1 = User.builder()
                    .username("user1")
                    .password(passwordEncoder.encode("password1"))
                    .fullname("User 1")
                    .phone("123456789")
                    .email("user1@example.com")
                    .role(Role.USER)
                    .build();

            User user2 = User.builder()
                    .username("user2")
                    .password(passwordEncoder.encode("password2"))
                    .fullname("User 2")
                    .phone("987654321")
                    .email("user2@example.com")
                    .role(Role.USER)
                    .build();

            User user3 = User.builder()
                    .username("user3")
                    .password(passwordEncoder.encode("password3"))
                    .fullname("User 3")
                    .phone("555555555")
                    .email("user3@example.com")
                    .role(Role.ADMIN)
                    .build();

            User user4 = User.builder()
                    .username("user4")
                    .password(passwordEncoder.encode("password4"))
                    .fullname("User 4")
                    .phone("111111111")
                    .email("user4@example.com")
                    .role(Role.USER)
                    .build();

            User user5 = User.builder()
                    .username("quocthinhtme")
                    .password(passwordEncoder.encode("123132"))
                    .fullname("User 5")
                    .phone("999999999")
                    .email("user5@example.com")
                    .role(Role.USER)
                    .build();

            users.add(user1);
            users.add(user2);
            users.add(user3);
            users.add(user4);
            users.add(user5);

            userRepository.saveAll(users);
        };
    }

}
