package com.server;

import com.database.ProductoDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("producto")
public class Producto {

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
