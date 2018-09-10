/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import java.util.ArrayList;
import static patrones_2.Facade.misrutas;


/**
 *
 * @author JORDAN
 */
public class Ruta implements Componente {
    public static ArrayList<Componente> Objetos;

    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    private String Conductor;

    public String getConductor() {
        return Conductor;
    }

    public void setConductor(String Conductor) {
        this.Conductor = Conductor;
    }
    
    public Ruta() {
        this.Objetos = new ArrayList<Componente>();
        misrutas.add(this);
        
    }
    public Ruta(String nombre, String conductor)
    {
        this.Nombre = nombre;
        this.Objetos = new ArrayList<Componente>();
        this.Conductor= conductor;
        misrutas.add(this);
    }

    
    @Override
    public void Mostrar() {
        
        System.out.println("El nombre de la ruta es: "+this.Nombre);
        System.out.println("El conductor es: "+this.Conductor);
        for(Componente c:this.Objetos) 
        {                       
            c.Mostrar();            
        }
        
        System.out.println("Fin de ruta");
    }
    
    public void Eliminar(Componente componente) {        
        for(Componente c:this.Objetos) {
            if (c.equals(componente))   {           
            this.Objetos.remove(componente);
            }
        }
            
    }
    
    
    
    
    
    
    public void add(Componente c)
    {
        Objetos.add(c);
    }         
}
