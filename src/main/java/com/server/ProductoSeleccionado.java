package com.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.ProductoDB;

@Path("productoSeleccionado")
public class ProductoSeleccionado {

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<com.cliente.jdo.Producto> getProductos() {
	        ArrayList<com.cliente.jdo.Producto> productos = new ArrayList<>();
	        ProductoDB.getAllProducts(productos);

	        return productos;
	    }

	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public void addProducto(Producto producto) {
	        System.out.println("Received new product: " + producto);
	    }

}
