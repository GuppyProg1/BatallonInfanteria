using Enums;

namespace Models
{
    public class Batallon
    {
        private string nombre;
        private string ubicacion;
        private TipoBatallon tipo;
        private List<Peloton> pelotones;

        private static string codigoOTAN = "OTAN-DEFAULT";

        public Batallon(string nombre, string ubicacion, TipoBatallon tipo)
        {
            this.nombre = nombre;
            this.ubicacion = ubicacion;
            this.tipo = tipo;
            pelotones = new List<Peloton>();
        }

        public bool AgregarPeloton(Peloton p)
        {
            pelotones.Add(p);
            return true;
        }

        public bool RemoverPelotonPorNombre(string nombre)
        {
            var peloton = pelotones.FirstOrDefault(p => p.Nombre.Equals(nombre, StringComparison.OrdinalIgnoreCase));
            if (peloton != null)
            {
                pelotones.Remove(peloton);
                return true;
            }
            return false;
        }

        public int ContarPelotones()
        {
            return pelotones.Count;
        }

        public int ContarTotalSoldados()
        {
            return pelotones.Sum(p => p.ContarTotalSoldados());
        }

        public string GenerarReporteResumen()
        {
            return
                $"Batallón: {nombre}\n" +
                $"Ubicación: {ubicacion}\n" +
                $"Tipo: {tipo}\n" +
                $"Pelotones: {pelotones.Count}\n" +
                $"Total Soldados: {ContarTotalSoldados()}\n" +
                $"Código OTAN: {codigoOTAN}";
        }

        public static void CambiarCodigoOTAN(string nuevoCodigo)
        {
            codigoOTAN = nuevoCodigo;
        }

        public string Nombre => nombre;
        public string Ubicacion => ubicacion;
        public TipoBatallon Tipo => tipo;
        public List<Peloton> Pelotones => pelotones;
    }
}
