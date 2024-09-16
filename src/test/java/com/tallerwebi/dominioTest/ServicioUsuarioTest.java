package com.tallerwebi.dominioTest;

import com.tallerwebi.dominio.servicioUsuario.Permiso;
import com.tallerwebi.dominio.servicioUsuario.ServicioUsuario;
import com.tallerwebi.dominio.servicioUsuario.ServicioUsuarioImpl;
import com.tallerwebi.dominio.servicioUsuario.Usuario;
import com.tallerwebi.infraestructura.repositorioUsuario.RepositorioUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioUsuarioTest {

    private ServicioUsuario servicioUsuario;
    private RepositorioUsuario repositorioUsuario;

   @BeforeEach
    public void setUp() throws Exception {                          //estoy inyectando una instancia con mockito
        this.repositorioUsuario =  mock(RepositorioUsuario.class); //este es un falso repositorio
        this.servicioUsuario =  new ServicioUsuarioImpl(repositorioUsuario);
   }

    @Test
    public void siNoHayUsuariosDeberiaDevolverUnaLista(){

       dadoQueNoHayUsuariosCreados();
       List<Usuario> listado = cuandoConsultoTodosLosUsuarios();
       entoncesObtengoUnaListaVacia(listado);

    }

    private void dadoQueNoHayUsuariosCreados() {
       //utilizacion de Mock
       when(repositorioUsuario.listarTodos()).thenReturn(new LinkedList<Usuario>());
    }

    private List<Usuario> cuandoConsultoTodosLosUsuarios() {
       return servicioUsuario.listarTodos();
    }

    private void entoncesObtengoUnaListaVacia(List<Usuario> listado){
       assertThat(listado, empty());
    }


    @Test
    public void testQueSiAgregoUnUsuarioDeberiaDevolverSuId(){
        dadoQueNoExisteUnUsuario();

        Usuario usuario = cuandoCreoUnUsuarioConId();
        entoncesObtengoSuIdDeCreacion(usuario);

    }

    private void dadoQueNoExisteUnUsuario() {
    }

    private Usuario cuandoCreoUnUsuarioConId() {
       Usuario usuario = new Usuario();
       usuario.setId(1L);
       when(repositorioUsuario.crearUsuario(usuario)).thenReturn(usuario); //simulo el comportamiento del repositorio
       return servicioUsuario.crearUsuario(usuario);
    }

    private void entoncesObtengoSuIdDeCreacion(Usuario usuario) {

       assertThat(usuario.getId(), is(1L));
    }

    @Test
    public void cuandoCreoUnUsuarioConIdDiferenteAOtroUsuarioConIdYSonDistintos(){

       Usuario usuarioExistente = cuandoCreoUsuarioConId(2L);
       Usuario usuarioNoExistente = cuandoCreoUsuarioConId(1L);
       entoncesLosUsuariosSonDistintos(usuarioNoExistente,usuarioExistente);
    }

    private Usuario cuandoCreoUsuarioConId(long l) {
       Usuario usuario = new Usuario();
       usuario.setId(l);
        when(repositorioUsuario.crearUsuario(usuario)).thenReturn(usuario); //simulo el comportamiento del repositorio
        return servicioUsuario.crearUsuario(usuario);
    }

    private void entoncesLosUsuariosSonDistintos(Usuario usuarioNoExistente, Usuario usuarioExistente) {

       assertThat(usuarioNoExistente.getId(), not(equalTo(usuarioExistente.getId())));
       assertThat(usuarioNoExistente, not(equalTo(usuarioExistente)));
        assertThat(usuarioExistente, notNullValue());
        assertThat(usuarioNoExistente, notNullValue());

    }

    @Test
    public void queSePuedaCrearUnUsuarioAdministrador(){
       //Dado que tengo un usuario
       Usuario usuario = new Usuario();

       //cuando le asigno el rol de administrador
        usuario.setPermiso(Permiso.ADMINISTRADOR);
        //el servicio crea el usuario con rol administrador
        servicioUsuario.crearUsuario(usuario);
        //mockeo la creacion del usuario administrador en el repositorio
        when(repositorioUsuario.crearUsuario(usuario)).thenReturn(usuario); //simulo el comportamiento del repositorio


        //entonces el usuario es administrador
        assertThat(usuario.getPermiso(), is(Permiso.ADMINISTRADOR));
    }

    @Test
    public void queSePuedaCrearUnUsuarioRegular(){
        //Dado que tengo un usuario
        Usuario usuario = new Usuario();

        //cuando le asigno el rol de administrador
        usuario.setPermiso(Permiso.REGULAR);
        //el servicio crea el usuario con rol administrador
        servicioUsuario.crearUsuario(usuario);
        //mockeo la creacion del usuario administrador en el repositorio
        when(repositorioUsuario.crearUsuario(usuario)).thenReturn(usuario); //simulo el comportamiento del repositorio

        //entonces el usuario es administrador
        assertThat(usuario.getPermiso(), is(Permiso.REGULAR));
    }



}
