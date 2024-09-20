package com.tallerwebi.dominio.servicioRegistroEquipo;

import com.tallerwebi.dominio.servicioUsuario.Usuario;

public interface ServicioRegistroEquipo {
    Boolean verificaElNombreDelEquipoYLosUsuarios(String nombreEquipo, String usuario1, String usuario2);

    String verificarUsuario(String usuario1);

    Usuario verificarUsuario(Usuario usuario1);

    Boolean verificarNombre(String nombreEquipo);
}
