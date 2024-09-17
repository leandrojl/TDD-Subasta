package com.tallerwebi.dominio.servicioTorneo;

import java.util.Objects;

public class Torneo {

    private String nombre;
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Torneo torneo = (Torneo) o;
        return Objects.equals(nombre, torneo.nombre) && Objects.equals(id, torneo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id);
    }
}
