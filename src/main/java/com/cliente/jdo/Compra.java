package com.cliente.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Compra {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    protected int idCompra;
    //Datos
    //Key Externas
    @PrimaryKey
    protected String CorreoUsuario;
    @PrimaryKey
    protected int idProductoCompra;

    public Compra(String correoUsuario, int idProductoCompra) {
        this.CorreoUsuario = correoUsuario;
        this.idProductoCompra = idProductoCompra;
    }

    public Compra(int idCompra, String correoUsuario, int idProductoCompra) {
        this.idCompra = idCompra;
        CorreoUsuario = correoUsuario;
        this.idProductoCompra = idProductoCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        CorreoUsuario = correoUsuario;
    }

    public int getIdProductoCompra() {
        return idProductoCompra;
    }

    public void setIdProductoCompra(int idProductoCompra) {
        this.idProductoCompra = idProductoCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +"CorreoUsuario= " + CorreoUsuario + ", idProductoCompra= " + idProductoCompra +'}';
    }

}
