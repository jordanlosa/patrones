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
public class PagoTC extends PagoPSE{
    
    
    String numeroTarjeta, codSeg, fechaVen;

    public PagoTC(Component SpecialPago) {
        super(SpecialPago);
    }
    
    public String showCuenta(){
        return SpecialPago.showCuenta()+ addTarjeta();
    }
    
    public String addTarjeta(){
        return " Tarjeta de credito: "+this.numeroTarjeta+"- Fecha vencimiento:"+this.fechaVen;
    }

    @Override
    public void setValores(String parametros) {
       String[] parts = parametros.split("-");
       this.numeroTarjeta = parts[0];
       this.codSeg = parts[1];
       this.fechaVen = parts[2];
       
    }
    
}
