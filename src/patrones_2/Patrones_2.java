/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import javax.swing.JOptionPane;

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

        Facade fac = Facade.Reemplazar();
        Usuario con = new Conductor("Jordan", "jordan@unisabana.edu.co", "123");
        Usuario pas = new Pasajero("Juan", "jordan@unisabana.edu.co", "123");
        Usuario ad = new AdaptadorAdmin("admin", "jordan@unisabana.edu.co", "123");
        Componente c1 = new Calle("Calle1", 78, 98, 67, 54, 53, 52);
        Componente c2 = new Calle("Calle2", 78, 98, 67, 54, 53, 52);
        Componente c3 = new Calle("Calle3", 78, 98, 67, 54, 53, 52);
        Componente c4 = new Calle("Calle4", 78, 98, 67, 54, 53, 52);
        Componente c5 = new Calle("Calle5", 78, 98, 67, 54, 53, 52);
        Componente c6 = new Calle("Calle6", 78, 98, 67, 54, 53, 52);

        Ruta rut = new Ruta();
        rut.setNombre("Todas");
        rut.setConductor("otro");
        rut.add(c1);
        rut.add(c2);
        rut.add(c3);
        rut.add(c4);
        rut.add(c5);
        rut.add(c6);
        fac.addruta(rut);

        fac.addusu(pas);
        fac.addusu(con);
        fac.addusu(ad);
        String opcion = "*";
        String validacion = "";
        Object[] v;
        do {
            Proxy pro = Proxy.Reemplazar();
            String nombre = JOptionPane.showInputDialog("Ingrese al nombre");
            String password = JOptionPane.showInputDialog("Password");
            validacion = pro.performOperations(nombre, password);
            v = validacion.split("-");
            if (!(v[0].equals("true"))) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña erronea");
            }
        } while (!(v[0].equals("true")));

        if (v[0].equals("true")) {
            JOptionPane.showMessageDialog(null, "Bienvenido  ----------" + v[1]);
            switch (v[1].toString()) {
                case "administrador":
                    do {
                        opcion = JOptionPane.showInputDialog("=========Opciones=========\n" + "¿Què desea hacer? \n"
                                + "1. Crear usuario \n"
                                + "2. Acceder al sistema \n"
                                + "3. Crear o registrar ruta \n"
                                + "4. Consultar rutas de un conductor \n"
                                + "5. Modificar ruta \n"
                                + "6. Eliminar ruta \n"
                                + "7. Crear reserva\n"
                                + "8. Consultar reservas de un pasajero \n"
                                + "9. Modificar reserva \n"
                                + "10. Eliminar reserva\n"
                                + "11. Pagar cuenta \n"
                                + "0. SALIR "
                        );

                        switch (opcion) {
                            case "1":
                                fac.Crear_usuario();
                                break;
                            case "2":

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
                            case "11":
                                fac.Pagar_cuenta();
                                break;
                            case "0":
                                System.exit(0);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no existente");
                                break;
                        }
                    } while (opcion != "0");
                    break;
                case "conductor":
                        do {
                        opcion = JOptionPane.showInputDialog("=========Opciones=========\n" + "¿Què desea hacer? \n"
                                                                
                                + "3. Crear o registrar ruta \n"
                                + "4. Consultar rutas de un conductor \n"
                                + "5. Modificar ruta \n"
                                + "6. Eliminar ruta \n"                                                                                                                                                               
                                + "0. SALIR "
                        );

                        switch (opcion) {
                            
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
                            case "0":
                                System.exit(0);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no existente");
                                break;
                        }
                    } while (opcion != "0");
                    break;
                case "pasajero":
                    do {
                        opcion = JOptionPane.showInputDialog("=========Opciones=========\n" + "¿Què desea hacer? \n"                                                                                               
                                                                                                
                                + "7. Crear reserva\n"
                                + "8. Consultar reservas de un pasajero \n"
                                + "9. Modificar reserva \n"
                                + "10. Eliminar reserva\n"
                                + "11. Pagar cuenta \n"
                                + "0. SALIR "
                        );

                        switch (opcion) {                            
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
                            case "11":
                                fac.Pagar_cuenta();
                                break;
                            case "0":
                                System.exit(0);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no existente");
                                break;
                        }
                    } while (opcion != "0");
                    break;
            }            
        }
    }

}
