package com.tallerwebi.dominio.servicioTorneo;

import com.tallerwebi.dominio.servicioUsuario.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreEquipo;

    // Relación de un equipo con muchos usuarios (al menos 2)
    @OneToMany(mappedBy = "equipo")
    private List<Usuario> usuarios = new ArrayList<>();

    // Constructor con lista de usuarios
    public Equipo(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Equipo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void guardarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}
