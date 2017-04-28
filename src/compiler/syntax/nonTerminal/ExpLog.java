package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ExpLog extends NonTerminal {

	private TypeIF tipo=null;
	private boolean isCall=false;
	
	public ExpLog () {
		super();
	}
	public ExpLog (TypeIF tipo) {
		this();
		this.tipo=tipo;
	}
	
	public ExpLog(TypeIF tipo, boolean isCall)
	{
		this(tipo);
		this.isCall = isCall;
	}
	
	public TypeIF getType(){
		return tipo;
	}
	/*
	public void setIsCall(TypeIF tipo){
		this.tipo= tipo;
	}
	*/

	public boolean isCall() {
		return isCall;
	}

}
