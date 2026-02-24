package com.example.sreiw.repositories;

import com.example.sreiw.entities.EventoPostulacionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void crearPostulacion(EventoPostulacionDTO dto) {

        jdbcTemplate.update(
            "CALL spcreareventopostulacion(?, ?, ?, ?, ?, ?, ?, ?, ?)",
            dto.getIdusuario(),
            dto.getIdambito(),
            dto.getNombreevento(),
            dto.getDescripcion(),
            dto.getFechainicio(),
            dto.getFechafin(),
            dto.getLugar(),
            dto.getAforo(),
            dto.getIdtipoevento()
        );
    }
}