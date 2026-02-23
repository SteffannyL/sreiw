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
    public String getApellidos() {return apellidos;}
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
    public Boolean getActivo() { return activo; }
    public Long getIdtipousuario() { return idtipousuario; }
    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
        public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
        public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setIdtipousuario(Long idtipousuario) {
        this.idtipousuario = idtipousuario;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public boolean isActivo() {
        return Boolean.TRUE.equals(activo);
    }
}
