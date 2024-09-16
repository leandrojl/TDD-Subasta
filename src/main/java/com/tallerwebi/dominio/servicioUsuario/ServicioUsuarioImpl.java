package com.tallerwebi.dominio.servicioUsuario;

import com.tallerwebi.infraestructura.repositorioUsuario.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
    this.repositorioUsuario = repositorioUsuario;

    }

    @Override
    public List<Usuario> listarTodos() {

        return this.repositorioUsuario.listarTodos();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return this.repositorioUsuario.crearUsuario(usuario);
    }
}
