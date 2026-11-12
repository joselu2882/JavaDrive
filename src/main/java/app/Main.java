package app;

import model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static logica.GestorClientes.*;
import static logica.GestorFlota.*;
import static logica.GestorInformes.generarInformeXML;
import static logica.GestorReservas.pedirDatosReserva;
import static logica.GestorPersistencia.*;

public class Main {
    public static List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static List<Cliente> clientes = new ArrayList<Cliente>();
    public static List<Reserva> reservas = new ArrayList<Reserva>();
    public static void main(String[] args) {

        guardarDatos();

        Scanner sc = new Scanner(System.in);






        int opcion;
        do {
            System.out.println("╔═════════════════════════════════╗");
            System.out.println("║          MENU PRINCIPAL         ║");
            System.out.println("╠═════════════════════════════════╣");
            System.out.println("║ 1. Crear Cliente                ║");
            System.out.println("║ 2. Crear Vehiculo               ║");
            System.out.println("║ 3. Realizar reserva             ║");
            System.out.println("║ 4. Buscar Clientes              ║");
            System.out.println("║ 5. Buscar Vehiculo              ║");
            System.out.println("║ 6. Listar Vehiculo (Disponibles)║");
            System.out.println("║ 7. Generar informe XML          ║");
            System.out.println("║ 9. Salir                        ║");
            System.out.println("╚═════════════════════════════════╝");
            opcion = sc.nextInt();
            sc.nextLine();

            if(opcion == 1){
                Cliente c = crearCliente();
                clientes.add(c);
            }
            if(opcion == 2){
                Vehiculo v = crearVehiculo();
                vehiculos.add(v);
            }
            if(opcion == 3){
                pedirDatosReserva();


            }
            if(opcion == 4){
                String dni = sc.nextLine();
                System.out.println(buscarCliente(dni));

                }

            if(opcion == 5){
                String matricula = sc.nextLine();
                System.out.println(buscarVehiculo(matricula));

            }
            if(opcion == 6){
                for(Vehiculo vehiculo : vehiculos){
                    if(vehiculo.isDisponible()){
                        System.out.println(vehiculo);
                    }
                }
            }
            if(opcion == 7){
                generarInformeXML();
            }

        }while(opcion != 9);
    }
}