package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ExpLog extends NonTerminal {

	private TypeIF tipo=null;
	
	public ExpLog () {
		super();
	}
	public ExpLog (TypeIF tipo) {
		this();
		this.tipo=tipo;
	}
	public TypeIF getType(){
		return tipo;
	}
	public void setType(TypeIF tipo){
		this.tipo= tipo;
	}
}
