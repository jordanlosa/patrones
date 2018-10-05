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

    @Override
    void adicionar(String nombre, String correo, String numero,Facade f) {
        this.admin.create(nombre, correo, numero, f);        
    }

    @Override
    void modificar(String nombre, String correo, String numero,Facade f) {
        this.admin.update(nombre, correo, numero,f);
    }    

    @Override
    Usuario getUser(String nombre, String tipo, Facade f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
