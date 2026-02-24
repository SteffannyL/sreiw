package com.example.sreiw.repositories;

import com.example.sreiw.entities.CatalogoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CatalogoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> listar(String tabla) {
        return jdbcTemplate.queryForList(
                "SELECT * FROM " + tabla + " ORDER BY 1"
        );
    }

    public void modificar(String tabla, String operacion,
                          Long id, String nombre) {

        jdbcTemplate.update(
            "CALL spcatalogomodificar(?, ?, ?, ?)",
            tabla,
            operacion,
            id,
            nombre
        );
    }
}