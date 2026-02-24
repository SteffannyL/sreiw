package com.example.sreiw.entities;

import java.time.OffsetDateTime;

public class EventoPostulacionDTO {

    private Long idusuario;
    private Long idambito;
    private String nombreevento;
    private String descripcion;
    private OffsetDateTime fechainicio;
    private OffsetDateTime fechafin;
    private String lugar;
    private String aforo;
    private Long idtipoevento;

    public EventoPostulacionDTO() {}

    public Long getIdusuario() { return idusuario; }
    public void setIdusuario(Long idusuario) { this.idusuario = idusuario; }

    public Long getIdambito() { return idambito; }
    public void setIdambito(Long idambito) { this.idambito = idambito; }

    public String getNombreevento() { return nombreevento; }
    public void setNombreevento(String nombreevento) { this.nombreevento = nombreevento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public OffsetDateTime getFechainicio() { return fechainicio; }
    public void setFechainicio(OffsetDateTime fechainicio) { this.fechainicio = fechainicio; }

    public OffsetDateTime getFechafin() { return fechafin; }
    public void setFechafin(OffsetDateTime fechafin) { this.fechafin = fechafin; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public String getAforo() { return aforo; }
    public void setAforo(String aforo) { this.aforo = aforo; }

    public Long getIdtipoevento() { return idtipoevento; }
    public void setIdtipoevento(Long idtipoevento) { this.idtipoevento = idtipoevento; }
}