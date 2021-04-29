package com.server;

import com.database.UsuarioDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("usuarios")
public class Usuario {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<com.cliente.jdo.Usuario> getUsers() {
        ArrayList<com.cliente.jdo.Usuario> users = new ArrayList<>();
        UsuarioDB.getAllUsers(users);
        return users;
    }

}
