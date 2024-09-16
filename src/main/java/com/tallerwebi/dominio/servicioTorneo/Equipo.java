package com.tallerwebi.dominio.servicioTorneo;

import com.tallerwebi.dominio.servicioUsuario.Usuario;

public class Equipo {

    private String nombreEquipo;
    private Usuario usuario1;
    private Usuario usuario2;

    public Equipo(Usuario usuario1, Usuario usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }

    public Equipo () {

    }

    public void guardarUsuarios(Usuario usuario1, Usuario usuario2) {
        setUsuario1(usuario1);
        setUsuario2(usuario2);
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }
}
