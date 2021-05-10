package com.miscelaneus;

public class Codigo {
	
	protected final char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	protected final char[] numeros = "0123456789".toCharArray();
	protected Random r;
	String codigo = "";

	public Codigo() 
	{
		r = new Random();
	}
	
	private char getletra() 
	{
		return letras[r.nextInt(letras.length)];
	}
	private char getnumero() 
	{
		return numeros[r.nextInt(numeros.length)];
	}

	public String generarcodigo(int lenght,int size) 
	{
		//Caso base o caso por el que tiene que acabar
		if(size==lenght) 
		{
			return codigo;
		
		}
		//Caso recursivo, el cual se repite hasta que se cumpla la condicion
		else 
		{
			int iterator = (int) (Math.random()*2);
			if(iterator==0) 
			{
				
				codigo += getletra();
				generarcodigo(lenght,size-1);
			}
			else if (iterator==1)
			{
			
				codigo += getnumero();
				generarcodigo(lenght,size-1);
			}
			
		}
		
			return codigo;
			
	}
	
	public String getCodigo() {
		return codigo;
		
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
