package com.ceiba.biblioteca.infraestructura.controlador.model;

public class PrestamoNoPermitido {
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public PrestamoNoPermitido(String mensaje) {
        this.mensaje = mensaje;
    }
}
