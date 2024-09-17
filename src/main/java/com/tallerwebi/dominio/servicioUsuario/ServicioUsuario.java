package com.tallerwebi.dominio.servicioUsuario;

import javax.transaction.Transactional;
import java.util.List;

//es mejor ponerselo al servicio ya que por implementacion de esta interfaz lo van a tener el @transactional
@Transactional
public interface ServicioUsuario {


    List<Usuario> listarTodos();

    Usuario crearUsuario(Usuario usuario);
}
