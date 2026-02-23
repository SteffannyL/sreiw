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

    /* =========================
            LISTAR
    ========================= */
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    /* =========================
            OBTENER POR ID
    ========================= */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = service.obtenerPorId(id);

        return usuario
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /* =========================
            CREAR
    ========================= */
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.crear(usuario);
    }

    /* =========================
            ACTUALIZAR
    ========================= */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuarioActualizado) {

        Optional<Usuario> usuarioOpt = service.obtenerPorId(id);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioOpt.get();

        usuario.setNombres(usuarioActualizado.getNombres());
        usuario.setCorreo(usuarioActualizado.getCorreo());
        usuario.setIdtipousuario(usuarioActualizado.getIdtipousuario());
        usuario.setActivo(usuarioActualizado.isActivo());

        return ResponseEntity.ok(service.actualizar(usuario));
    }

    /* =========================
            ELIMINAR
    ========================= */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        Optional<Usuario> usuarioOpt = service.obtenerPorId(id);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    /* =========================
        CAMBIAR ESTADO
    ========================= */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Usuario> cambiarEstado(
            @PathVariable Long id,
            @RequestParam boolean activo) {

        Optional<Usuario> usuarioOpt = service.obtenerPorId(id);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setActivo(activo);

        return ResponseEntity.ok(service.actualizar(usuario));
    }

    /* =========================
            LOGIN
    ========================= */
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