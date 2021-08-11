package com.ceiba.biblioteca.infraestructura.persistencia.repositorio;

import com.ceiba.biblioteca.dominio.servicio.prestamo.excepcion.PrestamoExcepcion;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.CrearPrestamo;
import com.ceiba.biblioteca.dominio.servicio.prestamo.model.PrestamoCreado;
import com.ceiba.biblioteca.dominio.servicio.prestamo.repositorio.IPrestamoRepositorio;
import com.ceiba.biblioteca.infraestructura.persistencia.entidad.PrestamoEntidad;
import com.ceiba.biblioteca.infraestructura.persistencia.mapper.PrestamoMapper;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PrestamoRepositorio implements IPrestamoRepositorio {

    @Autowired
    private IPrestamoRepositorioJPA prestamoRepositorioJPA;

    @Override
    public PrestamoCreado crearPrestamo(CrearPrestamo crearPrestamo) {
        PrestamoEntidad prestamoEntidad = prestamoRepositorioJPA.save(PrestamoMapper.crearPrestamoAEntidad(crearPrestamo));
        return PrestamoMapper.entidadAPrestamo(prestamoEntidad);
    }

    @Override
    public PrestamoCreado obtenerPrestamo(Long idPrestamo) throws PrestamoExcepcion {
        Optional<PrestamoEntidad> prestamoEntidad = prestamoRepositorioJPA.findById(idPrestamo);
        if(prestamoEntidad.isPresent()){
            return PrestamoMapper.entidadAPrestamo(prestamoEntidad.get());
        } else {
            throw new PrestamoExcepcion("El prestamo solicitado no existe", new BadHttpRequest());
        }

    }

    @Override
    public List<PrestamoCreado> obtenerPrestamos(String identificacionUsuario) {
        List<PrestamoEntidad> listaPrestamoEntidad = prestamoRepositorioJPA.findByidentificacionUsuario(identificacionUsuario);
        List<PrestamoCreado> listaPrestamoCreado = new ArrayList<>();
        for(PrestamoEntidad prestamoEntidad : listaPrestamoEntidad){
            listaPrestamoCreado.add(PrestamoMapper.entidadAPrestamo(prestamoEntidad));
        }
        return listaPrestamoCreado;
    }
}
