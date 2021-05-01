package com.database;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.sql.Connection;

import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.mockito.Mock;

import com.cliente.jdo.Carrito;
import com.cliente.jdo.Usuario;

public class CarritoDBTest {

	public CarritoDBTest() {

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/EStoreDB");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
	}

	@Mock
	private Connection con = ConexionDB.Conexion();
	@Mock
	private Carrito c = new Carrito(1, "nickname", "nombre", 5.5);

	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/carrito.xml"));
	}

	@Test
	public void testInsertarCarrito() {

		CarritoDB.insertarCarrito(c);

		assertEquals(0, CarritoDB.rowcount());
	}

	@Test
	public void testDeleteCarrito() {

		CarritoDB.deleteCarrito(c.getIdCarrito());

		assertEquals(0, CarritoDB.rowcount());
	}

	@Test
	public void testrowcount() {

		int data = CarritoDB.rowcount();

		assertEquals(0, data);
	}

}
