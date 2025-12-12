using Enums;

namespace Models
{
    public class Peloton
    {
        private string nombre;
        private string comandante;
        private TipoPeloton tipo;
        private List<Escuadra> escuadras;

        private static int maxEscuadras = 5;

        public Peloton(string nombre, string comandante, TipoPeloton tipo)
        {
            this.nombre = nombre;
            this.comandante = comandante;
            this.tipo = tipo;
            escuadras = new List<Escuadra>();
        }

        public bool AgregarEscuadra(Escuadra e)
        {
            if (escuadras.Count < maxEscuadras)
            {
                escuadras.Add(e);
                return true;
            }
            return false;
        }

        public bool RemoverEscuadraPorNombre(string nombre)
        {
            var escuadra = escuadras.FirstOrDefault(e => e.Nombre.Equals(nombre, StringComparison.OrdinalIgnoreCase));
            if (escuadra != null)
            {
                escuadras.Remove(escuadra);
                return true;
            }
            return false;
        }

        public int ContarEscuadras()
        {
            return escuadras.Count;
        }

        public int ContarTotalSoldados()
        {
            return escuadras.Sum(e => e.ContarSoldados());
        }

        public bool EsPelotonCompleto()
        {
            return escuadras.Count == maxEscuadras;
        }

        public static void CambiarMaxEscuadras(int nuevoMax)
        {
            maxEscuadras = nuevoMax;
        }

        public string Nombre => nombre;
        public string Comandante => comandante;
        public TipoPeloton Tipo => tipo;
        public List<Escuadra> Escuadras => escuadras;
    }
}
