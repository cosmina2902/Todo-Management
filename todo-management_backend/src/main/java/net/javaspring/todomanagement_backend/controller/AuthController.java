package net.javaspring.todomanagement_backend.controller;


import lombok.AllArgsConstructor;
import net.javaspring.todomanagement_backend.dto.LoginDto;
import net.javaspring.todomanagement_backend.dto.RegisterDto;
import net.javaspring.todomanagement_backend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){

       String response = authService.register(registerDto);
       return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){

        String response = authService.login(loginDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
