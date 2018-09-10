/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import java.util.ArrayList;
import static patrones_2.Facade.misusers;
/**
 *
 * @author JORDAN
 */
abstract public class Usuario {
    
  String nombre;
  String correo;
  String password;
  String tipo;
 


public Usuario(String nombre, String correo, String numero,String tipo) {
        
        this.nombre = nombre;
        this.correo = correo;
        this.password = numero;
        this.tipo = tipo;
    }  
public Usuario() {        
    }  

abstract void adicionar(String nombre, String correo, String numero);
abstract void modificar(String nombre, String correo, String numero);    

public void eliminar(String nombre) {
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

    public void buscar(String nombre) {        
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
    
     public boolean existe(String nombre) {  
        
        boolean existe= false;
        for(Usuario xxx:misusers)   
        {
            if (xxx.nombre.equals(nombre)&& xxx.tipo.equals("conductor")) {
            existe= true;

            }
        }
        return existe;
    }  
    
}
