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
public class Conductor extends Usuario{

        
    

    public Conductor(String nombre, String correo, String password) {
        super(nombre, correo, password, "conductor");        
    }

    public Conductor() {
    }
            
    public void adicionar(String nombre, String correo, String password) {                
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setPassword(password);
        this.setTipo("conductor"); 
    }               
}
