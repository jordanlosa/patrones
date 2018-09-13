/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

/**
 *
 * @author CUGSF220
 */
public class Reserva {
    private String Pasajero;
    private String Ruta;
    private String P_encuentro;

    public Reserva(String Pasajero, String Ruta, String P_encuentro) {
        this.Pasajero = Pasajero;
        this.Ruta = Ruta;
        this.P_encuentro = P_encuentro;
    }

    public Reserva() {
    }

    public String getPasajero() {
        return Pasajero;
    }

    public void setPasajero(String Pasajero) {
        this.Pasajero = Pasajero;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }

  
    public String getP_encuentro() {
        return P_encuentro;
    }

    public void setP_encuentro(String P_encuentro) {
        this.P_encuentro = P_encuentro;
    }

    @Override
    public String toString() {
        return "Reserva{" + "Pasajero=" + Pasajero + ", Ruta=" + Ruta + ", P_encuentro=" + P_encuentro + '}';
    }
    
    
    
}
