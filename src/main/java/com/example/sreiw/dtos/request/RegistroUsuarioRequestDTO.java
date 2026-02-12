package com.example.sreiw.dtos.request;

public class RegistroUsuarioRequestDTO {

    public Integer id;
    public Integer tipoUsuario;   // 1 = externo, 2 = estudiante, 3 = docente
    public Integer facultad;
    public Integer carrera;

    public String nombres;
    public String apellidos;
    public String correo;
    public String contrasena;
}
