package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.servicioUsuario.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorRegistroEquipo {


    public ModelAndView agregarUsuariosAlEquipo(Usuario usuario1, Usuario usuario2) {
        if(usuario1 == null || usuario2 == null){
            ModelMap modelo = new ModelMap();
            modelo.put("error", "Debe agregar dos usuarios al equipo");
            //si alguno de los usuarios esta vacio redirecciona al registro del equipo y solicita dos usuarios
            return new ModelAndView("redirect:/registroEquipo",modelo);
        }
        //si el registro es exitoso, direcciona al modeloVista de registro exitoso
        return new ModelAndView("registroEquipoExitoso");
    }


    public ModelAndView agregarUsuariosAlEquipo() {
        return null;
    }
}
