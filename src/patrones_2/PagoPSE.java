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
abstract public class PagoPSE implements Component {
    
    protected Component SpecialPago;
    String Confirmacion_pago;
    
    abstract public void setComponents(String parametros);
    
    public PagoPSE (Component SpecialPago){
        this.SpecialPago=SpecialPago;
        
    }
    
    public String showCuenta(){
        return this.SpecialPago.showCuenta()+this.addPagoPSE();
    }
    
    public String addPagoPSE(){
        return " [Confirmacion de pago: "+this.Confirmacion_pago+"] ";
    }

    

}
