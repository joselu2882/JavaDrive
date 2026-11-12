package model;

public class Coche extends Vehiculo{

    private TipoC tipo;
    private int numPlazas;

    public Coche(String matricula, String marca, String modelo, boolean disponible, TipoC tipo, int numPlazas) {
        super(matricula, marca, modelo, disponible);
        this.tipo = tipo;
        this.numPlazas = numPlazas;
    }

    public String obtenerDetalles(){
        return "Coche: [" + tipo + "] " + "Plazas: [" + numPlazas + "]";
    }

    public TipoC getTipo() {
        return tipo;
    }

    public void setTipo(TipoC tipo) {
        this.tipo = tipo;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }
}
