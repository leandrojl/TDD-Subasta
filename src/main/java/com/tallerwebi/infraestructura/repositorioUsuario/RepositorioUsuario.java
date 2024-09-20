package com.tallerwebi.infraestructura.repositorioUsuario;

import com.tallerwebi.dominio.servicioUsuario.Usuario;

import java.util.List;

public interface RepositorioUsuario {

    Usuario buscarUsuario(String email, String password);
    void guardar(Usuario usuario);
    Usuario buscar(String email);
    void modificar(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario crearUsuario(Usuario usuario);

    String buscarUsuario(String usuario1);

    Usuario buscarUsuario(Usuario usuario1);
}

