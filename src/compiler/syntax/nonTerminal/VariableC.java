package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class VariableC extends NonTerminal {

	private TypeIF tipo=null;
	private String valor;
	
	public VariableC (String valor, TypeIF tipo) {
		super();
		this.tipo=tipo;
		this.valor=valor;
	}
	public TypeIF getType(){
		return tipo;
	}
	public String getValue(){
		return valor;
	}
	//public get ()
	//public set ()
	
	//long hascode()
	//boolean equals (Object o)
	// public String toString()
}
