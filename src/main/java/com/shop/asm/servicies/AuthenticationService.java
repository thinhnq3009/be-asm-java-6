package com.shop.asm.servicies;

import com.shop.asm.auth.Role;
import com.shop.asm.dto.UserDto;
import com.shop.asm.entity.User;
import com.shop.asm.repositories.UserRepository;
import com.shop.asm.requests.AuthenticateRequest;
import com.shop.asm.requests.RegisterRequest;
import com.shop.asm.responses.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        User user = User
                .builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullname(request.getFullname())
                .phone(request.getPhone())
                .email(request.getEmail())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(token)
                .user(userService.convertToDto(user))
                .build();
    }

    public AuthenticationResponse login(AuthenticateRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();

        }

        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());

        String token = jwtService.generateToken(userDetails);

        return AuthenticationResponse
                .builder()
                .token(token)
                .user(userService.convertToDto((User) userDetails))
                .build();


    }

    public AuthenticationResponse authenticate(String token) {


            UserDto userDto = jwtService.extractUserDto(token);

            return
                    AuthenticationResponse
                            .builder()
                            .token(token)
                            .user(userDto)
                            .build();


    }
}
