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
    //public static ArrayList<Calle> miscalles = new ArrayList<>();
    public static ArrayList<Ruta> misrutas= new ArrayList<>();
    public static ArrayList<Reserva> misreservas= new ArrayList<>();
    
    
    Ruta ruta= new Ruta();

    public void Crear_usuario() {

        Usuario con = new Conductor();
        Usuario pas= new Pasajero();
     
        Usuario admin = new AdaptadorAdmin();
        
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
        Usuario con = new Conductor();
        Usuario pas= new Pasajero();
        String conductor = JOptionPane.showInputDialog("Ingrese el nombre del conductor");

        boolean existe = con.existe(conductor, "conductor");
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
                        misrutas.get(0).add(calle);
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
        return misrutas.get(0).Mostrar();
    }

    private Calle Buscar(String nombre) {
        return (Calle) misrutas.get(0).getCalle(nombre);        
    }
    
    public void Rutas_Conductor (){
        Usuario con = new Conductor();
        Usuario pas= new Pasajero();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del conductor");
        boolean existe = con.existe(nombre, "conductor");
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
        Usuario con = new Conductor();
        Usuario pas= new Pasajero();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del conductor");
        boolean existe = con.existe(nombre, "conductor");
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
                                misrutas.get(0).add(calle);
                                xxx.add(calle);
                                xxx.Mostrar();
                                break;
                            case '2':
                                System.out.print(this.Mostrar());
                                callenombre = JOptionPane.showInputDialog("Ingrese el nombre de la calle que desea agregar");
                                if(!(this.Buscar(callenombre) == null)) xxx.add(this.Buscar(callenombre));                                
                                xxx.Mostrar();
                                break;
                            case '3':
                                callenombre = JOptionPane.showInputDialog("Ingrese el nombre de la calle que desea eliminar");                                                                
                                if(!(xxx.getCalle(callenombre)==null)) xxx.Eliminar(xxx.getCalle(callenombre));
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
        con=null;
    }
    
     public void Eliminar_ruta(){
         Usuario con = new Conductor();
        Usuario pas= new Pasajero();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del conductor");
        boolean existe = con.existe(nombre, "conductor");
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
        
        Usuario pas= new Pasajero();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        boolean existe = pas.existe(nombre, "pasajero");
        if (existe) {
            String ruta = JOptionPane.showInputDialog("Escriba el nombre de la ruta");
            if (this.ruta.existe(ruta)) {
                String p_encuentro = JOptionPane.showInputDialog("Ingrese el punto de encuentro");
                Reserva res = new Reserva(nombre, ruta, p_encuentro);
                pas.add(res);
                JOptionPane.showMessageDialog(null, "Reserva creada satisfactoriamente");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El pasajero no existe");
            this.Crear_reserva();
        }
        
    }
    
    public void Consultar_reservas() {
        
        Usuario pas= new Pasajero();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        boolean existe = pas.existe(nombre, "pasajero");
        if (existe) {
           pas= pas.getUser(nombre, "pasajero");
           Pasajero pasajero = (Pasajero) pas;
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
        
        Usuario pas= new Pasajero();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        boolean existe = pas.existe(nombre, "pasajero");
        if (existe) {
           pas= pas.getUser(nombre, "pasajero");
           Pasajero pasajero = (Pasajero) pas;
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
        Usuario pas= new Pasajero();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        boolean existe = pas.existe(nombre, "pasajero");
        if (existe) {
           pas= pas.getUser(nombre, "pasajero");
           Pasajero pasajero = (Pasajero) pas;
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
        
        Usuario pas= new Pasajero();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del pasajero");
        String conductor = "";
        boolean existe = pas.existe(nombre, "pasajero");
        if (existe) {
            pas = pas.getUser(nombre, "pasajero");
            Pasajero pasajero = (Pasajero) pas;
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
        String pars= valor+"-"+conductor+"-"+nombre;
        Component com=  new Pago();
        com.setComponents(pars);
        
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

                                String parametros= numT+"-"+codSeg+"-"+fechaV;
                                PagoTC pagotc = new PagoTC(com);
                                pagotc.setComponents(parametros);
                                com = pagotc;
                                JOptionPane.showMessageDialog(null, "Pago satisfactorio");
                                

                                break;
                            case '2':
                                String numC = JOptionPane.showInputDialog("Ingrese el numero de cuenta");
                                String tipoC= JOptionPane.showInputDialog("Ingrese el tipo de cuenta");
                                String cedula = JOptionPane.showInputDialog("Ingrese la cedula");
                                String contraseña = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento");
                                String parametros2 = numC+"-"+ tipoC+"-"+ cedula+"-"+ contraseña;
                                PagoBanco pagobanco = new PagoBanco(com);
                                pagobanco.setComponents(parametros2);
                                com= pagobanco;
                                JOptionPane.showMessageDialog(null, "Pago satisfactorio");
              
                                break;   
                            case '0':
                                JOptionPane.showMessageDialog(null, "Atrás");
                                break;
                        }
                    } while (opcion != '0');
                    System.out.println(com.showCuenta());

        } else {
            JOptionPane.showMessageDialog(null, "El pasajero no existe");
            this.Crear_reserva();
        }
    }

}
