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
        
        
    }
    public Ruta(String nombre, String conductor,Facade f)
    {
        this.Nombre = nombre;
        this.Objetos = new ArrayList<Componente>();
        this.Conductor= conductor;
        Facade fac = f;
        f.addruta(this);        
    }

    
    @Override
    public String Mostrar() {
        String Ruta = "";
        Ruta = Ruta + "El nombre de la ruta es: "+this.Nombre + "\n" +
        "El conductor es: "+this.Conductor + "\n";               
        for(Componente c:this.Objetos) 
        {                       
            Ruta = Ruta + c.Mostrar() + "\n";            
        }
        return Ruta;       
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
    public Componente getCalle(String calle){
        Componente com = null;
        for(Componente xxx:Objetos){
            Calle calle3 = (Calle) xxx;
            if(calle3.getNombre().equalsIgnoreCase(calle))
            {
                com = xxx;
            }            
        }
        return com;        
    }        
}
