package com.cliente.jdo;

import com.cliente.jdo.Producto;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductoTest {

    @Test
    public void testNombre(){
        Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals("Chocolate", p.getNombre());
    }

    @Test
    public void testMarca(){
        Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals("Nestle", p.getMarca());
    }

    @Test
    public void testPrecio(){
        Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals(1.5f, 1.5f, p.getPrecio());
    }

    @Test
    public void testDescripcion(){
        Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals("Chocolate blanco", p.getDescripcion());
    }
}
