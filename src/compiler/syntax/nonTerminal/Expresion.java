package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Expresion extends NonTerminal {

	private TypeIF tipo=null;
	//private boolean isBool=false;
	
	public Expresion() 
	{
		super();
	}
	public Expresion(TypeIF tipo)
	{
		this();
		this.tipo = tipo;
	}
	/*
	public Expresion(TypeIF tipo, boolean isBool)
	{
		this(tipo);
		this.isBool = isBool;
	}
	*/
	public TypeIF getType()	{
		return tipo;
	}
	/*
	public void setType(TypeIF tipo) {
		this.tipo = tipo;
	}
	*/
	/*
	public boolean isBool() {
		return isBool;
	}
	*/
}
