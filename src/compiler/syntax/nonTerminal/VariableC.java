package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class VariableC extends NonTerminal {

	private TypeIF tipo=null;
	private String value;
//	private boolean isVarReference=false;
	
	public VariableC () {
		super();
	}
	/*
	public VariableC (int value, TypeIF tipo) {
		this();
		this.value=value;
		this.tipo=tipo;
	}*/
	public VariableC (String value, TypeIF tipo) {
		this();
		this.tipo=tipo;
		this.value=value;
		//isVarReference=true;
	}
	public TypeIF getType(){
		return tipo;
	}
	/*
	public String getName(){
		return name;
	}
	*/
	public String getValue(){
		return value;
	}
	/*
	public boolean isVarReference(){
		return isVarReference;
	}
	*/

}
