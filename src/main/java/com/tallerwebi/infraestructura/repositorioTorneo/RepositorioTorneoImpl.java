package com.tallerwebi.infraestructura.repositorioTorneo;

import com.tallerwebi.dominio.servicioUsuario.Usuario;
import com.tallerwebi.infraestructura.repositorioUsuario.RepositorioUsuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioTorneo")
public class RepositorioTorneoImpl implements RepositorioTorneo {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTorneoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }




}

