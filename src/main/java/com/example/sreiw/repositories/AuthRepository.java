package com.example.sreiw.repositories;

import com.example.sreiw.dtos.response.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AuthRepository {

    private final JdbcTemplate jdbc;

    public AuthRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public LoginResponseDTO login(String correo, String contrasena) {
        return jdbc.queryForObject(
                "SELECT * FROM fn_login_usuario(?,?)",
                (rs, rowNum) -> {
                    LoginResponseDTO dto = new LoginResponseDTO();
                    dto.idUsuario = rs.getInt("id_usuario");
                    dto.nombres = rs.getString("nombres");
                    dto.tipoUsuario = rs.getInt("id_tipousuario");
                    return dto;
                },
                correo, contrasena
        );
    }
}
