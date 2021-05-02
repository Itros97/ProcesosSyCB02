package com.database;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.sql.Connection;


import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.mockito.Mock;

import com.cliente.jdo.Producto;


public class ProductoDBTest extends DBTestCase {


	public ProductoDBTest() {

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/EStoreDB");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
	}

	@Mock
	private Connection con = ConexionDB.Conexion();

	@Mock
	Producto p = new Producto("nombre", "marca", 5.5f, "descripcion");

	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/productos.xml"));
	}

	@Test
	public void testInsertarProducto() {

		ProductoDB.insertarProducto(p);

		assertEquals(2, ProductoDB.rowcount());
	}

	@Test
	public void testeliminarProducto() {

		ProductoDB.eliminarProducto(p.getNombre());

		assertEquals(1, ProductoDB.rowcount());
	}

	@Test
	public void testSeleccionarProducto() {

		ProductoDB.seleccionarProducto(p.getNombre());

		assertEquals(1, ProductoDB.rowcount());
	}

	@Test
	public void testgetAllProducts() {


	}

	@Test
	public void testrowcount() {
		int data = ProductoDB.rowcount();

		assertEquals(1, data);
	}

}
