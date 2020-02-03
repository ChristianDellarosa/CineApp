package com.web.appcine.model;

import java.util.Date;

public class Pelicula {
    private int id;
    private String titulo;
    private int duracion;
    private String clasificacion;
    private String genero;
    private String imagen;
    private Date fechaEstreno;
    private String status;
    private DetallePelicula detalle;

    public Pelicula() {
    }

    public Pelicula(int id,String titulo, int duracion, String clasificacion, String genero, Date fechaEstreno, String imagen,String status) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
        this.imagen = imagen;
        this.status = status;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public void setStatus(String status) {
     this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public DetallePelicula getDetalle() {
        return detalle;
    }

    public void setDetalle(DetallePelicula detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", genero='" + genero + '\'' +
                ", imagen='" + imagen + '\'' +
                ", fechaEstreno=" + fechaEstreno +
                ", status='" + status + '\'' +
                ", detalle=" + detalle +
                '}';
    }
}
