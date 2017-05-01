package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Sentencia extends NonTerminal {

	//private ArrayList<String> lista;
	private boolean isReturn = false;
	private TypeIF returnType=null;

	public Sentencia () {
		super();
			
	}
	public Sentencia (TypeIF tipo) {
		this();
		this.returnType=tipo;
	}
	public Sentencia (boolean esReturn, TypeIF tipo) {
		this(tipo);
		if (esReturn)
			this.isReturn=true;
	}

	public boolean isReturn (){
		return isReturn;
	}
	public TypeIF getTipoRetorno (){
		return returnType;
	}

}
