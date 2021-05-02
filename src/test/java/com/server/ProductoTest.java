package com.server;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.databene.contiperf.PerfTest;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductoTest {

	private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }
    
    
     // Test to see that the message "Got it!" is sent in the response.

    @Test
    @PerfTest(invocations = 100, threads = 40)
    public void testGetProductos() {
    	GenericType<List<Producto>> genericType = new GenericType<List<Producto>>() {};
    	List<Producto> productos = target.path("producto").request(MediaType.APPLICATION_JSON).get(genericType);
        assertEquals(1, productos.size());
    }

}
