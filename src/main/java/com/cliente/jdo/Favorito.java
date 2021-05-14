package com.cliente.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Favorito {
	
	@PrimaryKey
	protected String nickname;
	@PrimaryKey
	protected int idProducto;
	
	public Favorito(String nickname, int idProducto) {
		this.nickname = nickname;
		this.idProducto = idProducto;
	}
	
	public Favorito() {
		this.nickname = "";
		this.idProducto = 0;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	@Override
	public String toString() {
		return "Favorito {nickname=" + nickname + ", idProducto=" + idProducto + "}";
	}

}
