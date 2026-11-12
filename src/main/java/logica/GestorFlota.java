package logica;

import model.Coche;
import model.Furgoneta;
import model.TipoC;
import model.Vehiculo;

import java.util.Scanner;

import static app.Main.vehiculos;

public class GestorFlota {



    public static Vehiculo crearVehiculo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tipo de vehiculo (COCHE/FURGONETA): ");
        String tipo = sc.nextLine();
        System.out.println("Introduce la matricula del vehiculo: ");
        String matricula = sc.nextLine();
        System.out.println("Introduce la marca del vehiculo: ");
        String marca = sc.nextLine();
        System.out.println("Introduce el modelo del vehiculo: ");
        String modelo = sc.nextLine();
        System.out.println("Introduce si el vehiculo esta disponible (true/false): ");
        boolean disponible = sc.nextLine().equals("true");
        if(tipo.equals("COCHE")){
            System.out.println("Introduce el tipo de coche (Pequeño, Familiar, Deportivo): ");
            TipoC tipoC = TipoC.valueOf(sc.nextLine());
            System.out.println("Introduce el numero de plazas del coche: ");
            int numPlazas = sc.nextInt();
            sc.nextLine();
            return new Coche(matricula, marca, modelo, disponible, tipoC, numPlazas);
        }else if(tipo.equals("FURGONETA")){
            System.out.println("Introduce si el vehiculo es de carga (true/false): ");
            boolean esDecarga = sc.nextLine().equals("true");
            System.out.println("Introduce la capacidad del vehiculo (en Kg): ");
            int capacidad = sc.nextInt();
            sc.nextLine();
            return new Furgoneta(matricula, marca, modelo, disponible, esDecarga, capacidad);
        }
        return null;
    }

    public static Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                return v;
            }
        }
        return null;
    }
}
