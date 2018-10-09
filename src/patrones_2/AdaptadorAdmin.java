/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

/**
 *
 * @author JORDAN
 */
public class AdaptadorAdmin extends Usuario {
    private Administrador admin = new Administrador();

    public AdaptadorAdmin(String nombre, String correo, String numero) {
        super(nombre, correo, numero, "administrador");        
    }
    public AdaptadorAdmin()
    {
        
    }   
    public void eliminar(String nombre, Facade f) {
        this.admin.delete(nombre,f);
    }

    
    public void buscar(Facade f) {
        this.admin.read(f);
    }    
    void adicionar(String nombre, String correo, String numero) {
        this.admin.create(nombre, correo, numero);        
    }    
    void modificar(String nombre, String correo, String numero,Facade f) {
        this.admin.update(nombre, correo, numero,f);
    }          
    
}
