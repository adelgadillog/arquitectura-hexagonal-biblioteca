package com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz;

import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;

public interface IValidarPrestamoServicio {
    Boolean existPrestamoByIdentificacionUsuario(CrearPrestamo crearPrestamo);
}
