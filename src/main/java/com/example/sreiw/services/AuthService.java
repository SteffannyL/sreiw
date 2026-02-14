package com.example.sreiw.services;

import com.example.sreiw.dtos.request.LoginRequestDTO;
import com.example.sreiw.dtos.request.RegistroUsuarioRequestDTO;
import com.example.sreiw.dtos.response.LoginResponseDTO;
import com.example.sreiw.repositories.AuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    private final AuthRepository repo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository repo,
                       PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {

     
        Map<String, Object> data =
                repo.buscarPorCorreo(dto.correo.trim());

        String hashGuardado =
                (String) data.get("contrasena");

        if (!passwordEncoder.matches(dto.contrasena, hashGuardado)) {
            throw new RuntimeException("Credenciales invalidas");
        }

        LoginResponseDTO response = new LoginResponseDTO();
        response.idusuario =
                ((Number) data.get("idusuario")).longValue();
        response.nombres =
                (String) data.get("nombres");
        response.idtipousuario =
                ((Number) data.get("idtipousuario")).longValue();

        return response;
    }
    public void registrar(RegistroUsuarioRequestDTO dto) {

    String hash = passwordEncoder.encode(dto.contrasena);

    repo.insertarUsuario(
        dto.nombres,
        dto.apellidos,
        dto.correo,
        hash,
        2 // usuario externo por defecto
    );
}


}
