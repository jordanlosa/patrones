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
    
    String numeroCuenta, tipoCuenta, cedula, contraseña;

    public PagoBanco(String numeroCuenta, String cedula,String tipocuenta, String contraseña, Component SpecialPago) {
        super(SpecialPago);
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta= tipocuenta;
        this.cedula = cedula;
        this.contraseña = contraseña;
    }

    PagoBanco(Component com) {
        super(com);
    }
    
    public String showCuenta(){
        return SpecialPago.showCuenta()+addBanco();
    }
    
    public String addBanco(){
        return " [#Cuenta: "+this.numeroCuenta+" - Tipo de cuenta: "+this.tipoCuenta+ " - Cedula: "+this.cedula+"] ";
        
    }

    @Override

    public void setComponents(String parametros) {
        String[] parts = parametros.split("-");
        this.numeroCuenta=parts[0];
        this.tipoCuenta=parts[1];
        this.cedula=parts [2];
        this.contraseña=parts[3];
        

    }
    
    
    
}
