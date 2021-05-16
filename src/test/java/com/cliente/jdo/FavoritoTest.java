package com.cliente.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FavoritoTest extends Favorito {

	Favorito f;

    @Before
    public void setUp() throws Exception {
      f = new Favorito("test", 1);
    }

    @Test
    public void testGetNickname() {
        assertEquals("test", f.getNickname());
    }
    
    @Test
    public void testIdProducto() {
        assertEquals(1, f.getIdProducto());
    }
    
    @Test
    public void testToString() {
    	String expected = "Favorito {nickname=" + f.nickname +", idProducto="+ f.idProducto + '}';
        assertEquals(expected, f.toString());
    }
}
