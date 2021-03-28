package examen2eval;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Javier
 */
public class Reserva {
    
    private String cliente;
    private int cantidadComensales;
    private GregorianCalendar fechaReserva;
    private Mesa mesaReservada;

    public Reserva(String cliente, int cantidadComensales, int dia, int mes, int annio) {
        this.cliente = cliente;
        this.cantidadComensales = cantidadComensales;
        this.fechaReserva = new GregorianCalendar(annio, (mes - 1), dia);
    }



    public String getCliente() {
        return cliente;
    }

    public int getCantidadComensales() {
        return cantidadComensales;
    }

    public GregorianCalendar getFechaReserva() {
        return fechaReserva;
    }

    public Mesa getMesaReservada() {
        return mesaReservada;
    }

    public void setMesaReservada(Mesa mesaReservada) {
        this.mesaReservada = mesaReservada;
    }

    @Override
    public String toString() {
        String fechaReserva = new SimpleDateFormat("dd/MMMM/yyyy").format(this.fechaReserva.getTime());
        return "Reserva{" + "cliente=" + this.cliente + ", cantidadComensales=" + this.cantidadComensales + ", fechaReserva=" + fechaReserva + ", mesaReservada=" + this.mesaReservada + '}';
    }
    
        
 
}
