package com.cliente.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodigoobjTest {

	Codigoobj co = new Codigoobj("Codigo");
	Codigoobj vacio = new Codigoobj(null);

	@Test
	public void testVacio() {
		assertEquals("Codigoobj{code=''}", "Codigoobj{code=''}");
	}

	@Test
	public void testGetCodigo() {
		assertEquals("Codigo", co.getCodigo());
	}

	@Test
	public void testSetCodigo() {
		co.setCodigo("Codigo2");
		assertEquals("Codigo2", co.getCodigo());
	}

	@Test
	public void testToString() {
		String expected = "Codigo [code=" + co.code + "]";
		assertEquals(expected, co.toString());
	}

}
