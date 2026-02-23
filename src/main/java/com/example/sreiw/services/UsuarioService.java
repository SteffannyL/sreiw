package com.example.sreiw.services;

import com.example.sreiw.entities.Usuario;
import com.example.sreiw.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository,
                          PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Usuario> login(String correo, String contrasena) {

        correo = correo.trim();
        contrasena = contrasena.trim();

        Optional<Usuario> usuarioOpt = repository.findByCorreo(correo);
        if (usuarioOpt.isEmpty()) return Optional.empty();

        Usuario usuario = usuarioOpt.get();

        // Comparación de hashes
        if (!passwordEncoder.matches(contrasena, usuario.getContrasena()))
            return Optional.empty();

        // Validar que esté activo
        if (!Boolean.TRUE.equals(usuario.isActivo()))
            return Optional.empty();

        return Optional.of(usuario);
    }

    //LISTAR
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // OBTENER POR ID
    public Optional<Usuario> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    // CREAR
    public Usuario crear(Usuario usuario) {

        // Contraseña hasheada
        String hash = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(hash);

        return repository.save(usuario);
    }

    //ACTUALIZAR
    public Usuario actualizar(Usuario usuario) {
        return repository.save(usuario);
    }

    // ACTIVAR o DESACTIVAR USUARIO
    public void cambiarEstado(Long id, boolean activo) {
        Optional<Usuario> usuarioOpt = repository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setActivo(activo);
            repository.save(usuario);
        }
    }
    public void eliminar(Long id) {
    repository.deleteById(id);
}
}
