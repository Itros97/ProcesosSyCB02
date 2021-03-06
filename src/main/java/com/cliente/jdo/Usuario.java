package com.cliente.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {

    @PrimaryKey
    protected String correo = null;

    //Otros valores
    protected String nombre;
    protected String nickname;
    protected String password;
    protected String apellido1;
    protected String apellido2;
    protected String direccion;
    protected int tarjetaCredito;
    protected boolean isAdmin;

    public Usuario(String nombre, String nickname, String password, String apellido1, String apellido2, String correo, String direccion, int tarjetaCredito, boolean isAdmin) {
        this.password = password;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
        this.isAdmin = isAdmin;
    }

    public Usuario() {
        this.nickname = "";
        this.password= "";
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.correo = "";
        this.direccion = "";
        this.tarjetaCredito = 0;
        this.isAdmin = false;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(int tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tarjetaCredito=" + tarjetaCredito +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
