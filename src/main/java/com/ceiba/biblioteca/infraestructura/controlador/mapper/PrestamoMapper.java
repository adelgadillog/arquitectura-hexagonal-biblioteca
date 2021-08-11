package com.ceiba.biblioteca.infraestructura.controlador.mapper;

import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;
import com.ceiba.biblioteca.infraestructura.controlador.model.CrearPrestamoDTO;
import com.ceiba.biblioteca.infraestructura.controlador.model.ResponsePrestamoCreado;

public class PrestamoMapper {
    public PrestamoMapper() {
    }

    public static CrearPrestamo crearPrestamo(CrearPrestamoDTO crearPrestamoDTO){

        return new CrearPrestamo(crearPrestamoDTO.getIsbn(),crearPrestamoDTO.getIdentificacionUsuario(),crearPrestamoDTO.getTipoUsuario());
    }

    public static ResponsePrestamoCreado responsePrestamo(PrestamoCreado prestamoCreado){

        return new ResponsePrestamoCreado(prestamoCreado.getId(),prestamoCreado.getFechaMaximaDevolucion());
    }
}
