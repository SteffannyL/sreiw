package com.example.sreiw.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AuthRepository {

    private final JdbcTemplate jdbc;

    public AuthRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Map<String, Object> buscarPorCorreo(String correo) {
        return jdbc.queryForMap(
                "SELECT * FROM fnloginusuario(?)",
                correo
        );
    }
    public void insertarUsuario(
        String nombres,
        String apellidos,
        String correo,
        String contrasena,
        int idTipoUsuario) {

    jdbc.update(
        "CALL spcrearusuario(?,?,?,?,?)",
        nombres,
        apellidos,
        correo,
        contrasena,
        idTipoUsuario
    );
}

}
