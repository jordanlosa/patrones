/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author JORDAN
 */
public class Proxy implements IFolder{
    
    
    
    private UsuarioFactory fac = UsuarioFactory.Reemplazar();
    private static Proxy unicains = null;
    private HashMap<String, Usuario> users2 = fac.gethash();
    
    
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
            if (users2.get(us)!=null&&users2.get(us).getPassword().equals(pas)) {
                re = "true"+"-"+users2.get(us).getTipo();            
            }                    
        return re;
    }
    
}
