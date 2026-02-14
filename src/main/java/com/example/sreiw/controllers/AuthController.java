package com.example.sreiw.controllers;

import com.example.sreiw.dtos.request.LoginRequestDTO;
import com.example.sreiw.dtos.request.RegistroUsuarioRequestDTO;
import com.example.sreiw.dtos.response.LoginResponseDTO;
import com.example.sreiw.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
        return service.login(dto);
    }
@PostMapping("/register")
public Map<String, String> register(@RequestBody RegistroUsuarioRequestDTO dto) {

    service.registrar(dto);

    return Map.of(
        "mensaje", "Usuario registrado correctamente"
    );
}



}
