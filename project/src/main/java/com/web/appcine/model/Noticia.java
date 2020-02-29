package com.web.appcine.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Noticias")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*No hace falta aplicar @Column ya que los campos se llaman igual en la base que en el modelo*/
    private String titulo;
    private Date fecha;
    private String detalle;
    private String status;

    public Noticia() {
        this.fecha = new Date();
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
