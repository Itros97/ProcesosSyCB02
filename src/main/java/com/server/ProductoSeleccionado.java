package com.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cliente.ui.MainVShop;
import com.database.ProductoDB;
/**
 * Resource (exposed at "productoSeleccionado" path)
 */
@Path("productoSeleccionado")
public class ProductoSeleccionado {

	/**
	 * This method returns a list of all the products with the same name
	 * @return
	 */
	@GET
	@Path("/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<com.cliente.jdo.Producto> getProductos(@PathParam("nombre") String nombre) {
		ArrayList<com.cliente.jdo.Producto> productos = new ArrayList<>();
		ProductoDB.busquedaNombre(productos, nombre);
		return productos;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProducto(Producto producto) {
		System.out.println("Received new product: " + producto);
	}

}
