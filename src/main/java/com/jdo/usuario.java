package com.jdo;

import javax.jdo.annotations.*;

@PersistenceCapable
public class usuario {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    protected int id;
    //Otros valores
    protected String nombre;
    protected String password;
    protected String apellido1;
    protected String apellido2;
    protected String correo;
    protected String direccion;
    protected int tarjetaCredito;

    public usuario(String nombre, String password, String apellido1, String apellido2, String correo, String direccion, int tarjetaCredito) {
        this.password= password;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
    }
    public usuario() {
        this.id = 0;
        this.password= "";
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.correo = "";
        this.direccion = "";
        this.tarjetaCredito = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
