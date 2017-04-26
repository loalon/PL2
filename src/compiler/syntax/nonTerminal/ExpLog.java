package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ExpLog extends NonTerminal {

	private TypeIF tipo=null;
	//private boolean isBool=false;
	
	public ExpLog () {
		super();
	}
	public ExpLog (TypeIF tipo) {
		this();
		this.tipo=tipo;
	}
	/*
	public ExpLog(TypeIF tipo, boolean isBool)
	{
		this(tipo);
		this.isBool = isBool;
	}
	*/
	public TypeIF getType(){
		return tipo;
	}
	/*
	public void setType(TypeIF tipo){
		this.tipo= tipo;
	}
	*/
	/*
	public boolean isBool() {
		return isBool;
	}
	*/
}
