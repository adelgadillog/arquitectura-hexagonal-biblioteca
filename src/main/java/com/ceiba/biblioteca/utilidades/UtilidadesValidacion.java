package com.ceiba.biblioteca.utilidades;

import com.ceiba.biblioteca.constantes.ConstantesTipoUsuario;

import java.util.HashMap;
import java.util.Map;

public class UtilidadesValidacion {

    public static Boolean getMapTipoUsuarioConstantes(Long tipoUsuario){
        Map<Long,String> mapTipoUsuarioConstant = new HashMap<>();
        mapTipoUsuarioConstant.put(ConstantesTipoUsuario.USUARIO_AFILIADO,"USUARIO_AFILIADO");
        mapTipoUsuarioConstant.put(ConstantesTipoUsuario.USUARIO_EMPLEADO,"USUARIO_EMPLEADO");
        mapTipoUsuarioConstant.put(ConstantesTipoUsuario.USUARIO_INVITADO,"USUARIO_INVITADO");

        return mapTipoUsuarioConstant.containsKey(tipoUsuario);
    }
}
