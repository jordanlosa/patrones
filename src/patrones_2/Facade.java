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
    public static ArrayList<Ruta> misrutas= new ArrayList<>();
    public static ArrayList<Reserva> misreservas= new ArrayList<>();
    
    Usuario con = new Conductor();
    Usuario pas= new Pasajero();
    Ruta ruta= new Ruta();

    public void Crear_usuario() {

        Usuario admin = new AdaptadorAdmin();
        Usuario pas = new Pasajero();
        char opcion = '*';
        do {
            opcion = JOptionPane.showInputDialog("=========Opciones=========\n" + "¿Què desea hacer? \n"
                    + "1. Crear conductor \n"
                    + "2. Modificar conductor \n"
                    + "3. Consultar conductor \n"
                    + "4. Eliminar conductor \n"
                    + "5. Crear administrador \n"
                    + "6. Modificar administrador \n"
                    + "7. Buscar administrador \n"
                    + "8. Eliminar administrador \n"
                    + "a. Crear pasajero \n"
                    + "b. Modificar pasajero \n"
                    + "c. Consultar pasajero \n"
                    + "d. Eliminar pasajero \n"
                    + "0. SALIR "
            ).charAt(0);

            switch (opcion) {
                case '1':
                    con.adicionar(JOptionPane.showInputDialog("nombre"), JOptionPane.showInputDialog("correo"), JOptionPane.showInputDialog("password"));
                    break;
                case '2':
                    con.modificar(JOptionPane.showInputDialog("nombre"), JOptionPane.showInputDialog("correo"), JOptionPane.showInputDialog("Password"));
                    break;
                case '3':
                    con.buscar(JOptionPane.showInputDialog("nombre"));
                    break;
                case '4':
                    con.eliminar(JOptionPane.showInputDialog("nombre"));
                    break;
                case '5':
                    admin.adicionar(JOptionPane.showInputDialog("nombre"), JOptionPane.showInputDialog("correo"), JOptionPane.showInputDialog("Password"));
                    break;
                case '6':
                    admin.modificar(JOptionPane.showInputDialog("nombre"), JOptionPane.showInputDialog("correo"), JOptionPane.showInputDialog("Password"));
                    break;
                case '7':
                    admin.buscar(JOptionPane.showInputDialog("nombre"));
                    break;
                case '8':
                    admin.eliminar(JOptionPane.showInputDialog("nombre"));
                    break;
                case 'a':
                    pas.adicionar(JOptionPane.showInputDialog("nombre"), JOptionPane.showInputDialog("correo"), JOptionPane.showInputDialog("Password"));
                    break;
                case 'b':
                    pas.modificar(JOptionPane.showInputDialog("nombre"), JOptionPane.showInputDialog("correo"), JOptionPane.showInputDialog("Password"));
                    break;
                case 'c':
                    pas.buscar(JOptionPane.showInputDialog("nombre"));
                    break;
                case 'd':
                    pas.eliminar(JOptionPane.showInputDialog("nombre"));
                    break;
                case '0':
                    JOptionPane.showMessageDialog(null, "Programa terminado....................");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no existente");
                    break;
            }
        } while (opcion != '0');
    }

    public void Crear_ruta() {

        double xo, yo, xd, yd;
        double Distancia, Tiempo;
        String callenombre;
        String conductor = JOptionPane.showInputDialog("Ingrese el nombre del conductor");

        boolean existe = this.con.existe(conductor, "conductor");
        if (existe) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la ruta");
            Ruta nurut = new Ruta(nombre, conductor);
            Componente calle;
            char opcion = '*';
            do {
                opcion = JOptionPane.showInputDialog("=========Opciones=========\n" + "¿Què desea hacer? \n"
                        + "1. Agregar Calle nueva \n"
                        + "2. Agregar Calle existente \n"
                        + "0. Atras\n"
                ).charAt(0);

                switch (opcion) {
                    case '1':
                        callenombre = JOptionPane.showInputDialog("nombre de la calle");
                        xo = Double.parseDouble(JOptionPane.showInputDialog("coordenada x inicio"));
                        yo = Double.parseDouble(JOptionPane.showInputDialog("coordenada y inicio"));
                        xd = Double.parseDouble(JOptionPane.showInputDialog("coordenada x destino"));
                        yd = Double.parseDouble(JOptionPane.showInputDialog("coordenada y destino"));
                        Distancia = Double.parseDouble(JOptionPane.showInputDialog("Distancia"));
                        Tiempo = Double.parseDouble(JOptionPane.showInputDialog("Tiempo"));
                        calle = new Calle(callenombre, xo, yo, xd, yd, Distancia, Tiempo);
                        miscalles.add((Calle) calle);
                        nurut.add(calle);
                        nurut.Mostrar();
                        break;
                    case '2':
                        System.out.print(this.Mostrar());
                        callenombre = JOptionPane.showInputDialog("Ingrese el nombre de la calle que desea agregar");
                        nurut.add(this.Buscar(callenombre));
                        nurut.Mostrar();
                        break;
                    case '0':
                        JOptionPane.showMessageDialog(null, "Atrás");
                        break;
                }
            } while (opcion != '0');
        } else {
            JOptionPane.showMessageDialog(null, "El conductor " + conductor + " no existe");
            this.Crear_ruta();
        }
        
    }

    public void Acceder_sistema() {
        String nombre = JOptionPane.showInputDialog("Ingrese al nombre");
        String password = JOptionPane.showInputDialog("Password");
        if (this.BuscarUsuario(nombre, password)) {
            JOptionPane.showInputDialog("Bienvenido");
        } else {
            JOptionPane.showInputDialog("Usuario o contraseña incorrecta");
        }
    }

    private boolean BuscarUsuario(String nombre, String password) {
        boolean exist = false;
        for (Usuario xxx : misusers) {
            if (xxx.nombre.equals(nombre) && xxx.password.equals(password)) {
                exist = true;
            }
        }
        return exist;
    }

    private String Mostrar() {
        String todos = "Todas las ruta.......\n";
        for (Calle xxx : miscalles) {
            todos = todos
                    + xxx.toString() + "\n";
        }
        return todos;
    }

    private Calle Buscar(String nombre) {
        for (Calle xxx : miscalles) {
            if (xxx.getNombre().equals(nombre)) {
                return xxx;
            }
        }
        return null;
    }
    
    public void Rutas_Conductor (){
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del conductor");
        boolean existe = this.con.existe(nombre, "conductor");
        if (existe){
            for (Ruta xxx:misrutas){
                if (xxx.getConductor().equals(nombre)){
                xxx.Mostrar();
                }
                else System.out.println("El conductor "+nombre+ " no tiene rutas asignadas aún");
            }
        }
        else System.out.println("El conductor "+nombre+ " no existe");
 
    }
    
    public void Editar_Ruta() {
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del conductor");
        boolean existe = this.con.existe(nombre, "conductor");
        if (existe) {
            String ruta = JOptionPane.showInputDialog("Ingrese el nombre de la ruta");
            for (Ruta xxx : misrutas) {
                if (xxx.getConductor().equals(nombre) && xxx.getNombre().equals(ruta)) {
                    
                    double xo, yo, xd, yd;
                    double Distancia, Tiempo;
                    String callenombre;
                    Componente calle;
                    char opcion = '*';
                    do {
                        opcion = JOptionPane.showInputDialog("=========Opciones=========\n" + "¿Qué desea hacer? \n"
                                + "1. Agregar Calle nueva \n"
                                + "2. Agregar Calle existente \n"
                                + "3. Quitar calle \n"
                                + "0. Atras\n"
                        ).charAt(0);

                        switch (opcion) {
                            case '1':
                                callenombre = JOptionPane.showInputDialog("nombre de la calle");
                                xo = Double.parseDouble(JOptionPane.showInputDialog("coordenada x inicio"));
                                yo = Double.parseDouble(JOptionPane.showInputDialog("coordenada y inicio"));
                                xd = Double.parseDouble(JOptionPane.showInputDialog("coordenada x destino"));
                                yd = Double.parseDouble(JOptionPane.showInputDialog("coordenada y destino"));
                                Distancia = Double.parseDouble(JOptionPane.showInputDialog("Distancia"));
                                Tiempo = Double.parseDouble(JOptionPane.showInputDialog("Tiempo"));
                                calle = new Calle(callenombre, xo, yo, xd, yd, Distancia, Tiempo);
                                miscalles.add((Calle) calle);
                                xxx.add(calle);
                                xxx.Mostrar();
                                break;
                            case '2':
                                System.out.print(this.Mostrar());
                                callenombre = JOptionPane.showInputDialog("Ingrese el nombre de la calle que desea agregar");
                                xxx.add(this.Buscar(callenombre));
                                xxx.Mostrar();
                                break;
                            case '3':
                                callenombre = JOptionPane.showInputDialog("Ingrese el nombre de la calle que desea eliminar");
                                for (Calle street: miscalles){
                                    if(street.getNombre().equals(callenombre)){
                                        xxx.Eliminar(street);
                                    }
                                }
                                xxx.Mostrar();
                                break;    
                            case '0':
                                JOptionPane.showMessageDialog(null, "Atrás");
                                break;
                        }
                    } while (opcion != '0');

                } else {
                    System.out.println("El conductor " + nombre + " no tiene rutas asignadas aún");
                }
            }
        } else {
            System.out.println("El conductor " + nombre + " no existe");
        }
        this.con=null;
    }
    
     public void Eliminar_ruta(){
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del conductor");
        boolean existe = this.con.existe(nombre, "conductor");
        boolean existeRuta = false;
        if (existe){
            for(Ruta xxx:misrutas){
                if (xxx.getConductor().equals(nombre)){
                    xxx.Mostrar();
                }
                else System.out.println("El conductor "+nombre+ " no tiene rutas asignadas aún");
            }
            String nombreRuta = JOptionPane.showInputDialog("Escriba el nombre de la Ruta que desea eliminar");
            for (Ruta xxx:misrutas){
                if (xxx.getNombre().equals(nombreRuta)){
                    existeRuta = true;
                    misrutas.remove(xxx);
                }                
            }
            if(!existeRuta)
            {
                System.out.println("La ruta "+nombreRuta+" no existe");
            }
        }
        else System.out.println("El conductor "+nombre+ " no existe");        
    }
    
    public void Crear_reserva() {
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        boolean existe = this.pas.existe(nombre, "pasajero");
        if (existe) {
            String ruta = JOptionPane.showInputDialog("Escriba el nombre de la ruta");
            if (this.ruta.existe(ruta)) {
                String p_encuentro = JOptionPane.showInputDialog("Ingrese el punto de encuentro");
                Reserva res = new Reserva(nombre, ruta, p_encuentro);
                this.pas.add(res);
                JOptionPane.showMessageDialog(null, "Reserva creada satisfactoriamente");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El pasajero no existe");
            this.Crear_reserva();
        }
        
    }
    
    public void Consultar_reservas() {
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        boolean existe = this.pas.existe(nombre, "pasajero");
        if (existe) {
           this.pas= this.pas.getUser(nombre, "pasajero");
           Pasajero pasajero = (Pasajero) this.pas;
           ArrayList<Reserva> reservas = pasajero.getReservas();
           for(Reserva xxx:reservas){
               System.out.println(xxx.toString());
           }
        } else {
            JOptionPane.showMessageDialog(null, "El pasajero no existe");
            this.Crear_reserva();
        }
        
    }   
    public void Modificar_reserva(){
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        boolean existe = this.pas.existe(nombre, "pasajero");
        if (existe) {
           this.pas= this.pas.getUser(nombre, "pasajero");
           Pasajero pasajero = (Pasajero) this.pas;
           ArrayList<Reserva> reservas = pasajero.getReservas();
           for(Reserva xxx:reservas){
               System.out.println(xxx.toString());
           }
           String nombreRuta = JOptionPane.showInputDialog("Escriba el nombre del ruta ha modificar");           
           for(Reserva xxx:reservas){               
               if(xxx.getRuta().equals(nombreRuta)){
                   String posicionNueva = JOptionPane.showInputDialog("Escriba el nuevo punto de encuentro");
                   xxx.setP_encuentro(posicionNueva);
               }                        
           }           
        } else {
            JOptionPane.showMessageDialog(null, "El pasajero no existe");
            this.Crear_reserva();
        }
    }
   
    public void Eliminar_reserva(){
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        boolean existe = this.pas.existe(nombre, "pasajero");
        if (existe) {
           this.pas= this.pas.getUser(nombre, "pasajero");
           Pasajero pasajero = (Pasajero) this.pas;
           ArrayList<Reserva> reservas = pasajero.getReservas();
           String ruta = JOptionPane.showInputDialog("Escriba el nombre de la ruta para eliminar la reserva");
           for(Reserva xxx:reservas){
               if(xxx.getRuta().equalsIgnoreCase(ruta)){
                reservas.remove(xxx);
                System.out.println(reservas.toString());
                JOptionPane.showMessageDialog(null, "Reserva eliminada satisfactoriamente");
                break;
               }
               else JOptionPane.showMessageDialog(null, "No existen reservas de este pasajero para esa ruta");
           }
        } else {
            JOptionPane.showMessageDialog(null, "El pasajero no existe");
            this.Eliminar_reserva();
        }
    
    }
    
    public void Pagar_cuenta() {
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        String conductor = null;
        boolean existe = this.pas.existe(nombre, "pasajero");
        if (existe) {
            this.pas = this.pas.getUser(nombre, "pasajero");
            Pasajero pasajero = (Pasajero) this.pas;
            ArrayList<Reserva> reservas = pasajero.getReservas();
            for (Reserva xxx : reservas) {
                System.out.println(xxx.toString());
            }
            String nombreRuta = JOptionPane.showInputDialog("Escriba el nombre del ruta para pagar la reserva");
            for (Reserva xxx : reservas) {
                if (xxx.getRuta().equals(nombreRuta)) {
                    for (Ruta rrr : misrutas) {
                        if (nombreRuta.equals(rrr.getNombre())) {
                            conductor = rrr.getConductor();
                        }
                    }
                }
            }
            
        int valor= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la cuenta"));
        Pago pago= new Pago();
        
        char opcion = '*';
                    do {
                        opcion = JOptionPane.showInputDialog("=========Opciones=========\n" + "¿Qué desea hacer? \n"
                                + "1. Pagar por tarjeta de credito \n"
                                + "2. Pagar por banco\n"
                                + "0. Atras\n"
                        ).charAt(0);

                        switch (opcion) {
                            case '1':
                                String numT= JOptionPane.showInputDialog("Ingrese el numero de tarjeta");
                                String codSeg= JOptionPane.showInputDialog("Ingrese el codigo de seguridad");
                                String fechaV= JOptionPane.showInputDialog("Ingrese la fecha de vencimiento");
                                String parametros =valor+"-"+conductor+"-"+nombre;
                                pago.setValores(parametros);
                                Component com=  new PagoTC(numT,codSeg,fechaV, pago);
                                System.out.print(com.showCuenta());
                                break;
                            case '2':
                               
                                break;   
                            case '0':
                                JOptionPane.showMessageDialog(null, "Atrás");
                                break;
                        }
                    } while (opcion != '0');

        } else {
            JOptionPane.showMessageDialog(null, "El pasajero no existe");
            this.Crear_reserva();
        }
    }

}
