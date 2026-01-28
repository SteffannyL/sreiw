package com.example.sreiw.services;

import com.example.sreiw.dtos.request.CrearUsuarioRequestDTO;
import com.example.sreiw.dtos.request.LoginRequestDTO;
import com.example.sreiw.dtos.response.UsuarioResponseDTO;
import com.example.sreiw.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public void crearUsuario(CrearUsuarioRequestDTO dto) {
        repo.crearUsuario(
                dto.id, dto.tipoUsuario,
                dto.nombres, dto.apellidos,
                dto.correo, dto.contrasena
        );
    }

    public UsuarioResponseDTO login(LoginRequestDTO dto) {
        Object[] r = repo.login(dto.correo, dto.contrasena).get(0);

        UsuarioResponseDTO u = new UsuarioResponseDTO();
        u.id = (Integer) r[0];
        u.nombres = (String) r[1];
        u.tipoUsuario = (Integer) r[2];

        return u;
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return repo.listarUsuarios().stream().map(r -> {
            UsuarioResponseDTO u = new UsuarioResponseDTO();
            u.id = (Integer) r[0];
            u.nombres = (String) r[1];
            u.tipoUsuario = (Integer) r[2];
            return u;
        }).toList();
    }

    public void desactivar(Integer id) {
        repo.desactivarUsuario(id);
    }
}
