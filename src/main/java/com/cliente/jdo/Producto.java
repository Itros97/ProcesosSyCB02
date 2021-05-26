package com.cliente.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Producto {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    protected int idProducto = 0;

    protected String nombre;
    protected String marca;
    protected float precio;
    protected String descripcion;

    /**
     * This is the Product Constructor (not id) used for show data into ApiRest
     * @param nombre
     * @param marca
     * @param precio
     * @param descripcion
     */
    
    public Producto(String nombre, String marca, float precio, String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    public Producto() {
       // this.idProducto = 0;
        this.nombre = "";
        this.marca = "";
        this.precio = 0.0f;
        this.descripcion = "";
    }

    /**
     * This is the Product Constructor with id , used for create products as admin
     * @param idProducto
     * @param nombre
     * @param marca
     * @param precio
     * @param descripcion
     */
    public Producto(int idProducto, String nombre, String marca, float precio, String descripcion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;

    }

    @Override
    public String toString() {
        return  nombre+","+ marca +
                ", precio=" + precio;
    }
}
