 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import javax.swing.JOptionPane;
import static patrones_2.Facade.miscalles;
import static patrones_2.Facade.misusers;

/**
 *
 * @author JORDAN
 */
public class Patrones_2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Componente c1 = new Calle("dj",78,98,67,54,53,52);
        Componente c2 = new Calle("dk",78,98,67,54,53,52);
        Componente c3 = new Calle("dl",78,98,67,54,53,52);
        Componente c4 = new Calle("dm",78,98,67,54,53,52);
        Componente c5 = new Calle("dn",78,98,67,54,53,52);
        Componente c6 = new Calle("do",78,98,67,54,53,52);
        miscalles.add((Calle) c1);
        miscalles.add((Calle) c2);
        miscalles.add((Calle) c3);
        miscalles.add((Calle) c4);
        miscalles.add((Calle) c5);
        miscalles.add((Calle) c6);
        Usuario con = new Conductor("Jordan","jordan@unisabana.edu.co","123-456");
        Usuario pas = new Pasajero("Juan","jordan@unisabana.edu.co","123-456");
        misusers.add(con);
        misusers.add(pas);
        
        
        Facade fac = new Facade();
        
        String opcion = "*";   
        do
        {
            opcion  =  JOptionPane.showInputDialog("=========Opciones=========\n"+"¿Què desea hacer? \n"+
                                                "1. Crear usuario \n"+
                                                "2. Acceder al sistema \n"+
                                                "3. Crear o registrar ruta \n"+
                                                "4. Consultar rutas de un conductor \n"+
                                                "5. Modificar ruta \n"+
                                                "6. Eliminar ruta \n"+
                                                "7. Crear reserva\n"+
                                                "8. Consultar reservas de un pasajero \n"+
                                                "9. Modificar reserva \n"+
                                                "10. Eliminar reserva\n"+
                                                "0. SALIR "
                                                );
            
            switch (opcion)
            {
                case "1":                                             
                    fac.Crear_usuario();
                break;
                case "2":                    
                    fac.Acceder_sistema();
                break;
                case "3":
                    fac.Crear_ruta();
                break;
                case "4":                    
                    fac.Rutas_Conductor();
                break;
                case "5":
                    fac.Editar_Ruta();
                break;
                case "6":
                    fac.Eliminar_ruta();
                break;
                case "7":                   
                    fac.Crear_reserva();
                break;
                case "8":               
                    fac.Consultar_reservas();
                break;
                case "9":
                    fac.Modificar_reserva();
                break;
                case "10":                                                         
                    fac.Eliminar_reserva();
                break;
                case "0":
                    System.exit(0);
                break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no existente");                    
                break; 
            }
        }
        while(opcion!="0");    
    }
    
}
