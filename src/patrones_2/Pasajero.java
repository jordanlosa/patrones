/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author JORDAN
 */
public class Pasajero extends Usuario {
    
    private static ArrayList<Reserva> Reservas= new ArrayList<>();

    public ArrayList<Reserva> getReservas() {
        return Reservas;
    }
    
    public Pasajero(String nombre, String correo, String password) {
        super(nombre, correo, password,"pasajero");        
    }
    public Pasajero() {
        super();        
    }                           
}
