package com.ceiba.biblioteca.infraestructura.controlador.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResponsePrestamoCreado {
    private Long id;
    private String fechaMaximaDevolucion;

    public ResponsePrestamoCreado(Long id, String fechaMaximaDevolucion) {
        this.id = id;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(Date fechaMaximaDevolucion) {

        this.fechaMaximaDevolucion = new SimpleDateFormat("dd/MM/yyyy").format(fechaMaximaDevolucion);
    }
}
