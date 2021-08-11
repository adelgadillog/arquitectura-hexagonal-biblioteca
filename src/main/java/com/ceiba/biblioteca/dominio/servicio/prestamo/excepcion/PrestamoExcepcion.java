package com.ceiba.biblioteca.dominio.servicio.prestamo.excepcion;

public class PrestamoExcepcion extends Exception{
    public PrestamoExcepcion (String mensaje, Throwable causa)
    {
        super(mensaje, causa);
    }
}
