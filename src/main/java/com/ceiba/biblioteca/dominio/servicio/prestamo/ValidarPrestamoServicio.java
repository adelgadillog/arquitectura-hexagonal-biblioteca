package com.ceiba.biblioteca.dominio.servicio.prestamo;

import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.IObtenerPrestamoServicio;
import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.IValidarPrestamoServicio;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ValidarPrestamoServicio implements IValidarPrestamoServicio {
    @Autowired
    IObtenerPrestamoServicio obtenerPrestamoServicio;


    @Override
    public Boolean existPrestamoByIdentificacionUsuario(CrearPrestamo crearPrestamo) {
        return obtenerPrestamoServicio.obtenerPrestamos(crearPrestamo.getIdentificacionUsuario()).stream()
                .filter(prestamo -> prestamo.getIdentificacionUsuario()
                        .equals(crearPrestamo.getIdentificacionUsuario())
                        && new Date().before(new Date(prestamo.getFechaMaximaDevolucion()))).findFirst().isPresent();
    }
}
