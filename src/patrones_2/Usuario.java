/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones_2;

import java.util.ArrayList;

/**
 *
 * @author JORDAN
 */
abstract public class Usuario {

    private String nombre;
    private String correo;
    private String password;
    private String tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario(String nombre, String correo, String password, String tipo) {

        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.tipo = tipo;
    }

    public Usuario() {
    }                    
}
