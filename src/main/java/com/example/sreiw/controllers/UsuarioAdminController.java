package com.example.sreiw.controllers;

import com.example.sreiw.dtos.request.CrearUsuarioRequestDTO;
import com.example.sreiw.dtos.request.LoginRequestDTO;
import com.example.sreiw.dtos.response.UsuarioResponseDTO;
import com.example.sreiw.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioAdminController {

    private final UsuarioService service;

    public UsuarioAdminController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public UsuarioResponseDTO login(@RequestBody LoginRequestDTO dto) {
        return service.login(dto);
    }

    @PostMapping
    public void crear(@RequestBody CrearUsuarioRequestDTO dto) {
        service.crearUsuario(dto);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return service.listarUsuarios();
    }

    @PutMapping("/{id}/desactivar")
    public void desactivar(@PathVariable Integer id) {
        service.desactivar(id);
    }
}
