package com.ceiba.biblioteca.dominio.servicio.prestamo;

import com.ceiba.biblioteca.dominio.servicio.prestamo.excepcion.PrestamoExcepcion;
import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.IObtenerPrestamoServicio;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;
import com.ceiba.biblioteca.dominio.servicio.prestamo.repositorio.IPrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerPrestamoServicio implements IObtenerPrestamoServicio {

    @Autowired
    private IPrestamoRepositorio prestamoRepositorio;

    @Override
    public PrestamoCreado obtenerPrestamo(Long idPrestamo) throws PrestamoExcepcion {
        return prestamoRepositorio.obtenerPrestamo(idPrestamo);
    }

    @Override
    public List<PrestamoCreado> obtenerPrestamos(String identificacionUsuario) {
        return prestamoRepositorio.obtenerPrestamos(identificacionUsuario);
    }


}
