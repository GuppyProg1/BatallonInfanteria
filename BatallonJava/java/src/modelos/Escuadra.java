package modelos;

import java.util.ArrayList;
import java.util.List;

import enums.TipoEscuadra;

public class Escuadra {

    private String nombre;
    private int numero;
    private TipoEscuadra tipo;
    private List<Soldado> soldados;

    private static int maxSoldadosPorEscuadra = 10;

    public Escuadra(String nombre, int numero, TipoEscuadra tipo) {
        this.nombre = nombre;
        this.numero = numero;
        this.tipo = tipo;
        this.soldados = new ArrayList<>();
    }

    public boolean agregarSoldado(Soldado s) {
        if (tieneCapacidadDisponible()) {
            soldados.add(s);
            return true;
        }
        return false;
    }

    public boolean removerSoldadoPorNombre(String nombre) {
        return soldados.removeIf(s -> s.getNombre().equalsIgnoreCase(nombre));
    }

    public int contarSoldados() {
        return soldados.size();
    }

    public boolean tieneCapacidadDisponible() {
        return soldados.size() < maxSoldadosPorEscuadra;
    }

    public List<Soldado> obtenerSoldadosAptos() {
        List<Soldado> aptos = new ArrayList<>();
        for (Soldado s : soldados) {
            if (s.esAptoParaMision()) {
                aptos.add(s);
            }
        }
        return aptos;
    }

    public static void cambiarMaximoSoldados(int nuevoMaximo) {
        maxSoldadosPorEscuadra = nuevoMaximo;
    }

    public String getNombre() { return nombre; }
    public int getNumero() { return numero; }
    public TipoEscuadra getTipo() { return tipo; }
    public List<Soldado> getSoldados() { return soldados; }
}
