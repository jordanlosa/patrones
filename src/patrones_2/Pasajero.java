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
public class Pasajero extends Usuario {
    
    private static ArrayList<Reserva> Reservas= new ArrayList<>();

    public ArrayList<Reserva> getReservas() {
        return Reservas;
    }
    
    public Pasajero(String nombre, String correo, String password) {
        super(nombre, correo, password,"pasajero");        
    }
    public Pasajero() {
        super();        
    }
                   
    @Override
     public void adicionar(String nombre, String correo, String password,Facade f) {
        this.nombre=nombre;
        this.correo=correo;
        this.password=password;
        this.tipo = "pasajero";
        Facade fac = f;
        f.addusu(this);        
    }    
             

    public void add(Reserva res){
        this.Reservas.add(res);
    }          

    @Override
    void modificar(String nombre, String correo, String password, Facade f) {
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
                JOptionPane.showMessageDialog(null,"El pasajero no existe","ADVERTENCIA", 1);
        }
        catch(Exception e)
        {
            System.out.println("Error <<<<<<<<<<<<<<<<<<<<<<<" + e);
        }
    }

    @Override
    Usuario getUser(String nombre, String tipo,Facade f) {
        Facade fac= f;
        ArrayList<Usuario> misusers = fac.getMisusers();
        for(Usuario xxx:misusers)   
        {
            if (xxx.nombre.equals(nombre)&& xxx.tipo.equals(tipo)) {
            return xxx;
            }
        }
        
        return null;
    }

    

}
