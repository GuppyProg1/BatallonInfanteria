package modelos;

import java.util.ArrayList;
import java.util.List;

import enums.TipoBatallon;

public class Batallon {

    private String nombre;
    private String ubicacion;
    private TipoBatallon tipo;
    private List<Peloton> pelotones;

    private static String codigoOTAN = "OTAN-DEFAULT";

    public Batallon(String nombre, String ubicacion, TipoBatallon tipo) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.pelotones = new ArrayList<>();
    }

    public boolean agregarPeloton(Peloton p) {
        return pelotones.add(p);
    }

    public boolean removerPelotonPorNombre(String nombre) {
        return pelotones.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public int contarPelotones() {
        return pelotones.size();
    }

    public int contarTotalSoldados() {
        int total = 0;
        for (Peloton p : pelotones) {
            total += p.contarTotalSoldados();
        }
        return total;
    }

    public String generarReporteResumen() {
        return "Batallon: " + nombre +
                " | Ubicacion: " + ubicacion +
                " | Tipo: " + tipo +
                " | Pelotones: " + contarPelotones() +
                " | Total Soldados: " + contarTotalSoldados() +
                " | Codigo OTAN: " + codigoOTAN;
    }

    public static void cambiarCodigoOTAN(String nuevoCodigo) {
        codigoOTAN = nuevoCodigo;
    }

    // Getters
    public String getNombre() { return nombre; }
    public List<Peloton> getPelotones() { return pelotones; }
}
