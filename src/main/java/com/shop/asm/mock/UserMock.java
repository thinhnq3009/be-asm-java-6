package com.shop.asm.mock;

import com.shop.asm.auth.Role;
import com.shop.asm.entity.User;
import com.shop.asm.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class UserMock {

    private final UserRepository userRepository;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return  args -> {
            List<User> users = new ArrayList<>();
            users.add(new User(null, "quocthinhtme", "123qwe", "Nguyễn Quốc Thịnh", "0383914506", "quocthinhtme@gamil.com", Role.USER));
            users.add(new User(null, "diemmy", "123qwe", "Nguyễn Quốc Diễm My", "0383914506", "quocthinhtme@gamil.com", Role.USER));
            userRepository.saveAll(users);
        };
    }

}
