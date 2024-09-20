package com.tallerwebi.dominio.servicioRegistroEquipo;


import com.tallerwebi.dominio.servicioUsuario.Usuario;
import com.tallerwebi.infraestructura.repositorioUsuario.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroEquipoImpl implements ServicioRegistroEquipo{

    private RepositorioUsuario repositorioUsuario;

    @Autowired //esto le inyecta la dependencia a repositorioUsuario siendo un = new RepositorioUsuario();
    public ServicioRegistroEquipoImpl(RepositorioUsuario repositorioUsuario){

        this.repositorioUsuario = repositorioUsuario;
    }


    @Override
    public Boolean verificaElNombreDelEquipoYLosUsuarios(String nombreEquipo, String usuario1, String usuario2) {
        return true;
    }

    @Override
    public String verificarUsuario(String usuario1) {
        return repositorioUsuario.buscarUsuario(usuario1);
    }

    @Override
    public Usuario verificarUsuario(Usuario usuario1) {
        return repositorioUsuario.buscarUsuario(usuario1);
    }

    @Override
    public Boolean verificarNombre(String nombreEquipo) {
        return null;
    }
}
