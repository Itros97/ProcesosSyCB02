package com.server;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.UsuarioDB;

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
