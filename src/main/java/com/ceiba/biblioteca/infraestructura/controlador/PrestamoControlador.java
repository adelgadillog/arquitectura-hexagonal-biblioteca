package com.ceiba.biblioteca.infraestructura.controlador;


import com.ceiba.biblioteca.aplicacion.servicio.ObtenerPrestamo;
import com.ceiba.biblioteca.aplicacion.servicio.RegistrarPrestamo;
import com.ceiba.biblioteca.dominio.servicio.prestamo.interfaz.IObtenerPrestamoServicio;
import com.ceiba.biblioteca.infraestructura.controlador.mapper.PrestamoMapper;
import com.ceiba.biblioteca.infraestructura.controlador.model.CrearPrestamoDTO;
import com.ceiba.biblioteca.infraestructura.controlador.model.PrestamoNoPermitido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {


    @Autowired
    IObtenerPrestamoServicio obtenerPrestamoServicio;
    @Autowired
    RegistrarPrestamo registrarPrestamo;
    @Autowired
    ObtenerPrestamo obtenerPrestamo;

    @GetMapping("/{id-prestamo}")
    public ResponseEntity obtenerPrestamo(@PathVariable("id-prestamo") Long idPrestamo) {
        try{
            return new ResponseEntity<>
                    (obtenerPrestamo.obtenerPrestamoCreado(idPrestamo), HttpStatus.OK);
        } catch (Exception e ){
            return new ResponseEntity<>(new PrestamoNoPermitido(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/obtener/{id-usuario}")
    public ResponseEntity obtenerPrestamos(@PathVariable("id-usuario") String identificacionUsuario){
        return new ResponseEntity<>(obtenerPrestamoServicio.obtenerPrestamos(identificacionUsuario), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity crearPrestamo(@RequestBody CrearPrestamoDTO crearPrestamoDTO) {
        try{
            return new ResponseEntity<>
                    (PrestamoMapper.responsePrestamo(registrarPrestamo.crearPrestamo(PrestamoMapper.crearPrestamo(crearPrestamoDTO))), HttpStatus.OK);

        } catch (Exception e ){
            return new ResponseEntity<>(new PrestamoNoPermitido(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}

