package com.cliente.jdo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CompraTest {

    @Test
    public void testCorreoUsuario(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");

        Compra c = new Compra(u, p);
        assertEquals("mikel.gmail.com", c.getCorreoUsuario().getCorreo());
    }

    @Test
    public void testIdProductoCompra(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");

        Compra c = new Compra(u, p);
        assertEquals(0, c.getIdProductoCompra().getIdProducto());
    }

    @Test
    public void testToString() {
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");

        Compra c = new Compra(u, p);
        String expected = "Compra{idCompra=" + c.idCompra +", CorreoUsuario=" + c.CorreoUsuario +", idProductoCompra="+ c.idProductoCompra+'}';
        assertEquals(expected, c.toString());
    }

}
