package com.web.appcine.model;

import java.util.Date;

public class Noticia {

    private int id;
    private String titulo;
    private Date fecha;
    private String detalle;
    private String status;

    public Noticia(String titulo, String detalle, String status) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = new Date();
        this.status = status ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", detalle='" + detalle + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
