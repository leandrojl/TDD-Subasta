package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.servicioRegistroEquipo.ServicioRegistroEquipo;
import com.tallerwebi.dominio.servicioTorneo.Equipo;
import com.tallerwebi.dominio.servicioUsuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class ControladorRegistroEquipo {

    private ServicioRegistroEquipo servicioRegistroEquipo;


    @Autowired //esto hace un inyeccion de dependencias, new ServicioRegistroEquipo();
    public ControladorRegistroEquipo(ServicioRegistroEquipo servicioRegistroEquipo) {

        this.servicioRegistroEquipo = servicioRegistroEquipo;

    }

     //el nombre de aca es de la url
    //no tiene que ver con el nombre de new ModelAndView("equipo", modelo);
     @RequestMapping( "/registrar-equipo-padel") // localhost:8080/spring/registrar-equipo-padel es la URL
    public ModelAndView irAlRegistroDelEquipoDePadel(){

        ModelMap modelo = new ModelMap();

        modelo.put("equipo-padel", new Equipo()); //en el modelo voy a poder utilizar este objeto y sus atributos

        return new ModelAndView("registro-equipo", modelo); //aca se pone el nombre del html

    }

    @RequestMapping(path = "/registracion-equipo-padel") //este metodo es un ENDPOINT
    public ModelAndView registrarEquipoDePadelConNombreDeEquipoYDosNombresDeJugador(@RequestParam  String nombre_equipo, @RequestParam  String usuario1, @RequestParam  String usuario2) {

         Boolean verificacion = servicioRegistroEquipo.verificaElNombreDelEquipoYLosUsuarios(nombre_equipo, usuario1, usuario2);

         String verificarUsuario1 = servicioRegistroEquipo.verificarUsuario(usuario1);
         String verificarUsuario2 = servicioRegistroEquipo.verificarUsuario(usuario2);

         if(Objects.equals(usuario1, "") || Objects.equals(usuario2, "")){
            ModelMap modelo = new ModelMap();
            modelo.put("error", "Debe agregar dos usuarios al equipo");
            //si alguno de los usuarios esta vacio redirecciona al registro del equipo y solicita dos usuarios
            return new ModelAndView("registro-equipo-fallido",modelo);
        }

        ModelMap modelo = new ModelMap();
        modelo.put("nombre_equipo", nombre_equipo);
        modelo.put("usuario1", usuario1);
        modelo.put("usuario2", usuario2);



        //si el registro es exitoso, direcciona al modeloVista de registro exitoso
        return new ModelAndView("registro-equipo-exitoso",modelo);
    }

    @RequestMapping(path = "/registracion-equipo-padel") //este metodo es un ENDPOINT
    public ModelAndView registrarEquipoDePadelConDosUsuariosYNombre(@RequestParam  String nombre_equipo, @RequestParam  Usuario usuario1, @RequestParam  Usuario usuario2) {

        Boolean verificacion = servicioRegistroEquipo.verificarNombre(nombre_equipo);
        Usuario verificarUsuario1 = servicioRegistroEquipo.verificarUsuario(usuario1);
        Usuario verificarUsuario2 = servicioRegistroEquipo.verificarUsuario(usuario2);

        if(Objects.equals(usuario1, "") || Objects.equals(usuario2, "")){
            ModelMap modelo = new ModelMap();
            modelo.put("error", "Debe agregar dos usuarios al equipo");
            //si alguno de los usuarios esta vacio redirecciona al registro del equipo y solicita dos usuarios
            return new ModelAndView("registro-equipo-fallido",modelo);
        }

        ModelMap modelo = new ModelMap();
        modelo.put("nombre_equipo", nombre_equipo);
        modelo.put("usuario1", usuario1);
        modelo.put("usuario2", usuario2);



        //si el registro es exitoso, direcciona al modeloVista de registro exitoso
        return new ModelAndView("registro-equipo-exitoso",modelo);
    }


    //@RequestMapping(path = registrarEquipoPadel) es la accion de mi formulario get de registro-equipo.html
    //a partir de esa accion va a venir al controlador 'ControladorRegistroEquipo'
    //y va a recibir los parametros por GET y devolver un ModelAndView dependiendo de si envio o no usuarios al registro.
    //este metodo me va a servir para cuando tenga una lista de usuarios y cree el equipo con usuarios existentes
    @RequestMapping(path = "/registrarEquipoPadel") //este metodo es un ENDPOINT
    public ModelAndView agregarUsuariosAlEquipo(@RequestParam  Usuario usuario1, @RequestParam  Usuario usuario2) {
        if(usuario1 == null || usuario2 == null){
            ModelMap modelo = new ModelMap();
            modelo.put("error", "Debe agregar dos usuarios al equipo");
            //si alguno de los usuarios esta vacio redirecciona al registro del equipo y solicita dos usuarios
            return new ModelAndView("redirect:/registroEquipo",modelo);
        }
        //si el registro es exitoso, direcciona al modeloVista de registro exitoso
        return new ModelAndView("registro-equipo-exitoso");
    }
}
