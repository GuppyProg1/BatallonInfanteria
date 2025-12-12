package app;

import java.util.Scanner;
import modelos.*;
import enums.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Objetos principales
        Batallon batallon = new Batallon("Batallon Colombia", "Bogotá", TipoBatallon.LIGERO);

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear Soldado");
            System.out.println("2. Crear Escuadra");
            System.out.println("3. Crear Pelotón");
            System.out.println("4. Agregar Pelotón al Batallón");
            System.out.println("5. Mostrar total de soldados del Batallón");
            System.out.println("6. Generar reporte del Batallón");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

                case 1 -> {
                    System.out.print("Nombre del soldado: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Seleccione rango:");
                    for (RangoSoldado r : RangoSoldado.values()) {
                        System.out.println("- " + r);
                    }
                    RangoSoldado rango = RangoSoldado.valueOf(sc.nextLine().toUpperCase());

                    Soldado s = new Soldado(nombre, edad, rango, "APTO");
                    System.out.println("Soldado creado: " + s.descripcion());
                }

                case 2 -> {
                    System.out.print("Nombre de la escuadra: ");
                    String nombre = sc.nextLine();

                    System.out.println("Tipo de escuadra:");
                    for (TipoEscuadra t : TipoEscuadra.values()) {
                        System.out.println("- " + t);
                    }
                    TipoEscuadra tipo = TipoEscuadra.valueOf(sc.nextLine().toUpperCase());

                    Escuadra e = new Escuadra(nombre, 1, tipo);
                    System.out.println("Escuadra creada correctamente." + e.getSoldados());
                }

                case 3 -> {
                    System.out.print("Nombre del pelotón: ");
                    String nombre = sc.nextLine();

                    System.out.print("Nombre del comandante: ");
                    String comandante = sc.nextLine();

                    System.out.println("Tipo de pelotón:");
                    for (TipoPeloton t : TipoPeloton.values()) {
                        System.out.println("- " + t);
                    }
                    TipoPeloton tipo = TipoPeloton.valueOf(sc.nextLine().toUpperCase());

                    Peloton p = new Peloton(nombre, comandante, tipo);

                    System.out.println("Pelotón creado correctamente." + p.descripcion());
                }

                case 4 -> {
                    System.out.print("Nombre del pelotón para agregar al batallón: ");
                    String nombre = sc.nextLine();

                    Peloton p = new Peloton(nombre, "Comandante X", TipoPeloton.ASALTO);
                    batallon.agregarPeloton(p);

                    System.out.println("Pelotón agregado al batallón.");
                }

                case 5 -> {
                    int total = batallon.contarTotalSoldados();
                    System.out.println("Total de soldados en el batallón: " + total);
                }

                case 6 -> {
                    System.out.println(batallon.generarReporteResumen());
                }

                case 0 -> {
                    System.out.println("Saliendo...");
                }

                default -> {
                    System.out.println("Opción no válida.");
                }
            }
        }

        sc.close();
    }
}
