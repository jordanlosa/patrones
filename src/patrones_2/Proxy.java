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
public class Proxy implements IFolder{
    
    
    
    private Facade fac = Facade.Reemplazar();
    private static Proxy unicains = null;
    ArrayList <Usuario> users2 = fac.getMisusers();
    
    
    public Proxy() {
        
    }
    
    public static Proxy Reemplazar()
    {
        
        if(unicains == null)
        {
            unicains = new Proxy();
        }
        return unicains;
    }
    
    
    @Override
    public String performOperations(String us, String pas) {                
        String re = "";  
        for(Usuario xxx:users2)   
        {            
            if (xxx.nombre.equals(us)&& xxx.password.equals(pas)) {
                re = "true"+"-"+xxx.tipo;            
            }        
        }        
        return re;
    }
    
}
