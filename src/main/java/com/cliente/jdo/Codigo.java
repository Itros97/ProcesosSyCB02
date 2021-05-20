package com.cliente.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Codigo {
	int code;

	public Codigo(int code) {
		super();
		this.code = code;
	}

	public int getCodigo() {
		return code;
	}

	public void setCodigo(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Codigo [code=" + code + "]";
	}
	
	
}
