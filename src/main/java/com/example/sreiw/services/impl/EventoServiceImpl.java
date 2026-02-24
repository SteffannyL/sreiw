package com.example.sreiw.services.impl;

import com.example.sreiw.entities.EventoPostulacionDTO;
import com.example.sreiw.repositories.EventoRepository;
import com.example.sreiw.services.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository repository;

    @Override
    public void crearPostulacion(EventoPostulacionDTO dto) {
        repository.crearPostulacion(dto);
    }
}