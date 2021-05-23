package com.miscelaneus;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import com.cliente.jdo.Producto;

public class CodigosTest {

	 private String data;
	 
	 
	@Test
	public void testGenerarCodigo() {
		data = Codigo.generarcodigo(1, 1);
		assertEquals(data, "");
	}
	
	@Test
	public void testgetCodigo() {
		Codigo c1 = new Codigo("");
		System.out.println(c1.getCodigo());
		assertEquals("", c1.getCodigo());
	}
	
	@Test
	public void testsetCodigo() {
		Codigo c2 = new Codigo("");
		c2.setCodigo("");
		assertEquals("", c2.getCodigo());
	}
	

}
