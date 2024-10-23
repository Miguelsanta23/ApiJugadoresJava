package co.edu.umanizales.liga_futbol.model;

import java.util.ArrayList;
import java.util.List;

public class Liga {
    private String nombre;
    private List<Equipo> equipos;

    public Liga(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>(10);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}