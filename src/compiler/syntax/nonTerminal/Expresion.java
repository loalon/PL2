package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Expresion extends NonTerminal {

	private TypeIF type=null;
	
	public Expresion() {
		super();
	}
	public Expresion(TypeIF type){
		this();
		this.type = type;
	}
	public TypeIF getType()	{
		return type;
	}

}
