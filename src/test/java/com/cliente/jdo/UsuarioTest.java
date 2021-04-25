package com.cliente.jdo;

import com.cliente.jdo.Usuario;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UsuarioTest {
    Usuario u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
    @Test
    public void testNombre(){

        assertEquals("Mikel", u.getNombre());
    }

    @Test
    public void testNickname(){

        assertEquals("Mik", u.getNickname());
    }

    @Test
    public void testPassword(){

        assertEquals("1234", u.getPassword());
    }

    @Test
    public void testAppelido1(){

        assertEquals("De", u.getApellido1());
    }

    @Test
    public void testAppelido2(){

        assertEquals("La", u.getApellido2());
    }

    @Test
    public void testCorreo(){

        assertEquals("mikel.gmail.com", u.getCorreo());
    }

    @Test
    public void testDireccion(){

        assertEquals("Bilbao", u.getDireccion());
    }

    @Test
    public void testTarjetaCredito(){

        assertEquals(123, u.getTarjetaCredito());
    }

    @Test
    public void testIsAdmin(){
     
        assertEquals(false, u.isAdmin());
    }
}
