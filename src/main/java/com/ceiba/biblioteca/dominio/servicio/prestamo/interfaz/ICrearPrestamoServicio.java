package com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz;

import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;

public interface ICrearPrestamoServicio {
    PrestamoCreado crearPrestamo(CrearPrestamo CrearPrestamo) throws Exception;

}
