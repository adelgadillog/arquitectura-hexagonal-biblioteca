package com.ceiba.biblioteca.aplicacion.servicio;

import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.IObtenerPrestamoServicio;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ObtenerPrestamo {

    @Autowired
    private IObtenerPrestamoServicio obtenerPrestamoServicio;

    public PrestamoCreado obtenerPrestamoCreado(Long idPrestamo) throws Exception {
        return obtenerPrestamoServicio.obtenerPrestamo(idPrestamo);
    }

}
