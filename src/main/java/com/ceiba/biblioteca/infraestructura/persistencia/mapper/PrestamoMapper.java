package com.ceiba.biblioteca.infraestructura.persistencia.mapper;

import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;
import com.ceiba.biblioteca.infraestructura.persistencia.entidad.PrestamoEntidad;

public class PrestamoMapper {
    public PrestamoMapper() {

    }

    public static PrestamoCreado entidadAPrestamo(PrestamoEntidad prestamoEntidad){
        return new PrestamoCreado(prestamoEntidad.getId(), prestamoEntidad.getIsbn(),
                prestamoEntidad.getIdentificacionUsuario(), prestamoEntidad.getTipoUsuario(),
                prestamoEntidad.getFechaMaximaDevolucion());
    }

    public static PrestamoEntidad crearPrestamoAEntidad(CrearPrestamo crearPrestamo){
        return new PrestamoEntidad(crearPrestamo.getIsbn(),crearPrestamo.getIdentificacionUsuario(),
                crearPrestamo.getTipoUsuario(),crearPrestamo.getFechaMaximaDevolucion());
    }
}
