package logica;

import app.Main;
import model.Cliente;
import model.Reserva;
import model.Vehiculo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static app.Main.reservas;

public class GestorReservas {

    public static void pedirDatosReserva() {
        System.out.println("DNI del cliente:");

        Scanner scanner = new Scanner(System.in);
        String dni = scanner.nextLine();

        Cliente c = GestorClientes.buscarCliente(dni);
        if (c == null) {
            System.out.println("Cliente no existe");
            return;
        }

        System.out.println("Matricula del vehiculo:");
        String matricula = scanner.nextLine();

        Vehiculo v = GestorFlota.buscarVehiculo(matricula);
        if (v == null || !v.isDisponible()) {
            System.out.println("Vehiculo no disponible");
            return;
        }

        System.out.println("Fecha inicio (YYYY-MM-DD):");
        LocalDate inicio = LocalDate.parse(scanner.nextLine());

        System.out.println("Fecha fin (YYYY-MM-DD):");
        LocalDate fin = LocalDate.parse(scanner.nextLine());

        realizarReserva(c, v, inicio, fin);
    }

    public static void realizarReserva(Cliente c, Vehiculo v, LocalDate inicio, LocalDate fin) {
        v.setDisponible(false);
        int idReserva = 0;
        idReserva++;

        Reserva r = new Reserva(idReserva, c, v, inicio, fin);
        reservas.add(r);

        exportarTicket(r);
    }

    public static void exportarTicket(Reserva r){
        FileWriter fw = null;
        BufferedWriter bw = null;
        String nombreFichero = "Reserva.txt";

        try {
            fw = new FileWriter(nombreFichero);
            bw = new BufferedWriter(fw);
            bw.write(r.GenerarLineaTiket());
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: No se puede escribir en el fichero");
        }

    }
}
