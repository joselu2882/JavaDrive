package model;

public class Furgoneta extends Vehiculo{

    private boolean esDecarga;
    private int capacidad;

    public Furgoneta(String matricula, String marca, String modelo, boolean disponible, boolean esDecarga, int capacidad) {
        super(matricula, marca, modelo, disponible);
        this.esDecarga = esDecarga;
        this.capacidad = capacidad;
    }

    public String obtenerDetalles(){
        if (esDecarga){
            return "Furgoneta de carga: (" + capacidad + "Kg)";
        }else{
            return "Furgoneta de pasajeros: (" + capacidad + " Personas)";
        }
    }

    public boolean isEsDecarga() {
        return esDecarga;
    }

    public void setEsDecarga(boolean esDecarga) {
        this.esDecarga = esDecarga;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
