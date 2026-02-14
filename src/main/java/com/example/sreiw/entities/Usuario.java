package com.example.sreiw.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    private Long idtipousuario;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasena;
    private Boolean activo;
    private LocalDateTime fecharegistro;
    private Long idempresa;

    public Long getIdusuario() { return idusuario; }
    public String getNombres() { return nombres; }
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
    public Boolean getActivo() { return activo; }
    public Long getIdtipousuario() { return idtipousuario; }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
