/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import javax.swing.JOptionPane;
import static patrones_2.Facade.misusers;
/**
 *
 * @author JORDAN
 */
public class Conductor extends Usuario{

        
    

    public Conductor( String nombre, String correo, String password) {
        super(nombre, correo, password, "conductor");
        
    }

    public Conductor() {
    }
            
    public void adicionar(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo =correo;
        this.password = password;
        this.tipo = "conductor";
        misusers.add(this);                
    }    
    
    public void modificar(String nombre, String correo, String password) {        
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
    Usuario getUser(String nombre, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
