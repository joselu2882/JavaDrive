package logica;

import model.Cliente;

import java.util.Scanner;

import static app.Main.clientes;

public class GestorClientes {

    public static Cliente crearCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI del cliente: ");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el telefono del cliente: ");
        String telefono = sc.nextLine();
        return new Cliente(dni, nombre, telefono);

    }

    public static Cliente buscarCliente(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }
}
