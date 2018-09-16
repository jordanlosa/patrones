/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

/**
 *
 * @author juandiego1598
 */
public class Pago implements Component {
    
    int valor;
    String conductor, pasajero;

    @Override
    public String showCuenta() {
      return "Pago{" + "valor=" + valor + ", conductor=" + conductor + ", pasajero=" + pasajero + '}';    
    }

    public Pago(int valor, String conductor, String pasajero) {
        this.valor = valor;
        this.conductor = conductor;
        this.pasajero = pasajero;
    }

    public Pago() {
    }

    @Override
    public void setComponents(String parametros) {
        String[] parts = parametros.split("-");
        this.valor=Integer.parseInt(parts[0]);
        this.conductor=parts[1];
        this.pasajero=parts[2];
    }

    
   
  }

    
   
    
    

