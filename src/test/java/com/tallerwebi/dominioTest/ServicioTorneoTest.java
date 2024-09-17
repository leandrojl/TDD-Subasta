package com.tallerwebi.dominioTest;

import com.tallerwebi.dominio.servicioTorneo.*;
import com.tallerwebi.dominio.servicioUsuario.Usuario;
import com.tallerwebi.infraestructura.repositorioTorneo.RepositorioTorneo;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.*;

public class ServicioTorneoTest {

    private ServicioTorneo servicioTorneo;
    private RepositorioTorneo repositorioTorneo;

    @BeforeEach
    public void setUp() throws Exception {                          //estoy inyectando una instancia con mockito
        this.repositorioTorneo=  mock(RepositorioTorneo.class); //este es un falso repositorio
        this.servicioTorneo =  new ServicioTorneoImpl(repositorioTorneo);
    }

    @Test
    public void queSePuedaCrearUnTorneoConUnNombreEId(){
        //given-when-that
        //dado que tengo un torneo
        Torneo torneo = new Torneo();
        String nombreEsperado = "Torneo Padel Maxi";
        Integer valorEsperado = 1;

        //cuando le asigno un nombre e id
        torneo.setId(1);
        torneo.setNombre("Torneo Padel Maxi");

        //cuando el servicio crea el torneo
        servicioTorneo.crearTorneo(torneo);
        when(repositorioTorneo.crearTorneo(torneo)).thenReturn(torneo);

        //entonces tengo un torneo con id y nombre
        assertThat(torneo.getNombre(), equalTo(nombreEsperado));
        assertThat(torneo.getId(), equalTo(valorEsperado));
        assertThat(torneo, notNullValue());
        //el verify verifica que dentro de RepositorioTorneoImpl se haya ejecutado alguna vez el metodo crearTorneo();
        verify(repositorioTorneo, times(1)).crearTorneo(any());


    }

    @Test
    public void queSePuedaCrearUnPartidoConDosEquipos(){
        //given when then
        //dado un torneo con dos e
        Partido partido = new Partido();

        Equipo equipo1 = new Equipo();

        Equipo equipo2 = new Equipo();

        //cuando guardo los dos equipos
        partido.guardarEquipo(equipo1);
        partido.guardarEquipo(equipo2);

        //entonces el partido tiene dos equipos
        assertThat(partido.getEquipos().contains(equipo1), is(true));
        assertThat(partido.getEquipos().contains(equipo2), is(true));


    }

    @Test
    public void queSePuedanCrearDosEquiposConDosUsuariosCadaEquipo(){
        //given when then
        //dado dos equipos

        Equipo equipo1 = new Equipo();

        Equipo equipo2 = new Equipo();

        //dados dos usuarios para cada equipo
        Usuario usuario1 = new Usuario();

        Usuario usuario2 = new Usuario();

        Usuario usuario3 = new Usuario();

        Usuario usuario4 = new Usuario();

        //cuando guardo dos usuarios en un equipo1
        equipo1.guardarUsuario(usuario1);
        equipo1.guardarUsuario(usuario2);
        //cuando guardo dos usuarios en un equipo2
        equipo2.guardarUsuario(usuario3);
        equipo2.guardarUsuario(usuario4);



        //entonces el partido tiene dos equipos con dos usuarios cada equipo
        assertThat(equipo1.getUsuarios().contains(usuario1), is(true));
        assertThat(equipo1.getUsuarios().contains(usuario2), is(true));
        assertThat(equipo2.getUsuarios().contains(usuario3), is(true));
        assertThat(equipo2.getUsuarios().contains(usuario4), is(true));




    }

    @Test
    public void queSePuedanCrearDosEquipoConDosUsuariosCadaEquipoYSeGuardeEnUnPartido(){
        //given when then
        //dado un torneo con dos e
        Partido partido = new Partido();

        Equipo equipo1 = new Equipo();

        Equipo equipo2 = new Equipo();

        Usuario usuario1 = new Usuario();

        Usuario usuario2 = new Usuario();

        Usuario usuario3 = new Usuario();

        Usuario usuario4 = new Usuario();

        //cuando guardo dos usuarios en un equipo
        equipo1.guardarUsuario(usuario1);
        equipo1.guardarUsuario(usuario2);
        equipo2.guardarUsuario(usuario3);
        equipo2.guardarUsuario(usuario4);

        //cuando guardo los equipos en los partidos
        partido.guardarEquipo(equipo1);
        partido.guardarEquipo(equipo2);


        //entonces el partido tiene dos equipos con dos usuarios cada equipo
        assertThat(partido.getEquipos().contains(equipo1), is(true));
        assertThat(partido.getEquipos().contains(equipo2), is(true));



    }




}
