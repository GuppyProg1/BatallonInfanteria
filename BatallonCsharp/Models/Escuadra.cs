using Enums;

namespace Models
{
    public class Escuadra
    {
        private string nombre;
        private int numero;
        private TipoEscuadra tipo;
        private List<Soldado> soldados;

        private static int maxSoldadosPorEscuadra = 10;

        public Escuadra(string nombre, int numero, TipoEscuadra tipo)
        {
            this.nombre = nombre;
            this.numero = numero;
            this.tipo = tipo;
            soldados = new List<Soldado>();
        }

        public bool AgregarSoldado(Soldado s)
        {
            if (TieneCapacidadDisponible())
            {
                soldados.Add(s);
                return true;
            }
            return false;
        }

        public bool RemoverSoldadoPorNombre(string nombre)
        {
            var soldado = soldados.FirstOrDefault(s => s.Nombre.Equals(nombre, StringComparison.OrdinalIgnoreCase));
            if (soldado != null)
            {
                soldados.Remove(soldado);
                return true;
            }
            return false;
        }

        public int ContarSoldados()
        {
            return soldados.Count;
        }

        public bool TieneCapacidadDisponible()
        {
            return soldados.Count < maxSoldadosPorEscuadra;
        }

        public List<Soldado> ObtenerSoldadosAptos()
        {
            return soldados.Where(s => s.EsAptoParaMision()).ToList();
        }

        public static void CambiarMaximoSoldados(int nuevoMaximo)
        {
            maxSoldadosPorEscuadra = nuevoMaximo;
        }

        public string Nombre => nombre;
        public int Numero => numero;
        public TipoEscuadra Tipo => tipo;
        public List<Soldado> Soldados => soldados;
    }
}
