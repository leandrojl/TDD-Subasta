package com.tallerwebi.dominio.servicioTorneo;

import com.tallerwebi.dominio.servicioUsuario.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido {


    @Id
    private Long id;
    @OneToMany(mappedBy = "partido")
    private List<Equipo> equipos = new ArrayList<>();

    public Partido(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Partido() {
    }

    public List<Equipo> getEquipos() {
        return this.equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void guardarEquipo(Equipo equipo) {
        this.equipos.add(equipo);
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
