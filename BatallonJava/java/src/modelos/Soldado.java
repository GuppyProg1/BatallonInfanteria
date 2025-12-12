package modelos;

import enums.RangoSoldado;

public class Soldado {

    private String nombre;
    private int edad;
    private RangoSoldado rango;
    private String estadoSalud; 

    private static int edadMinimaServicio = 18;

    public Soldado(String nombre, int edad, RangoSoldado rango, String estadoSalud) {
        this.nombre = nombre;
        this.edad = edad;
        this.rango = rango;
        this.estadoSalud = estadoSalud;
    }


    public Soldado(String string, RangoSoldado sargento, int i) {
       
    }

    public void entrenar() {
        System.out.println(nombre + " está entrenando.");
    }

    public void asignarRango(RangoSoldado nuevoRango) {
        this.rango = nuevoRango;
    }

    public void marcarComoHerido() {
        this.estadoSalud = "HERIDO";
    }

    public boolean esAptoParaMision() {
        return edad >= edadMinimaServicio && estadoSalud.equalsIgnoreCase("APTO");
    }

    public String descripcion() {
        return "Soldado: " + nombre +
                " | Edad: " + edad +
                " | Rango: " + rango +
                " | Salud: " + estadoSalud;
    }

    public static void cambiarEdadMinimaServicio(int nuevaEdad) {
        edadMinimaServicio = nuevaEdad;
    }

    // Getters necesarios
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getEstadoSalud() { return estadoSalud; }
    public RangoSoldado getRango() { return rango; }

    public void setNombre(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

    public Integer getAniosServicio() {
        throw new UnsupportedOperationException("Unimplemented method 'getAniosServicio'");
    }
}