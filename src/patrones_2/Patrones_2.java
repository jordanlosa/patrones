 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import javax.swing.JOptionPane;
import static patrones_2.Facade.miscalles;

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
        
        Facade fac = new Facade();
        
        char opcion = '*';   
        do
        {
            opcion  =  JOptionPane.showInputDialog("=========Opciones=========\n"+"¿Què desea hacer? \n"+
                                                "1. Crear usuario \n"+
                                                "2. Acceder al sistema \n"+
                                                "3. Crear o registrar ruta \n"+
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
                    fac.Crear_usuario();
                break;
                case '2':                    
                    fac.Acceder_sistema();
                break;
                case '3':
                    fac.Crear_ruta();
                break;
                case '4':                    
                    
                break;
                case '5':
                    
                break;
                case '6':
                    
                break;
                case '7':                    
                    
                break;
                case '8':                    
                    
                break;
                case 'a':
                    
                break;
                case 'b':                    
                    
                break;  
                case 'c':
                    
                break;
                case 'd':                                        
                    
                break;
                case '0':
                    System.exit(opcion);
                break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no excitente");                    
                break; 
            }
        }
        while(opcion!='0');    
    }
    
}
