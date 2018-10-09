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
public class Administrador {    

    
    public Administrador() {
        
    }            
    public void create(String nombre, String correo, String numero)            
    {      
        AdaptadorAdmin adm= new AdaptadorAdmin();
        adm.setNombre(nombre);
        adm.setCorreo(correo);
        adm.setPassword(numero);
        adm.setTipo("Administrador");
    }
    public void read(Facade f)
    {              
    }
    public void update(String nombre, String correo, String numero,Facade f)
    {       
    }
    public void delete(String nombre, Facade f)            
    {        
    }      
}
