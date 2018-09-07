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
public class Ruta implements Componente {
    public static ArrayList<Componente> Objetos;

    private String Nombre;
    
    public Ruta() {
        this.Objetos = new ArrayList<Componente>();
    }
    public Ruta(String nombre)
    {
        this.Nombre = nombre;
        this.Objetos = new ArrayList<Componente>();
    }

    
    @Override
    public void Mostrar() {
        
        System.out.println(this.Nombre);
        for(Componente c:Objetos) 
        {                       
            c.Mostrar();            
        }
        
        System.out.println("Fin de ruta");
    }
    public void add(Componente c)
    {
        Objetos.add(c);
    }         
}
