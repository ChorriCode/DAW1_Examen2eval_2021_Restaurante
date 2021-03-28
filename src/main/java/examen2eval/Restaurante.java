package examen2eval;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Javier
 */
public class Restaurante {

    private String nombreRestaurante;
    private List<Mesa> listaMesas;
    private Map<String, Reserva> listaReservas;

    public Restaurante(String nombreRestaurante, int cantidadMesas) {
        this.nombreRestaurante = nombreRestaurante;
        this.listaReservas = new HashMap<>();
        this.inicializarMesas(cantidadMesas);
    }

    private void inicializarMesas(int cantidadMesas) {
        this.listaMesas = new ArrayList<>();
        for (int i = 1; i <= cantidadMesas; i++) {
            int cantidadComensales = (int) (Math.random() * (16 - 2 + 1) + 2);
            Mesa unaMesa = new Mesa(String.valueOf(i), cantidadComensales);
            this.listaMesas.add(unaMesa);
        }
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public boolean reservarMesa(String cliente, int cantidadComensales) {
        if (this.listaReservas != null && this.listaReservas.containsKey(cliente)) {
            System.out.println("\nEl cliente " + cliente + " ya tiene una mesa reservada\n");
            return false;
        }
        int identificadorMesa = this.asignarMesa(cantidadComensales);
        if (identificadorMesa > 0) {
            LocalDate hoy = LocalDate.now();
            Reserva reserva = new Reserva(cliente, cantidadComensales, hoy.getDayOfMonth(), hoy.getMonthValue(), hoy.getYear());
            Mesa mesaReservada = this.listaMesas.get(identificadorMesa - 1);
            mesaReservada.setEstaLibre(false);
            reserva.setMesaReservada(mesaReservada);
            this.listaReservas.put(cliente, reserva);
            return true;
        }
        return false;
    }
    
    private int asignarMesa(int cantidadComensales) {
        Mesa mesaSeleccionada = new Mesa("-1", 16);
        for (Mesa mesa : this.listaMesas) {
            if (mesa.getEstaLibre() && (mesa.getCapacidad() >= cantidadComensales && mesa.getCapacidad() <= mesaSeleccionada.getCapacidad())) {
                mesaSeleccionada = mesa;
            }
        }
        return Integer.parseInt(mesaSeleccionada.getIdentificador());
    }

    public void mostrarReservas() {
        if (this.listaReservas.size() > 0) {
        Iterator it = this.listaReservas.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry unaReserva = (Map.Entry) it.next();
            String nombreCliente = (String) unaReserva.getKey();
            this.mostrarReserva(nombreCliente);
            
        }
        } else {
            System.out.println("\nLa lista de reservas está vacía");
        }
    }
    
    public void mostrarRestaurante() {
        System.out.println("Restaurante " + this.nombreRestaurante + "\n");
        System.out.println("Dispone de las siguientes mesas");
        this.listarMesas();
    }

    private void listarMesas() {
        for (Mesa mesa : this.listaMesas) {
            System.out.println(mesa.toString());
        }
    }
    
    public void mostrarReserva(String cliente) {
        System.out.println("\nReserva a nombre de " + cliente);
        System.out.println("Datos de la reserva: \n" + this.listaReservas.get(cliente));
        
    }
    
    public void eliminarReservas() {
        System.out.println("\nElimnando todas las reservas...");
        for (String cliente : this.listaReservas.keySet()) {
            Reserva unaReserva = this.listaReservas.get(cliente);
            Mesa mesaReservada = unaReserva.getMesaReservada();
            System.out.println("\nLiberando la mesa " + mesaReservada.getIdentificador());
            String identificador = mesaReservada.getIdentificador();
            this.listaMesas.get(Integer.parseInt(identificador) - 1).setEstaLibre(true);
        }
        System.out.println("\nComprobando que todas las mesas estan libres...");
        this.listarMesas();
        this.listaReservas.clear();
        System.out.println("\nComprobando que todas las reservas han sido borradas");
        this.mostrarReservas();
    }
}
