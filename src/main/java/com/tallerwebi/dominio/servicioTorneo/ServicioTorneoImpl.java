package com.tallerwebi.dominio.servicioTorneo;

import com.tallerwebi.dominio.servicioUsuario.Usuario;
import com.tallerwebi.infraestructura.repositorioTorneo.RepositorioTorneo;
import com.tallerwebi.infraestructura.repositorioUsuario.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;


@Service("servicioTorneo")
@Transactional
public class ServicioTorneoImpl implements ServicioTorneo {

    private RepositorioTorneo repositorioTorneo;

    @Autowired
    public ServicioTorneoImpl(RepositorioTorneo repositorioTorneo) {
        this.repositorioTorneo = repositorioTorneo;

    }


}
