package com.cliente.jdo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CarritoTest {

    @Test
    public void testIdCarrito(){
        Carrito c = new Carrito(1, "CarritoPrueba", "Carrito", 25.5);
        assertEquals(1, c.getIdCarrito());
    }

    @Test
    public void testNickname(){
        Carrito c = new Carrito(1, "CarritoPrueba", "Carrito", 25.5);
        assertEquals("CarritoPrueba", c.getNickname());
    }

    @Test
    public void testNombre(){
        Carrito c = new Carrito(1, "CarritoPrueba", "Carrito", 25.5);
        assertEquals("Carrito", c.getNombre());
    }

    @Test
    public void testPrecio(){
        Carrito c = new Carrito(1, "CarritoPrueba", "Carrito", 25.5);
        assertEquals(25.5, 25.5, c.getPrecioCarrito());
    }

}
