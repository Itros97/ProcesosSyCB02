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
    protected int idUsuarioCompra;

    @ForeignKey
    protected int idProductoCompra;

    public Compra(int idCompra, int idUsuarioCompra, int idProductoCompra) {
        this.idCompra = idCompra;
        this.idUsuarioCompra = idUsuarioCompra;
        this.idProductoCompra = idProductoCompra;
    }

    public Compra() {
        this.idCompra = 0;
        this.idUsuarioCompra = 0;
        this.idProductoCompra = 0;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuarioCompra() {
        return idUsuarioCompra;
    }

    public void setIdUsuarioCompra(int idUsuarioCompra) {
        this.idUsuarioCompra = idUsuarioCompra;
    }

    public int getIdProductoCompra() {
        return idProductoCompra;
    }

    public void setIdProductoCompra(int idProductoCompra) {
        this.idProductoCompra = idProductoCompra;
    }
}
