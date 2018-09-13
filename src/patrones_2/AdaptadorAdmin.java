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

    public AdaptadorAdmin(String nombre, String correo, String numero, String tipo) {
        super(nombre, correo, numero, tipo);        
    }
    public AdaptadorAdmin()
    {
        
    }   
    public void eliminar(String nombre) {
        this.admin.delete(nombre);
    }

    
    public void buscar() {
        this.admin.read();
    }

    @Override
    void adicionar(String nombre, String correo, String numero) {
        this.admin.create(nombre, correo, numero);        
    }

    @Override
    void modificar(String nombre, String correo, String numero) {
        this.admin.update(nombre, correo, numero);
    }

    @Override
    Usuario getUser(String nombre, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
