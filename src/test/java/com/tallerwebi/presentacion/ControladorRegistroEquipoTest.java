package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.servicioTorneo.Equipo;
import com.tallerwebi.dominio.servicioUsuario.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ControladorRegistroEquipoTest {


    ControladorRegistroEquipo controladorRegistroEquipo;

    @Test
    public void siExistenLosDosUsuariosElEquipoEsCreadoExitosamente() {
    //given-when-that
        Equipo equipo = new Equipo();
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();

        //cuando agrego a los usuarios al equipo
        ModelAndView modelo = controladorRegistroEquipo.agregarUsuariosAlEquipo(usuario1,usuario2);

        //le muestro al usuario que el equipo fue creado correctamente


        assertThat(modelo.getViewName(),equalToIgnoringCase("registroEquipoExitoso"));
    }

    @Test
    public void siNoExisteUnUsuarioEnElRegistroDelEquipoFalla() {
        //given-when-that
        //dado un equipo al que le registro dos usuarios
        Equipo equipo = new Equipo();
        Usuario usuario1 = new Usuario();
        Usuario usuario2Vacio = null;

        //cuando agrego a los usuarios al equipo
        ModelAndView modelo = controladorRegistroEquipo.agregarUsuariosAlEquipo(usuario1,usuario2Vacio);


        //el registro del equipo falla porqe un usuario no existe
        assertThat(modelo.getViewName(),equalToIgnoringCase("redirect:/registroEquipo"));
        assertThat(modelo.getModel().get("error").toString(), equalToIgnoringCase("Debe agregar dos usuarios al equipo"));
    }

    @Test
    public void queSiAlIngresarDosUsuariosIgualesAlRegistroDeEquipoFalleElRegistroDelEquipo(){

    }
}
