/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static patrones_2.Facade.misusers;
/**
 *
 * @author JORDAN
 */
public class Pasajero extends Usuario {
    
    private static ArrayList<Reserva> Reservas= new ArrayList<>();
    
    public Pasajero(String nombre, String correo, String numero) {
        super(nombre, correo, numero,"pasajero");        
    }
    public Pasajero() {
        super();        
    }
                   
     public void adicionar(String nombre, String correo, String numero) {
        this.nombre=nombre;
        this.correo=correo;
        this.password=numero;
        this.tipo = "pasajero";
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
                JOptionPane.showMessageDialog(null,"El pasajero no existe","ADVERTENCIA", 1);
        }
        catch(Exception e)
        {
            System.out.println("Error <<<<<<<<<<<<<<<<<<<<<<<" + e);
        }
        
    }

    public void add(Reserva res){
        this.Reservas.add(res);
    }

}
