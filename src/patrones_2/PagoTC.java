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

    public PagoTC(String numeroTarjeta, String codSeg, String fechaVen, Component SpecialPago) {
        super(SpecialPago);
        this.numeroTarjeta = numeroTarjeta;
        this.codSeg = codSeg;
        this.fechaVen = fechaVen;
    }
    
    public String showCuenta(){
        return SpecialPago.showCuenta()+ addTarjeta();
    }
    
    public String addTarjeta(){
        return " [Tarjeta de credito: "+this.numeroTarjeta+" - Fecha vencimiento:"+this.fechaVen+"] ";
    }

    public PagoTC(Component SpecialPago) {
        super(SpecialPago);
    }

    @Override
    public void setComponents(String parametros) {
        String[] parts = parametros.split("-");
        this.numeroTarjeta=parts[0];
        this.codSeg=parts[1];
        this.fechaVen=parts[2];
    }

    

    

    

    
    
    
}
