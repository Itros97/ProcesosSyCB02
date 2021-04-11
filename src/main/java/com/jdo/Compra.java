package com.jdo;

import javax.jdo.annotations.*;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Compra {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    protected int idCompra;
    //Datos

    //Key Externas
    @ForeignKey
    protected String CorreoUsuario;
    @ForeignKey
    protected int idProductoCompra;

    public Compra(int idCompra, String CorreoUsuario, int idProductoCompra) {

        this.CorreoUsuario = CorreoUsuario;
        this.idProductoCompra = idProductoCompra;
    }

    public Compra() {
   //     this.idCompra = 0;
        this.CorreoUsuario = "";
        this.idProductoCompra = 0;
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
}
