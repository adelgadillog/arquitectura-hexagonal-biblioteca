package com.ceiba.biblioteca.aplicacion.servicio;

import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.ICrearPrestamoServicio;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrarPrestamo {

    @Autowired
    private ICrearPrestamoServicio crearPrestamoServicio;

    public PrestamoCreado crearPrestamo(CrearPrestamo crearPrestamo) throws Exception {
        return crearPrestamoServicio.crearPrestamo(crearPrestamo);
    }

}
