package net.javaspring.todomanagement_backend.service;

import net.javaspring.todomanagement_backend.dto.LoginDto;
import net.javaspring.todomanagement_backend.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
