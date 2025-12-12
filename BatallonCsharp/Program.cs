using System;
using System.Collections.Generic;
using Enums;
using Models;

namespace BatallonPOO
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=== SISTEMA MILITAR - POO ===\n");

            var s1 = new Soldado("Carlos Ruiz", 25, RangoSoldado.CABO, "APTO");
            var s2 = new Soldado("Miguel Torres", 30, RangoSoldado.SARGENTO, "APTO");
            var s3 = new Soldado("Juan Diaz", 19, RangoSoldado.RECLUTA, "HERIDO");

            Console.WriteLine("Soldados creados:");
            Console.WriteLine(s1.Descripcion());
            Console.WriteLine(s2.Descripcion());
            Console.WriteLine(s3.Descripcion());
            Console.WriteLine();

            var esc1 = new Escuadra("Escuadra Alfa", 1, TipoEscuadra.INFANTERIA);
            
            esc1.AgregarSoldado(s1);
            esc1.AgregarSoldado(s2);
            esc1.AgregarSoldado(s3);

            Console.WriteLine($"Escuadra '{esc1.Nombre}' tiene {esc1.ContarSoldados()} soldados.");
            Console.WriteLine("Soldados aptos para misión:");
            foreach (var soldado in esc1.ObtenerSoldadosAptos())
            {
                Console.WriteLine(" - " + soldado.Nombre);
            }
            Console.WriteLine();

            var peloton1 = new Peloton("Pelotón Bravo", "Teniente López", TipoPeloton.ASALTO);

            peloton1.AgregarEscuadra(esc1);

            Console.WriteLine($"Pelotón '{peloton1.Nombre}' tiene {peloton1.ContarEscuadras()} escuadras.");
            Console.WriteLine($"Total soldados del pelotón: {peloton1.ContarTotalSoldados()}");
            Console.WriteLine();

            Batallon.CambiarCodigoOTAN("CO-123-BAT");

            var batallon = new Batallon("Batallón Phoenix", "Bogotá", TipoBatallon.LIGERO);

            batallon.AgregarPeloton(peloton1);

            Console.WriteLine($"Batallón '{batallon.Nombre}' tiene {batallon.ContarPelotones()} pelotón(es).");
            Console.WriteLine($"Total soldados del batallón: {batallon.ContarTotalSoldados()}");
            Console.WriteLine();

            Console.WriteLine("--- REPORTE DEL BATALLÓN ---");
            Console.WriteLine(batallon.GenerarReporteResumen());

            Console.WriteLine("\nFin del programa.");
        }
    }
}
