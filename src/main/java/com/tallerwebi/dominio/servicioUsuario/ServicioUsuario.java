package com.tallerwebi.dominio.servicioUsuario;

import java.util.List;

public interface ServicioUsuario {


    List<Usuario> listarTodos();

    Usuario crearUsuario(Usuario usuario);
}
