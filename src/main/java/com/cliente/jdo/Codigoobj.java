package com.cliente.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Codigoobj {
	String code;

	public Codigoobj(String code) {
		super();
		this.code = code;
	}

	public String getCodigo() {
		return code;
	}

	public void setCodigo(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Codigo [code=" + code + "]";
	}
	
	
}
