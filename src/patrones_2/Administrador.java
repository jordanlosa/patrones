/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import static patrones_2.Facade.misusers;

import javax.swing.JOptionPane;

/**
 *
 * @author JORDAN
 */
public class Administrador {    

    //adaptadorAdmin adm= new adaptadorAdmin();
    public Administrador() {
        
    }            
    public void create(String nombre, String correo, String numero)            
    {
        /*adm.nombre=nombre;
        adm.correo=correo;
        adm.numero=numero;
        misusers.add(adm);*/
    }
    public void read()
    {
        for(int x=0;x<misusers.size();x++)
        {
            System.out.println(misusers.get(x).nombre);
             System.out.println(misusers.get(x).correo);
              System.out.println(misusers.get(x).password);
               System.out.println(misusers.get(x).tipo);
        }
    }
    public void update(String nombre, String correo, String numero)
    {
                try
        {                        
            boolean encontrado = false;                       
            for(Usuario xxx:misusers)            
            {
                if(xxx.nombre.equals(nombre))
                {                                         
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
    public void delete(String nombre)
    {
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
}
