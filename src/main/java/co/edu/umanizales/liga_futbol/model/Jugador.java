package co.edu.umanizales.liga_futbol.model;

public class Jugador extends Persona {
    private String posicion;
    private int goles;

    public Jugador(String nombre, String apellido, int edad, String posicion, int goles) {
        super(nombre, apellido, edad);
        this.posicion = posicion;
        this.goles = goles;
    }

    // Getters y setters
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
}

