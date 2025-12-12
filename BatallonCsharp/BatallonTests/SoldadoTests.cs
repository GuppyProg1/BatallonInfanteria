using Microsoft.VisualStudio.TestTools.UnitTesting;
using Models;
using Enums;

namespace BatallonTests
{
    [TestClass]
    public class SoldadoTests
    {
        [TestMethod]
        public void SoldadoDebeSerAptoCuandoCumpleLasCondiciones()
        {
            var s = new Soldado("Perez", 22, RangoSoldado.SARGENTO, "APTO");

            bool apto = s.esAptoParaMision();

            Assert.IsTrue(apto);
        }

        [TestMethod]
        public void SoldadoNoEsAptoSiEsMenorDeEdad()
        {
            var s = new Soldado("Luis", 17, RangoSoldado.RECLUTA, "APTO");

            bool apto = s.esAptoParaMision();

            Assert.IsFalse(apto);
        }

        [TestMethod]
        public void SoldadoDebeCambiarEstadoASaludHerido()
        {
            var s = new Soldado("Carlos", 25, RangoSoldado.CABO, "APTO");

            s.marcarComoHerido();

            Assert.AreEqual("HERIDO", s.getEstadoSalud());
        }

        [TestMethod]
        public void SoldadoDebeActualizarRangoCorrectamente()
        {
            var s = new Soldado("Rico", 30, RangoSoldado.RECLUTA, "APTO");

            s.asignarRango(RangoSoldado.TENIENTE);

            Assert.AreEqual(RangoSoldado.TENIENTE, s.getRango());
        }

        [TestMethod]
        public void DescripcionDebeGenerarTextoCorrecto()
        {
            var s = new Soldado("Marin", 21, RangoSoldado.SOLDADO, "APTO");

            string texto = s.descripcion();

            StringAssert.Contains(texto, "Marin");
            StringAssert.Contains(texto, "21");
            StringAssert.Contains(texto, "SOLDADO");
            StringAssert.Contains(texto, "APTO");
        }
    }
}
