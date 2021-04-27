package com.cliente.jdo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CompraTest {

    Compra c = new Compra("mikel.gmail.com", 5);

    @Test
    public void testGetCorreoUsuario(){
        assertEquals("mikel.gmail.com", c.getCorreoUsuario());
    }

    @Test
    public void testGetIdProductoCompra(){
        assertEquals(5, c.getIdProductoCompra());
    }

    @Test
    public void testSetCorreoUsuario(){
        c.setCorreoUsuario("prueba@gamil.com");
        assertEquals("prueba@gamil.com", c.getCorreoUsuario());
    }

    @Test
    public void testSetIdProductoCompra(){
        c.setIdProductoCompra(5);
        assertEquals(5, c.getIdProductoCompra());
    }

    @Test
    public void testToString() {
        String expected = "Compra{CorreoUsuario= " + c.CorreoUsuario +", idProductoCompra= "+ c.idProductoCompra+'}';
        assertEquals(expected, c.toString());
    }
}
