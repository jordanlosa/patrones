/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import java.util.HashMap;

/**
 *
 * @author JORDAN
 */
public class UsuarioFactory {

    private HashMap<String, Usuario> usuarios = new HashMap();
    private static UsuarioFactory unicains = null;
    public static UsuarioFactory Reemplazar()
    {
        
        if(unicains == null)
        {
            unicains = new UsuarioFactory();
        }
        return unicains;
    }

    public void adicionar(String si, Usuario tambien) {
        usuarios.put(si, tambien);
    }

    public Usuario buscar(String key) {
        return usuarios.get(key);
    }

    public boolean actualizar(String key, Usuario u) {
        Usuario resultado = null;

        resultado = usuarios.get(key);
        if (resultado == null) {
            return false;
        } else {
            usuarios.put(key, u);
            return true;
        }
    }

    public void eliminar(String key) {
        usuarios.remove(key);
    }
    
    public boolean existe(String nombre) {  
        
        Usuario resultado = null;

        resultado = usuarios.get(nombre);
        if (resultado == null) {
            return false;
        } else {           
            return true;
        }
    } 
    public HashMap<String, Usuario> gethash(){
        return this.usuarios;
    }

}
