package com.database;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ConexionDBTest {
	
	 @InjectMocks private ConexionDB Connectiondb;
	 @Mock private Connection mockConnection;
	 @Mock private Statement mockStatement;
	 
	  @Before
	  public void setUp() {
	    MockitoAnnotations.initMocks(this);
	  }

	@Test
	public void test() 
	{
		assertEquals(0, 0);
	}
}
