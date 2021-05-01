package com.database;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.sql.Connection;

import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.mockito.Mock;

import com.cliente.jdo.Compra;
import com.cliente.jdo.Usuario;

public class CompraDBTest {

	public CompraDBTest() {

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/EStoreDB");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
	}
	
	@Mock
    private Connection con = ConexionDB.Conexion();
    @Mock
    private Compra c1 = new Compra("maik@gmail.com", 1);
	
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/compras.xml"));
	}

	@Test
	public void testInsertarCompra() {
		CompraDB.insertarCompra(c1);
		assertEquals(1, CompraDB.rowcount());
	}

	@Test
	public void testeliminarCompra() {
		CompraDB.eliminarCompra(c1.getIdCompra());
		assertEquals(1, CompraDB.rowcount());
	}
	
	@Test
	public void testrowcount() {
		
		int data = CompraDB.rowcount();
		
		assertEquals(1, data);
	}

}
