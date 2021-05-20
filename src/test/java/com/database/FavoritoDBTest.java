package com.database;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.mockito.Mock;

import com.cliente.jdo.Favorito;

public class FavoritoDBTest extends DBTestCase {

	public FavoritoDBTest() {

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/EStoreDB");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
	}
	
	@Mock
	private Connection con = ConexionDB.Conexion();

	@Mock
	Favorito f = new Favorito("nickkname", 1);
	
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/favorito.xml"));
	}
	
	@Test
	public void testInsertarProducto() {

		FavoritoDB.insertarFavorito(f);

		assertEquals(1, ProductoDB.rowcount());
	}

	@Test
	public void testGetAllPFavoritos() {


	}
	
	@Test
	public void testrowcount() {
		int data = ProductoDB.rowcount();

		assertEquals(1, data);
	}
}
