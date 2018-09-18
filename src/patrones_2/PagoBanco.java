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
public class PagoBanco extends PagoPSE{
    
    String numeroCuenta, tipocuenta, cedula, contraseña;

    public PagoBanco(String numeroCuenta, String cedula, String contraseña, Component SpecialPago) {
        super(SpecialPago);
        this.numeroCuenta = numeroCuenta;
        this.cedula = cedula;
        this.contraseña = contraseña;
    }
    
    public String showCuenta(){
        return SpecialPago.showCuenta()+addBanco();
    }
    
    public String addBanco(){
        return "#Cuenta: "+this.numeroCuenta+" Tipo de cuenta: "+this.tipocuenta+ "Cedula: "+this.cedula;
        
    }

    @Override
    public void setValores(String parametros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
