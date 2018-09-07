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

        
    private String placa;
    
    

    public Conductor(String placa, String nombre, String correo, String numero, String tipo) {
        super(nombre, correo, numero, tipo);
        this.placa = placa;
    }

    public Conductor() {
    }
            
    public void adicionar(String nombre, String correo, String numero) {
        this.nombre = nombre;
        this.correo =correo;
        this.password = numero;
        this.tipo = "conductor";
        misusers.add(this);                
    }    
    
    void modificar(String nombre, String correo, String numero) {        
        try
        {
                        
            boolean encontrado = false;                       
            for(Usuario xxx:misusers)            
            {
                if(xxx.nombre.equals(nombre))
                {         
                   encontrado= true;
                   xxx.correo = correo;                   
                   xxx.password = numero;
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
    
}
