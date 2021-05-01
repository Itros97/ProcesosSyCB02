package com.database;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

public class ProductoDBTest {
	
	
	
  	/*public ProductoDBTest() {
       
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/EStoreDB");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
    }

	protected IDataSet getDataSet() throws Exception {
		  return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/productos.xml"));
	}

	@Test
	public void testInsertarProducto() {
		assertEquals(false, false);
	}
	
	@Test
	public void testeliminarProducto() {
		assertEquals(false, false);
	}
	
	@Test
	public void testSeleccionarProducto() {
		assertEquals(false, false);
	}
	
	@Test
	public void testgetAllProducts() {
		assertEquals(false, false);
	}
	*/
}
