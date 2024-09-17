package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.servicioTorneo.Equipo;
import com.tallerwebi.dto.ConversorDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorEquipo {

    @RequestMapping(value = "/equipo") //el nombre de aca es de la url
                                         //no tiene que ver con el nombre de new ModelAndView("equipo", modelo);
    public ModelAndView irAlEquipoDePadel(){

        ModelMap modelo = new ModelMap();

        modelo.put("Equipo Padel", new Equipo());

        return new ModelAndView("equipo", modelo); //aca se pone el nombre del html

    }


}
