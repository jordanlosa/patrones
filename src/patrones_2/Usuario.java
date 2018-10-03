/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import java.util.ArrayList;

/**
 *
 * @author JORDAN
 */
abstract public class Usuario {
    
  String nombre;
  String correo;
  String password;
  String tipo;
 


public Usuario(String nombre, String correo, String password,String tipo) {
        
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.tipo = tipo;
    }  
public Usuario() {        
    }  

abstract void adicionar(String nombre, String correo, String password, Facade f);
abstract void modificar(String nombre, String correo, String password, Facade f);   
abstract Usuario getUser(String nombre, String tipo, Facade f);



public void eliminar(String nombre, Facade f) {
    Facade fac = f;
      ArrayList<Usuario> misusers = fac.getMisusers();
         try
        {                                                         
            for(Usuario xxx:misusers)            
            {
                if(xxx.nombre.equals(nombre))
                {                      
                   misusers.remove(xxx);
                   System.out.println("eliminado");
                }            
            }            
        }
        catch(Exception e)
        {
            
        }
    }

    public void buscar(String nombre, Facade f) {        
        Facade fac = f;
      ArrayList<Usuario> misusers = fac.getMisusers();
        for(Usuario xxx:misusers)   
        {
            if (xxx.nombre.equals(nombre)) {
            System.out.println(xxx.nombre);
            System.out.println(xxx.correo);
            System.out.println(xxx.password);            
            System.out.println(xxx.tipo);
            }
        }
    }    
    
   
    public void add(Reserva res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
