package com.cliente.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Carrito {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
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

    public Carrito(String nickname, String nombre, double precioCarrito) {
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

    @Override
    public String toString() {
        return "Carrito{" +
                "idCarrito= " + idCarrito +
                ", nickname= " + nickname +
                ", nombre= " + nombre +
                ", precioCarrito= " + precioCarrito +
                '}';
    }
}
