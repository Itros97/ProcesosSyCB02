package com.cliente.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest extends Usuario {
    Usuario u;

    @Before
    public void setUp() throws Exception {
      u = new Usuario("Mikel", "Mik", "1234", "De", "La", "mikel.gmail.com", "Bilbao", 123, false);
    }

    @Test
    public void testGetNickname() {
        assertEquals("Mik",u.getNickname());
    }

    @Test
    public void testSetNickname() {
        u.setNickname("Jose");
        assertEquals("Jose",u.getNickname());
    }

    @Test
    public void testGetPassword() {
        assertEquals("1234",u.getPassword());
    }

    @Test
    public void testSetPassword() {
        u.setPassword("12345");
        assertEquals("12345",u.getPassword());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Mikel",u.getNombre());
    }

    @Test
    public void testSetNombre() {
        u.setNombre("Josea");
        assertEquals("Josea",u.getNombre());
    }

    @Test
    public void testGetApellido1() {
        assertEquals("De",u.getApellido1());
    }

    @Test
    public void testSetApellido1() {
        u.setApellido1("De");
        assertEquals("De",u.getApellido1());
    }

    @Test
    public void testGetApellido2() {
        assertEquals("La",u.getApellido2());
    }

    @Test
    public void testSetApellido2() {
        u.setApellido2("La");
        assertEquals("La",u.getApellido2());
    }

    @Test
    public void testGetCorreo() {
        assertEquals("mikel.gmail.com",u.getCorreo());
    }

    @Test
    public void testSetCorreo() {
        u.setCorreo("josetxo");
        assertEquals("josetxo",u.getCorreo());
    }

    @Test
    public void testGetDireccion() {
        assertEquals("Bilbao",u.getDireccion());

    }

    @Test
    public void testSetDireccion() {
        u.setDireccion("Basurto");
        assertEquals("Basurto",u.getDireccion());
    }

    @Test
    public void testGetTarjetaCredito() {
        assertEquals(123,u.getTarjetaCredito());
    }

    @Test
    public void testSetTarjetaCredito() {
        u.setTarjetaCredito(456);
        assertEquals(456,u.getTarjetaCredito());
    }

    @Test
    public void testIsAdmin() {
        assertEquals(false,u.isAdmin());
    }

    @Test
    public void testSetAdmin() {
        u.setAdmin(true);
        assertEquals(true,u.isAdmin());
    }

    @Test
    public void testToString() {
            String expected ="Usuario{" +
                    "correo='" + u.getCorreo() + '\'' +
                    ", nombre='" + u.getNombre() + '\'' +
                    ", nickname='" + u.getNickname() + '\'' +
                    ", password='" + u.getPassword() + '\'' +
                    ", apellido1='" + u.getApellido1() + '\'' +
                    ", apellido2='" + u.getApellido2() + '\'' +
                    ", direccion='" + u.getDireccion() + '\'' +
                    ", tarjetaCredito=" + u.getTarjetaCredito() +
                    ", isAdmin=" + u.isAdmin() +
                    '}';
            assertEquals(expected, u.toString());
    }
}