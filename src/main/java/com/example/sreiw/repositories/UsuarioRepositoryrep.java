package com.example.sreiw.repositories;

import com.example.sreiw.dtos.request.RegistroUsuarioRequestDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryrep {

    private final JdbcTemplate jdbc;

    public UsuarioRepositoryrep(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Crear usuario
    public void crearUsuario(RegistroUsuarioRequestDTO dto) {
        jdbc.update("""
            CALL sp_crear_usuario(?, ?, ?, ?, ?, ?)
        """,
                dto.id,
                dto.tipoUsuario,
                dto.nombres,
                dto.apellidos,
                dto.correo,
                dto.contrasena
        );
    }

    // Solicitud de validación de rol
    public void solicitarRol(
            Integer idValidacion,
            Integer usuario,
            Integer rol,
            Integer facultad,
            Integer carrera,
            String documento
    ) {
        jdbc.update("""
            CALL sp_solicitar_validacion_rol(?, ?, ?, ?, ?, ?)
        """,
                idValidacion,
                usuario,
                rol,
                facultad,
                carrera,
                documento
        );
    }
}
