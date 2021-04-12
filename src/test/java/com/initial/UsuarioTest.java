package com.initial;

import com.jdo.Usuario;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UsuarioTest {

    @Test
    public void testNombre(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals("Mikel", u.getNombre());
    }

    @Test
    public void testNickname(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals("Mik", u.getNickname());
    }

    @Test
    public void testPassword(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals("1234", u.getPassword());
    }

    @Test
    public void testAppelido1(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals("De", u.getApellido1());
    }

    @Test
    public void testAppelido2(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals("La", u.getApellido2());
    }

    @Test
    public void testCorreo(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals("mikel.gmail.com", u.getCorreo());
    }

    @Test
    public void testDireccion(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals("Bilbao", u.getDireccion());
    }

    @Test
    public void testTarjetaCredito(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals(123, u.getTarjetaCredito());
    }

    @Test
    public void testIsAdmin(){
        Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
        assertEquals(false, u.isAdmin());
    }
}
