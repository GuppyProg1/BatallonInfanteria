package BatallonInfanteria.BatallonJava.java.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelos.Escuadra;
import modelos.Soldado;
import enums.TipoEscuadra;
import enums.RangoSoldado;

public class EscuadraTest {

    @Test
    public void testAgregarSoldado() {
        Escuadra e = new Escuadra("Escuadra Alfa", 1, TipoEscuadra.INFANTERIA);

        Soldado s = new Soldado("Carlos", 21, RangoSoldado.SOLDADO, "APTO");

        assertTrue(e.agregarSoldado(s));
        assertEquals(1, e.contarSoldados());
    }

    @Test
    public void testEliminarSoldadoPorNombre() {
        Escuadra e = new Escuadra("Escuadra Bravo", 2, TipoEscuadra.APOYO);

        Soldado s = new Soldado("Juan", 25, RangoSoldado.CABO, "APTO");
        e.agregarSoldado(s);

        assertTrue(e.removerSoldadoPorNombre("Juan"));
        assertEquals(0, e.contarSoldados());
    }

    @Test
    public void testCapacidadDisponible() {
        Escuadra e = new Escuadra("Escuadra Z", 3, TipoEscuadra.RECONOCIMIENTO);

        // llenar hasta 10 (máximo por defecto)
        for (int i = 0; i < 10; i++) {
            e.agregarSoldado(new Soldado("S" + i, 20, RangoSoldado.SOLDADO, "APTO"));
        }

        assertFalse(e.tieneCapacidadDisponible());
    }

    @Test
    public void testObtenerSoldadosAptos() {
        Escuadra e = new Escuadra("Escuadra X", 4, TipoEscuadra.INFANTERIA);

        e.agregarSoldado(new Soldado("Apto1", 20, RangoSoldado.SOLDADO, "APTO"));
        e.agregarSoldado(new Soldado("Herido", 22, RangoSoldado.SARGENTO, "HERIDO"));
        e.agregarSoldado(new Soldado("Apto2", 19, RangoSoldado.CABO, "APTO"));

        assertEquals(2, e.obtenerSoldadosAptos().size());
    }
}
