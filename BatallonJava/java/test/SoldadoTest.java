package BatallonInfanteria.BatallonJava.java.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import modelos.Soldado;
import enums.RangoSoldado;

public class SoldadoTest {

    @Test
    public void testEsAptoParaMision() {
        Soldado s = new Soldado("Carlos", 20, RangoSoldado.SOLDADO, "APTO");
        assertTrue(s.esAptoParaMision());
    }

    @Test
    public void testNoEsAptoPorEdad() {
        Soldado s = new Soldado("Luis", 16, RangoSoldado.RECLUTA, "APTO");
        assertFalse(s.esAptoParaMision());
    }

    @Test
    public void testNoEsAptoPorSalud() {
        Soldado s = new Soldado("Pedro", 25, RangoSoldado.CABO, "HERIDO");
        assertFalse(s.esAptoParaMision());
    }

    @Test
    public void testAsignarRango() {
        Soldado s = new Soldado("Jose", 22, RangoSoldado.RECLUTA, "APTO");
        s.asignarRango(RangoSoldado.SARGENTO);
        assertEquals(RangoSoldado.SARGENTO, s.getRango());
    }

    @Test
    public void testMarcarComoHerido() {
        Soldado s = new Soldado("Miguel", 30, RangoSoldado.TENIENTE, "APTO");
        s.marcarComoHerido();
        assertEquals("HERIDO", s.getEstadoSalud());
    }
}
