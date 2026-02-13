package com.example.sreiw.services;

import com.example.sreiw.dtos.request.LoginRequestDTO;
import com.example.sreiw.dtos.response.LoginResponseDTO;
import com.example.sreiw.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class AuthService {

    private final AuthRepository repo;

    public AuthService(AuthRepository repo) {
        this.repo = repo;
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {
        return repo.login(dto.correo, dto.contrasena);
    }
}
