package com.example.sreiw.controllers;

import com.example.sreiw.entities.EventoPostulacionDTO;
import com.example.sreiw.services.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping("/postular")
    public ResponseEntity<?> crearPostulacion(
            @RequestBody EventoPostulacionDTO dto) {

        service.crearPostulacion(dto);
        return ResponseEntity.ok("Evento postulado correctamente");
    }
}