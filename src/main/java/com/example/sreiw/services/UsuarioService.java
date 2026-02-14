package com.example.sreiw.services;

import com.example.sreiw.entities.Usuario;
import com.example.sreiw.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Optional<Usuario> login(String correo, String contrasena) {

        correo = correo.trim();
        contrasena = contrasena.trim();

        Optional<Usuario> usuarioOpt = repository.findByCorreo(correo);
        if (usuarioOpt.isEmpty()) return Optional.empty();

        Usuario usuario = usuarioOpt.get();

        if (!passwordEncoder.matches(contrasena, usuario.getContrasena()))
            return Optional.empty();

        if (!Boolean.TRUE.equals(usuario.getActivo()))
            return Optional.empty();

        return Optional.of(usuario);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }
}
