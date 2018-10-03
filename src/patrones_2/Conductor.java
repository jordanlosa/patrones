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
public class Conductor extends Usuario{

        
    

    public Conductor(String nombre, String correo, String password) {
        super(nombre, correo, password, "conductor");        
    }

    public Conductor() {
    }
            
    public void adicionar(String nombre, String correo, String password, Facade f) {                
        this.nombre = nombre;
        this.correo =correo;
        this.password = password;
        this.tipo = "conductor";
        f.addusu(this);                
    }    
    
    public void modificar(String nombre, String correo, String password, Facade f) {        
        Facade fac = f;
        ArrayList<Usuario> misusers = fac.getMisusers();
        try
        {
                        
            boolean encontrado = false;                       
            for(Usuario xxx:misusers)            
            {
                if(xxx.nombre.equals(nombre))
                {         
                   encontrado= true;
                   xxx.correo = correo;                   
                   xxx.password = password;
                   System.out.print("Modificado");
                }            
            }
            if(!encontrado)            
                JOptionPane.showMessageDialog(null,"El conductor no existe","ADVERTENCIA", 1);
        }
        catch(Exception e)
        {
            System.out.println("Error <<<<<<<<<<<<<<<<<<<<<<<" + e);
        }
        
    }

    @Override
    Usuario getUser(String nombre, String tipo, Facade f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
