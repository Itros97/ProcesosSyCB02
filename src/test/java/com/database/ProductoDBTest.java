package com.database;

import java.io.FileInputStream;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

public class ProductoDBTest extends DBTestCase {
	
    public ProductoDBTest() {
        
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/EStoreDB");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
    }

	@Override
	protected IDataSet getDataSet() throws Exception {
		  return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/usuarios.xml"));
	}
	
	@Test
	public void insertarUsuarios() 
	{
		
	}
	@Test
	public void eliminarUsuario() 
	{
		
	}
	@Test
	public void LoginUsuario() 
	{
		
	}
	@Test
	public void getUsuario() 
	{
		
	}
	@Test
	public void getAllUsers() 
	{
		
	}
}
