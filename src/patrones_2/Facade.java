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

public class Facade {
    public static ArrayList<Usuario> misusers = new ArrayList<>();
    public static ArrayList<Calle> miscalles = new ArrayList<>();
    
    public void Crear_usuario()
    {
        Usuario con =  new Conductor();
        Usuario admin = new AdaptadorAdmin();
        Usuario pas = new Pasajero();
        char opcion = '*';   
        do
        {
            opcion  =  JOptionPane.showInputDialog("=========Opciones=========\n"+"¿Què desea hacer? \n"+
                                                "1. Crear conductor \n"+
                                                "2. Modificar conductor \n"+
                                                "3. Consultar conductor \n"+
                                                "4. Eliminar conductor \n"+
                                                "5. Crear administrador \n"+
                                                "6. Modificar administrador \n"+
                                                "7. Buscar administrador \n"+
                                                "8. Eliminar administrador \n"+
                                                "a. Crear pasajero \n"+
                                                "b. Modificar pasajero \n"+
                                                "c. Consultar pasajero \n"+
                                                "d. Eliminar pasajero \n"+
                                                "0. SALIR "
                                                ).charAt(0);
            
            switch (opcion)
            {
                case '1':                                             
                    con.adicionar(JOptionPane.showInputDialog("nombre"),JOptionPane.showInputDialog("correo"),JOptionPane.showInputDialog("password"));
                break;
                case '2':                    
                    con.modificar(JOptionPane.showInputDialog("nombre"),JOptionPane.showInputDialog("correo"),JOptionPane.showInputDialog("Password"));
                break;
                case '3':
                    con.buscar(JOptionPane.showInputDialog("nombre"));
                break;
                case '4':                    
                    con.eliminar(JOptionPane.showInputDialog("nombre"));
                break;
                case '5':
                    admin.adicionar(JOptionPane.showInputDialog("nombre"),JOptionPane.showInputDialog("correo"),JOptionPane.showInputDialog("Password"));
                break;
                case '6':
                    admin.modificar(JOptionPane.showInputDialog("nombre"),JOptionPane.showInputDialog("correo"),JOptionPane.showInputDialog("Password"));
                break;
                case '7':                    
                    admin.buscar(JOptionPane.showInputDialog("nombre"));
                break;
                case '8':                    
                    admin.eliminar(JOptionPane.showInputDialog("nombre"));
                break;
                case 'a':
                    pas.adicionar(JOptionPane.showInputDialog("nombre"),JOptionPane.showInputDialog("correo"),JOptionPane.showInputDialog("Password"));
                break;
                case 'b':                    
                    pas.modificar(JOptionPane.showInputDialog("nombre"),JOptionPane.showInputDialog("correo"),JOptionPane.showInputDialog("Password"));
                break;  
                case 'c':
                    pas.buscar(JOptionPane.showInputDialog("nombre"));
                break;
                case 'd':                                        
                    pas.eliminar(JOptionPane.showInputDialog("nombre"));
                break;
                case '0':
                    JOptionPane.showMessageDialog(null,"Programa terminado....................");                    
                break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no excitente");                    
                break; 
            }
        }
        while(opcion!='0');    
    }    
    
    public void Crear_ruta()
    {
         String Nombre;
     double xo,yo,xd,yd;
     double Distancia,Tiempo;     
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la ruta");
         String callenombre;
        Ruta nurut = new Ruta(nombre);
        Componente calle;
        char opcion = '*';   
        do
        {
            opcion  =  JOptionPane.showInputDialog("=========Opciones=========\n"+"¿Què desea hacer? \n"+
                                                "1. Agregar Calle nueva \n"+
                                                "2. Agregar Calle existente \n"+
                                                "0. Atras\n"                                                
                                                ).charAt(0);
            
            switch (opcion)
            {
                case '1':                                             
                    Nombre = JOptionPane.showInputDialog("nombre de la calle");
                    xo= Double.parseDouble(JOptionPane.showInputDialog("coordenada x inicio"));
                    yo= Double.parseDouble(JOptionPane.showInputDialog("coordenada y inicio"));
                    xd= Double.parseDouble(JOptionPane.showInputDialog("coordenada x destino"));
                    yd= Double.parseDouble(JOptionPane.showInputDialog("coordenada y destino"));
                    Distancia= Double.parseDouble(JOptionPane.showInputDialog("Distancia"));
                    Tiempo= Double.parseDouble(JOptionPane.showInputDialog("Tiempo"));
                    calle= new Calle(Nombre, xo,yo,xd,yd, Distancia, Tiempo);
                    miscalles.add((Calle)calle);
                    nurut.add(calle); 
                    nurut.Mostrar();
                break;
                case '2':                                    
                    System.out.print(this.mostrar());
                    callenombre = JOptionPane.showInputDialog("Ingrese el nombre de la calle que desea agregar");
                    nurut.add(this.Buscar(callenombre));
                    nurut.Mostrar();
                break;
                case '0':
                    opcion=0 ;
                break;                 
            }
        }
        while(opcion!='0');  
    }
    
    public void Acceder_sistema()
    {
        String nombre = JOptionPane.showInputDialog("Ingrese al nombre");
        String password = JOptionPane.showInputDialog("Password");
        if(this.buscar(nombre,password))
        {
            JOptionPane.showInputDialog("Bienvenido");
        }
        else
        {
            JOptionPane.showInputDialog("Usuario o contraseña incorrecta");
        }
    }
    private boolean buscar(String nombre,String password) {        
        boolean exist=false;
        for(Usuario xxx:misusers)   
        {
            if (xxx.nombre.equals(nombre) && xxx.password.equals(password)) {
                exist= true;
            }                        
        }
        return exist;
    } 
    private String mostrar()
    {
        String todos = "Todas las ruta.......\n";
         for(Calle xxx:miscalles)   
        {
            todos = todos +             
            xxx.toString() + "\n";
        }
         return todos;
    }
     private Calle Buscar(String nombre)
    {        
         for(Calle xxx:miscalles)   
        {            
                if (xxx.getNombre().equals(nombre)) {
                    return xxx;
                }            
        }
         return null;
    }
}
