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
public class Calle implements Componente {
    private String Nombre;
    private double xo,yo,xd,yd;
    private double Distancia,Tiempo;

    @Override
    public String toString() {
        return "Calle{" + "Nombre=" + Nombre + ", xo=" + xo + ", yo=" + yo + ", xd=" + xd + ", yd=" + yd + ", Distancia=" + Distancia + ", Tiempo=" + Tiempo + '}';
    }

    public Calle() {
    }          

    public Calle(String Nombre, double xo, double yo, double xd, double yd, double Distancia, double Tiempo) {
        this.Nombre = Nombre;
        this.xo = xo;
        this.yo = yo;
        this.xd = xd;
        this.yd = yd;
        this.Distancia = Distancia;
        this.Tiempo = Tiempo;        
    }
    
    @Override
    public void Mostrar() {
        System.out.println("Calle{" + "Nombre=" + Nombre + ", xo=" + xo + ", yo=" + yo + ", xd=" + xd + ", yd=" + yd + ", Distancia=" + Distancia + ", Tiempo=" + Tiempo + '}');
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    

    public double getXo() {
        return xo;
    }

    public void setXo(double xo) {
        this.xo = xo;
    }

    public double getYo() {
        return yo;
    }

    public void setYo(double yo) {
        this.yo = yo;
    }

    public double getXd() {
        return xd;
    }

    public void setXd(double xd) {
        this.xd = xd;
    }

    public double getYd() {
        return yd;
    }

    public void setYd(double yd) {
        this.yd = yd;
    }

    public double getDistancia() {
        return Distancia;
    }

    public void setDistancia(double Distancia) {
        this.Distancia = Distancia;
    }

    public double getTiempo() {
        return Tiempo;
    }

    public void setTiempo(double Tiempo) {
        this.Tiempo = Tiempo;
    }
    
}
