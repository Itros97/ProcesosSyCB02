package com.database;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

public class UsuarioDBTest {
    /*
    public UsuarioDBTest() {
   
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/EStoreDB");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
    }
	protected IDataSet getDataSet() throws Exception {
		  return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/usuarios.xml"));
	}

	@Test
	public void testinsertarUsuarios() 
	{
		assertEquals(false, false);
	}

	@Test
	public void testeliminarUsuario() 
	{
		assertEquals(false, false);
	}	
	
	@Test
	public void testLoginUsuario() 
	{
		assertEquals(false, false);
	}
	
	@Test
	public void testgetUsuario() 
	{
		assertEquals(false, false);
	}
	
	@Test
	public void testgetAllUsers() 
	{
		assertEquals(false, false);
	
}
	*/
}
