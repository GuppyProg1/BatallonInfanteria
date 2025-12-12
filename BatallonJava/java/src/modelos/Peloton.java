package modelos;

import java.util.ArrayList;
import java.util.List;
import enums.TipoPeloton;

public class Peloton {

    private String nombre;
    private String comandante;              
    private TipoPeloton tipo;               
    private List<Escuadra> escuadras;

    private static int maxEscuadras = 4;

    public Peloton(String nombre, String comandante, TipoPeloton tipo) {
        this.nombre = nombre;
        this.comandante = comandante;
        this.tipo = tipo;
        this.escuadras = new ArrayList<>();
    }


    public void agregarEscuadra(Escuadra e) {
        if (escuadras.size() < maxEscuadras) {
            escuadras.add(e);
        } else {
            System.out.println("No se puede agregar más escuadras. Pelotón lleno.");
        }
    }

    public void removerEscuadraPorNombre(String nombre) {
        escuadras.removeIf(e -> e.getNombre().equalsIgnoreCase(nombre));
    }

    public int contarEscuadras() {
        return escuadras.size();
    }

    public int contarTotalSoldados() {
        int total = 0;
        for (Escuadra e : escuadras) {
            total += e.contarSoldados();
        }
        return total;
    }

    public boolean esPelotonCompleto() {
        return escuadras.size() >= maxEscuadras;
    }

    public static void cambiarMaxEscuadras(int nuevoMax) {
        maxEscuadras = nuevoMax;
    }


    public String getNombre() {
        return nombre;
    }

    public String getComandante() {          
        return comandante;
    }

    public TipoPeloton getTipo() {           
        return tipo;
    }

    public List<Escuadra> getEscuadras() {
        return escuadras;
    }

    public String descripcion() {
        return "Pelotón: " + nombre + 
               " | Comandante: " + comandante +
               " | Tipo: " + tipo +
               " | Escuadras: " + escuadras.size() +
               " | Soldados totales: " + contarTotalSoldados();
    }
}

