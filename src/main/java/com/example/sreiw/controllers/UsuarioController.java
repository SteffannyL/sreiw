package com.example.sreiw.controllers;

import com.example.sreiw.dtos.request.LoginRequestDTO;
import com.example.sreiw.entities.Usuario;
import com.example.sreiw.services.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /* ===== LISTAR ===== */
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {

        Optional<Usuario> usuarioOpt =
                service.login(dto.correo, dto.contrasena);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity
                    .status(401)
                    .body("Correo o contraseña incorrectos o usuario inactivo");
        }

        return ResponseEntity.ok(usuarioOpt.get());
    }
}
