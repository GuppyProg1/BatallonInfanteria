using Microsoft.VisualStudio.TestTools.UnitTesting;
using Models;
using Enums;

namespace BatallonTests
{
    [TestClass]
    public class EscuadraTests
    {
        [TestMethod]
        public void DebeAgregarSoldadoCuandoHayCapacidad()
        {
            var esc = new Escuadra("Águila", 1, TipoEscuadra.INFANTERIA);
            var s = new Soldado("Lopez", 22, RangoSoldado.CABO, "APTO");

            bool agregado = esc.agregarSoldado(s);

            Assert.IsTrue(agregado);
            Assert.AreEqual(1, esc.contarSoldados());
        }

        [TestMethod]
        public void NoDebeAgregarSoldadoCuandoSuperaCapacidad()
        {
            Escuadra.cambiarMaximoSoldados(1);

            var esc = new Escuadra("Trueno", 4, TipoEscuadra.RECONOCIMIENTO);

            esc.agregarSoldado(new Soldado("A", 21, RangoSoldado.SOLDADO, "APTO"));
            bool agregado = esc.agregarSoldado(new Soldado("B", 22, RangoSoldado.SARGENTO, "APTO"));

            Assert.IsFalse(agregado);
        }

        [TestMethod]
        public void DebeRemoverSoldadoPorNombreCorrectamente()
        {
            var esc = new Escuadra("Lobos", 3, TipoEscuadra.APOYO);

            esc.agregarSoldado(new Soldado("Cano", 25, RangoSoldado.CABO, "APTO"));

            bool eliminado = esc.removerSoldadoPorNombre("Cano");

            Assert.IsTrue(eliminado);
            Assert.AreEqual(0, esc.contarSoldados());
        }

        [TestMethod]
        public void DebeRetornarSoldadosAptosCorrectamente()
        {
            var esc = new Escuadra("Delta", 2, TipoEscuadra.INFANTERIA);

            esc.agregarSoldado(new Soldado("Apto1", 20, RangoSoldado.SOLDADO, "APTO"));
            esc.agregarSoldado(new Soldado("Herido1", 21, RangoSoldado.CABO, "HERIDO"));

            var aptos = esc.obtenerSoldadosAptos();

            Assert.AreEqual(1, aptos.Count);
            Assert.AreEqual("Apto1", aptos[0].getNombre());
        }

        [TestMethod]
        public void TieneCapacidadDisponibleDebeFuncionar()
        {
            Escuadra.cambiarMaximoSoldados(2);

            var esc = new Escuadra("Rojo", 5, TipoEscuadra.APOYO);

            Assert.IsTrue(esc.tieneCapacidadDisponible());

            esc.agregarSoldado(new Soldado("Test", 20, RangoSoldado.RECLUTA, "APTO"));
            esc.agregarSoldado(new Soldado("Test2", 22, RangoSoldado.RECLUTA, "APTO"));

            Assert.IsFalse(esc.tieneCapacidadDisponible());
        }
    }
}