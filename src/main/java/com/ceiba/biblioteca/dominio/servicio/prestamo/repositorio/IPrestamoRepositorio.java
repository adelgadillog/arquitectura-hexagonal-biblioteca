package com.ceiba.biblioteca.dominio.servicio.prestamo.repositorio;

import com.ceiba.biblioteca.dominio.servicio.prestamo.excepcion.PrestamoExcepcion;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;

import java.util.List;

public interface IPrestamoRepositorio {

    PrestamoCreado crearPrestamo(CrearPrestamo crearPrestamo);
    PrestamoCreado obtenerPrestamo(Long idPrestamo) throws PrestamoExcepcion;
    List<PrestamoCreado> obtenerPrestamos(String identificacionUsuario);
}
