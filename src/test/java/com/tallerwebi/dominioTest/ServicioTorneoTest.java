package com.tallerwebi.dominioTest;

import com.tallerwebi.dominio.servicioTorneo.ServicioTorneo;
import com.tallerwebi.dominio.servicioTorneo.ServicioTorneoImpl;
import com.tallerwebi.infraestructura.repositorioTorneo.RepositorioTorneo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.mock;

public class ServicioTorneoTest {

    private ServicioTorneo servicioTorneo;
    private RepositorioTorneo repositorioTorneo;

    @BeforeEach
    public void setUp() throws Exception {                          //estoy inyectando una instancia con mockito
        this.repositorioTorneo=  mock(RepositorioTorneo.class); //este es un falso repositorio
        this.servicioTorneo =  new ServicioTorneoImpl(repositorioTorneo);
    }

    @Test
    public void siNoHayUsuariosDeberiaDevolverUnaLista(){


    }


}
