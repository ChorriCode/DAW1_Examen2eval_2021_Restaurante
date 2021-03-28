/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2eval;

/**
 *
 * @author Javier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante("Casa Paco", 10);
        restaurante.mostrarRestaurante();
        //Reserva reserva1 = new Reserva("Manolo", 2, 1, 1, 2021);
        //Reserva reserva2 = new Reserva("Juan", 4, 1, 1, 2021);
        restaurante.reservarMesa("Manolo", 2);
        restaurante.reservarMesa("Juan", 4);
        restaurante.reservarMesa("María", 4);
        restaurante.mostrarReservas();
        restaurante.mostrarReserva("Juan");
        restaurante.eliminarReservas();
    }

}
