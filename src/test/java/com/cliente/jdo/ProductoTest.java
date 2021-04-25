package com.cliente.jdo;

import com.cliente.jdo.Producto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductoTest {
    private Producto p = new Producto("Chocolate", "Nestle", 1.5f, "Chocolate blanco");

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
