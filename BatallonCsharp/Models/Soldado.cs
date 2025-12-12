using Enums;

namespace Models
{
    public class Soldado
    {
        private string nombre;
        private int edad;
        private RangoSoldado rango;
        private string estadoSalud;

        private static int edadMinimaServicio = 18;

        public Soldado(string nombre, int edad, RangoSoldado rango, string estadoSalud)
        {
            this.nombre = nombre;
            this.edad = edad;
            this.rango = rango;
            this.estadoSalud = estadoSalud;
        }

        public void Entrenar()
        {
            Console.WriteLine($"{nombre} está entrenando.");
        }

        public void AsignarRango(RangoSoldado nuevoRango)
        {
            this.rango = nuevoRango;
        }

        public void MarcarComoHerido()
        {
            this.estadoSalud = "HERIDO";
        }

        public bool EsAptoParaMision()
        {
            return edad >= edadMinimaServicio && estadoSalud.ToUpper() == "APTO";
        }

        public string Descripcion()
        {
            return $"Soldado: {nombre} | Edad: {edad} | Rango: {rango} | Salud: {estadoSalud}";
        }

        public static void CambiarEdadMinimaServicio(int nuevaEdad)
        {
            edadMinimaServicio = nuevaEdad;
        }

        // Getters
        public string Nombre => nombre;
        public int Edad => edad;
        public string EstadoSalud => estadoSalud;
        public RangoSoldado Rango => rango;
    }
}