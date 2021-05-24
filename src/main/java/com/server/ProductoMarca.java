package com.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cliente.ui.MainVShop;
import com.database.ProductoDB;

/**
 * Resource (exposed at "productoMarca" path)
 */
@Path("productoMarca")
public class ProductoMarca {

	/**
	 * This method returns a list of all the products order by marca
	 * @return
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<com.cliente.jdo.Producto> getProductos() {
		ArrayList<com.cliente.jdo.Producto> productos = new ArrayList<>();
		ProductoDB.seleccionarProductoMarca(productos);

		return productos;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProducto(Producto producto) {
		System.out.println("Received new product: " + producto);
	}

}
