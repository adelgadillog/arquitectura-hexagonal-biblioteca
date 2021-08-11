package com.ceiba.biblioteca.infraestructura.persistencia.entidad;

import javax.persistence.*;

@Entity
@Table(name="prestamo_entity")
public class PrestamoEntidad {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String isbn;
    @Column(name= "identificacion_usuario",nullable = false)
    private String identificacionUsuario;
    @Column(name = "tipo_usuario",nullable = false)
    private Long tipoUsuario;
    @Column(name="fecha_maxima_devolucion",nullable = false)
    private String fechaMaximaDevolucion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public Long getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Long tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public PrestamoEntidad(String isbn, String identificacionUsuario, Long tipoUsuario, String fechaMaximaDevolucion) {
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public PrestamoEntidad() {
    }
}
