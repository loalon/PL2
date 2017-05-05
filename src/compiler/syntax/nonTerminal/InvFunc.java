package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class InvFunc extends NonTerminal {

	private TypeIF tipo=null;
	private String nombre;
	private int numeroParametros;
	
	public InvFunc () {
		super();
	}
	
	public InvFunc (String nombre, TypeIF tipo, int parametros) {
		this();
		this.tipo=tipo;
		this.nombre=nombre;
		this.numeroParametros=parametros;
	}
	
	public String getName () {
		return nombre;
	}
	/*
	public TypeIF getTipo () {
		return tipo;
	}*/	
	public int getNumberOfParameters(){
		return numeroParametros;
	}
	//public set ()
	
	//long hascode()
	//boolean equals (Object o)
	// public String toString()
}
