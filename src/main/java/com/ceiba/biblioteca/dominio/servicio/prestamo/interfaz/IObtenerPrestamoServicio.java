package com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz;

import com.ceiba.biblioteca.dominio.servicio.prestamo.excepcion.PrestamoExcepcion;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;

import java.util.List;

public interface IObtenerPrestamoServicio {
    PrestamoCreado obtenerPrestamo(Long idPrestamo) throws PrestamoExcepcion;
    List<PrestamoCreado> obtenerPrestamos(String identificacionUsuario);

}
