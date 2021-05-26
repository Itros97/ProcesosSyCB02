package com.server;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.UsuarioDB;

/**
 * Resource (exposed at "usuarios" path)
 */
@Path("usuarios")
public class Usuario {

	/**
	 * This method returns a list of all the users
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<com.cliente.jdo.Usuario> getUsers() {
		ArrayList<com.cliente.jdo.Usuario> users = new ArrayList<>();
		UsuarioDB.getAllUsers(users);
		return users;
	}

}
