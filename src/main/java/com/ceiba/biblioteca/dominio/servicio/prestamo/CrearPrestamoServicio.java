package com.ceiba.biblioteca.dominio.servicio.prestamo;

import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.IObtenerPrestamoServicio;
import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.ICrearPrestamoServicio;
import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.IValidarPrestamoServicio;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;
import com.ceiba.biblioteca.dominio.servicio.prestamo.excepcion.PrestamoExcepcion;
import com.ceiba.biblioteca.constantes.ConstantesTipoUsuario;
import com.ceiba.biblioteca.dominio.servicio.prestamo.repositorio.IPrestamoRepositorio;
import com.ceiba.biblioteca.infraestructura.persistencia.repositorio.IPrestamoRepositorioJPA;
import com.ceiba.biblioteca.utilidades.CalcularFecha;
import com.ceiba.biblioteca.utilidades.UtilidadesValidacion;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CrearPrestamoServicio implements ICrearPrestamoServicio {

    @Autowired
    private IPrestamoRepositorioJPA prestamoRepository;

    @Autowired
    private IValidarPrestamoServicio validatePrestamoService;

    @Autowired
    private IObtenerPrestamoServicio prestamoGetService;

    @Autowired
    private IPrestamoRepositorio prestamoRepositorio;

    @Override
    public PrestamoCreado crearPrestamo(CrearPrestamo crearPrestamo) throws Exception {

        ValidarTipoUsuario(crearPrestamo);

        crearPrestamo.setFechaMaximaDevolucion(CalcularFecha.calcularFechaDevolucion(new Date(),crearPrestamo.getTipoUsuario().intValue()));
        if(existePrestamoInvitado(crearPrestamo)){
            throw new PrestamoExcepcion("El usuario con identificación " + crearPrestamo.getIdentificacionUsuario()
                    + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo", new BadHttpRequest());
        } else {

            return prestamoRepositorio.crearPrestamo(crearPrestamo);
        }

    }

    private boolean existePrestamoInvitado(CrearPrestamo crearPrestamo) {
        return crearPrestamo.getTipoUsuario().equals(ConstantesTipoUsuario.USUARIO_INVITADO)
                && validatePrestamoService.existPrestamoByIdentificacionUsuario(crearPrestamo);
    }

    private void ValidarTipoUsuario(CrearPrestamo crearPrestamo) throws PrestamoExcepcion {
        if(!UtilidadesValidacion.getMapTipoUsuarioConstantes(crearPrestamo.getTipoUsuario())) {
            throw new PrestamoExcepcion("Tipo de usuario no permitido en la biblioteca", new BadHttpRequest());
        }
    }


}
