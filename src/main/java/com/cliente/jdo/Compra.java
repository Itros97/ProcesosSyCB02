package com.cliente.jdo;

import javax.jdo.annotations.*;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Compra {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    protected int idCompra;
    //Datos
    //Key Externas
    @PrimaryKey
    protected Usuario CorreoUsuario;
    @PrimaryKey
    protected Producto idProductoCompra;

    public Compra(Usuario correoUsuario, Producto idProductoCompra) {
        CorreoUsuario = correoUsuario;
        this.idProductoCompra = idProductoCompra;
    }
/*
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
*/

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Usuario getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(Usuario correoUsuario) {
        CorreoUsuario = correoUsuario;
    }

    public Producto getIdProductoCompra() {
        return idProductoCompra;
    }

    public void setIdProductoCompra(Producto idProductoCompra) {
        this.idProductoCompra = idProductoCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "idCompra=" + idCompra +
                ", CorreoUsuario=" + CorreoUsuario +
                ", idProductoCompra=" + idProductoCompra +
                '}';
    }

}
