package com.tallerwebi.dominio.servicioTorneo;

public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Partido() {
    }


    public void guardarEquipos(Equipo equipo1, Equipo equipo2) {
        setEquipo1(equipo1);
        setEquipo2(equipo2);
    }

    public Equipo getEquipo1() {
        return this.equipo1;
    }
    public Equipo getEquipo2() {
        return this.equipo2;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }
    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

}
