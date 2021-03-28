package examen2eval;

/**
 *
 * @author Javier
 */
public class Mesa {

    private String identificador;
    private int capacidad;
    private boolean estaLibre;

    public Mesa(String identificador, int capacidad) {
        this.identificador = identificador;
        this.capacidad = capacidad;
        this.estaLibre = true;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public boolean getEstaLibre() {
        return this.estaLibre;
    }

    public void setEstaLibre(boolean estaLibre) {
        this.estaLibre = estaLibre;
    }

    @Override
    public String toString() {
        return "Mesa{" + "identificador=" + identificador + ", capacidad=" + capacidad + ", estaLibre=" + estaLibre + '}';
    }

    
}
