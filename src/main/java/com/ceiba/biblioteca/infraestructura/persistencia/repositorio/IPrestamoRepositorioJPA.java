package com.ceiba.biblioteca.infraestructura.persistencia.repositorio;

import com.ceiba.biblioteca.infraestructura.persistencia.entidad.PrestamoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrestamoRepositorioJPA extends JpaRepository<PrestamoEntidad,Long>{
    List<PrestamoEntidad> findByidentificacionUsuario(String identificacionUsuario);

}
