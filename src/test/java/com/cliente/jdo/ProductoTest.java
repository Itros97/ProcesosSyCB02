package com.cliente.jdo;

import com.cliente.jdo.Producto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductoTest {
    private Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");
    Producto p1 = new Producto(1, "Chocolate", "Nestle", 1.5f, "Chocolate blanco");
    Producto vacio = new Producto();

    @Test
    public void testVacio(){
        assertEquals("Producto{nombre='', marca='', precio=0.0, descripcion=''}", "Producto{nombre='', marca='', precio=0.0, descripcion=''}");
    }

    @Test
    public void testGetIdProducto() {
        assertEquals(1, p1.getIdProducto());
    }

    @Test
    public void testSetIdProducto() {
        p1.setIdProducto(2);
        assertEquals(2, p1.getIdProducto());
    }

    @Test
    public void testNombre(){
        assertEquals("Chocolate", p.getNombre());
    }

    @Test
    public void testMarca(){
        assertEquals("Nestle", p.getMarca());
    }

    @Test
    public void testPrecio(){
        assertEquals(1.5f, 1.5f, p.getPrecio());
    }

    @Test
    public void testDescripcion(){
        assertEquals("Chocolate blanco", p.getDescripcion());
    }
    @Test
    public void setnombre(){
        p.setNombre("Chocula");
        assertEquals("Chocula",p.getNombre());
    }
    @Test
    public void setmarca(){
        p.setMarca("Lindt");
        assertEquals("Lindt",p.getMarca());
    }
    @Test
    public void setprecio(){
        p.setPrecio(2.0f);
        assertEquals(2.0f,p.getPrecio(),1);
    }
    @Test
    public void setdescripcion(){
        p.setDescripcion("Descripicion de prueba");
        assertEquals("Descripicion de prueba",p.getDescripcion());
    }
    @Test
    public void testtostring()
    {
        String expected ="Producto{" +
                "nombre='" + p.getNombre() + '\'' +
                ", marca='" + p.getMarca() + '\'' +
                ", precio=" + p.getPrecio() +
                ", descripcion='" + p.getDescripcion() + '\'' +
                '}';

        assertEquals(expected, p.toString());
    }
}
