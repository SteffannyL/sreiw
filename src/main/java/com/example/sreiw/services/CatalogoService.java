package com.example.sreiw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CatalogoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // LISTAR
    public List<Map<String, Object>> listar(String tabla) {

        return jdbcTemplate.queryForList(
            "SELECT * FROM " + tabla + " ORDER BY 1"
        );
    }

    // INSERTAR
    public void insertar(String tabla, String nombre) {

        jdbcTemplate.update(
            "CALL spcatalogomodificar(?, ?, ?, ?)",
            tabla,
            "insert",
            null,
            nombre
        );
    }

    // ACTUALIZAR
    public void actualizar(String tabla, Long id, String nombre) {

        jdbcTemplate.update(
            "CALL spcatalogomodificar(?, ?, ?, ?)",
            tabla,
            "update",
            id,
            nombre
        );
    }

    // ELIMINAR
    public void eliminar(String tabla, Long id) {

        jdbcTemplate.update(
            "CALL spcatalogomodificar(?, ?, ?, ?)",
            tabla,
            "delete",
            id,
            null
        );
    }
}