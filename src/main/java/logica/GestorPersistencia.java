package logica;

import model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static app.Main.clientes;
import static app.Main.vehiculos;


public class GestorPersistencia {

    public static void guardarDatos() {
        String rutaC = "clientes.txt";
        String rutaV = "vehiculos.txt";
        BufferedReader brC = null;
        BufferedReader brV = null;

        try {
            brC = new BufferedReader(new FileReader(rutaC));
            brV = new BufferedReader(new FileReader(rutaV));


            String linea;

            while ((linea = brC.readLine()) != null) {
                Cliente c = convertirCliente(linea);
                if (c != null) {
                    clientes.add(c);
                }
            }
            while ((linea = brV.readLine()) != null) {
                Vehiculo v = convertirVehiculo(linea);
                if (v != null) {
                    vehiculos.add(v);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: El fichero " + rutaC + " no existe");
        } catch (IOException e) {
            System.out.println("Error: No se puede leer el fichero");
        } finally {
            try {
                if (brC != null) {
                    brC.close();
                    System.out.println("Archivo cerrado");
                }
            } catch (IOException e) {
                System.out.println("Error: No se puede cerrar el archivo");
            }
        }
    }

    public static Cliente convertirCliente(String linea) {
        String[] datos = linea.split(";");
        if (datos.length == 3) {

            String dni = datos[0];
            String nombre = datos[1];
            String telefono = (datos[2]);
            return new Cliente(dni, nombre, telefono);
        }
        return null;
    }

    public static Vehiculo convertirVehiculo(String linea) {
        String[] datos = linea.split(";");
        if (datos.length == 7) {

            String dato = datos[0];
            String matricula = datos[1];
            String marca = datos[2];
            String modelo = (datos[3]);
            boolean disponible = Boolean.parseBoolean(datos[4]);
            if (datos[0].equals("COCHE")) {
                TipoC tipo = TipoC.valueOf(datos[5]);
                int numPlazas = Integer.parseInt(datos[6]);
                return new Coche(matricula, marca, modelo, disponible, tipo, numPlazas);
            } else if (datos[0].equals("FURGONETA")) {
                boolean esDecarga = Boolean.parseBoolean(datos[5]);
                int capacidad = Integer.parseInt(datos[6]);
                return new Furgoneta(matricula, marca, modelo, disponible, esDecarga, capacidad);
            }
        }
        return null;

    }
}