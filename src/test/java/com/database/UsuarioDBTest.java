package com.database;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.cliente.jdo.Usuario;
import com.mysql.cj.xdevapi.Result;
import com.server.Main;

public class UsuarioDBTest {

    public UsuarioDBTest() {
        
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/EStoreDB");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
    }

    @Mock
    private Connection con = ConexionDB.Conexion();
    @Mock
    private Usuario u1 = new Usuario("jose","jose","jose","jose","jose","jose","jose",123,false);
    
	protected IDataSet getDataSet() throws Exception {
		  return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/usuarios.xml"));
	}

	@Test
	public void testinsertarUsuarios() throws Exception
	{
		UsuarioDB.insertarUsuarios(u1);
		
		assertEquals(2,UsuarioDB.rowcount());
	}

	@Test
	public void testeliminarUsuario() 
	{
		UsuarioDB.eliminarUsuario(u1.getCorreo());
		
		assertEquals(1,UsuarioDB.rowcount());
	}	
	
	@Test
	public void testLoginUsuario() 
	{
		assertEquals(false, false);
	}
	
	@Test
	public void testgetUsuario() 
	{
		
	}
	
	@Test
	public void testgetAllUsers() 
	{
		 GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
	//		List<Usuario> users = target.path("usuarios").request(MediaType.APPLICATION_JSON).get(genericType);
	//	assertEquals(1, users.size());
	}
	

}

