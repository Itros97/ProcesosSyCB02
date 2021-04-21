package com.cliente.jdo;

import javax.jdo.annotations.*;

@PersistenceCapable

public class Carrito {

    public int idCarrito;
    public String nickname;
    public String nombre;
    public double precioCarrito;

    public Carrito(int idCarrito, String nickname, String nombre, double precioCarrito) {
        this.idCarrito = idCarrito;
        this.nickname = nickname;
        this.nombre = nombre;
        this.precioCarrito = precioCarrito;
    }

    public Carrito() {
        this.idCarrito = 0;
        this.nickname = "";
        this.nombre = "";
        this.precioCarrito = 0;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCarrito() {
        return precioCarrito;
    }

    public void setPrecioCarrito(double precioCarrito) {
        this.precioCarrito = precioCarrito;
    }
}
