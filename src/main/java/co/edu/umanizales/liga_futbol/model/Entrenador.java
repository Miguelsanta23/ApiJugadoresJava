package co.edu.umanizales.liga_futbol.model;

public class Entrenador extends Persona {
    private int anosExperiencia;

    public Entrenador(String nombre, String apellido, int edad, int anosExperiencia) {
        super(nombre, apellido, edad);
        this.anosExperiencia = anosExperiencia;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

}