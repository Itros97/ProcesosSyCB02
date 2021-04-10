package com.initial;

import com.jdo.Producto;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestProducto {

    @Test
    public void testIdProducto(){
        Producto p = new Producto(145, "Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals(145, p.getIdProducto());
    }

    @Test
    public void testNombre(){
        Producto p = new Producto(145, "Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals("Chocolate", p.getNombre());
    }

    @Test
    public void testMarca(){
        Producto p = new Producto(145, "Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals("Nestle", p.getMarca());
    }

    @Test
    public void testPrecio(){
        Producto p = new Producto(145, "Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals(1.5f, 1.5f, p.getPrecio());
    }

    @Test
    public void testDescripcion(){
        Producto p = new Producto(145, "Chocolate", "Nestle", 1.5f, "Chocolate blanco");
        assertEquals("Chocolate blanco", p.getDescripcion());
    }
}
