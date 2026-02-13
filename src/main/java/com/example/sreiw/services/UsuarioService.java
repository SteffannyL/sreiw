package com.example.sreiw.services;

import com.example.sreiw.entities.Usuario;
import com.example.sreiw.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Optional<Usuario> login(String correo, String contrasena) {
        correo = correo.trim();
        contrasena = contrasena.trim();

        Optional<Usuario> usuarioOpt = repository.findByCorreo(correo);

        if (usuarioOpt.isEmpty()) return Optional.empty();

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getContrasena().trim().equals(contrasena)) return Optional.empty();
        if (!Boolean.TRUE.equals(usuario.getActivo())) return Optional.empty();

        return Optional.of(usuario);
    }

    // 🔹 ESTE MÉTODO FALTABA
    public List<Usuario> listar() {
        return repository.findAll();
    }
}
