package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Expresion extends NonTerminal {

	private TypeIF tipo=null;
	
	public Expresion() 
	{
		super();
	}
	public Expresion(TypeIF tipo)
	{
		this();
		this.tipo = tipo;
	}
	public TypeIF getType()	{
		return tipo;
	}
	public void setType(TypeIF tipo) {
		this.tipo = tipo;
	}
}
