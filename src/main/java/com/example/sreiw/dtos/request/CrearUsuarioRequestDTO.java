package com.example.sreiw.dtos.request;

public class CrearUsuarioRequestDTO {

    public Integer id;
    public Integer tipoUsuario;
    public String nombres;
    public String apellidos;
    public String correo;
    public String contrasena;
    public Integer facultad;
    public Integer carrera;
    // GETTERS
    public Integer getId() {
        return id;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Integer getFacultad() {
        return facultad;
    }

    public Integer getCarrera() {
        return carrera;
    }
}
