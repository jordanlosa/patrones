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
    
    public PagoPSE (Component SpecialPago){
        this.SpecialPago=SpecialPago;
        
    }
    
    public String showCuenta(){
    return this.SpecialPago.showCuenta();
    }
    
    public abstract void setValores(String parametros);
    
}
