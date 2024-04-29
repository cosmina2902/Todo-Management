package net.javaspring.todomanagement_backend.service;

import net.javaspring.todomanagement_backend.dto.JwtAuthResponse;
import net.javaspring.todomanagement_backend.dto.LoginDto;
import net.javaspring.todomanagement_backend.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);
}
