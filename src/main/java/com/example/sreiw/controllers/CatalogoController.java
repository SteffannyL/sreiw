package com.example.sreiw.controllers;

import com.example.sreiw.services.CatalogoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/catalogos")
@CrossOrigin(origins = "*")
public class CatalogoController {

    @Autowired
    private CatalogoService service;

    @GetMapping("/{tabla}")
    public List<Map<String, Object>> listar(
            @PathVariable String tabla) {

        return service.listar(tabla);
    }

    @PostMapping("/{tabla}")
    public void insertar(
            @PathVariable String tabla,
            @RequestBody Map<String, String> body) {

        service.insertar(tabla, body.get("nombre"));
    }

    @PutMapping("/{tabla}/{id}")
    public void actualizar(
            @PathVariable String tabla,
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {

        service.actualizar(tabla, id, body.get("nombre"));
    }

    @DeleteMapping("/{tabla}/{id}")
    public void eliminar(
            @PathVariable String tabla,
            @PathVariable Long id) {

        service.eliminar(tabla, id);
    }
}