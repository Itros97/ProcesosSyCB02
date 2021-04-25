package com.cliente.jdo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CarritoTest {

    Carrito c = new Carrito(1, "CarritoPrueba", "Carrito", 25.5);

    @Test
    public void testIdCarrito(){
        assertEquals(1, c.getIdCarrito());
    }

    @Test
    public void testGetNickname(){
        assertEquals("CarritoPrueba", c.getNickname());
    }

    @Test
    public void testSetNickname(){
        c.setNickname("CarritoPrueba2");
        assertEquals("CarritoPrueba2", c.getNickname());
    }

    @Test
    public void testGetNombre(){
        assertEquals("Carrito", c.getNombre());
    }

    @Test
    public void testSetNombre(){
        c.setNombre("Carrito2");
        assertEquals("Carrito2", c.getNombre());
    }

    @Test
    public void testGetPrecio(){
        assertEquals(25.5, 25.5, c.getPrecioCarrito());
    }

    @Test
    public void testSetPrecio(){
        c.setPrecioCarrito(40.0);
        assertEquals(40.0, 40.0, c.getPrecioCarrito());
    }

    @Test
    public void testToString() {
        String expected = "Carrito{idCarrito= " + c.idCarrito +", nickname= "+ c.nickname + ", nombre= "+ c.nombre + ", precioCarrito= "+ c.precioCarrito + '}';
        assertEquals(expected, c.toString());
    }

}
