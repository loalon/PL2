package compiler.syntax.nonTerminal;

//import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Sentencia extends NonTerminal {

	//private ArrayList<String> lista;
	private boolean esReturn = false;
	private TypeIF tipoRetorno=null;

	public Sentencia () {
		super();
			
	}
	public Sentencia (TypeIF tipo) {
		this();
		this.tipoRetorno=tipo;
	}
	public Sentencia (boolean esReturn, TypeIF tipo) {
		this(tipo);
		if (esReturn)
			this.esReturn=true;
	}

	public boolean isReturn (){
		return esReturn;
	}
	public TypeIF getTipoRetorno (){
		return tipoRetorno;
	}
	//public ArrayList<String> get (){
		//return esReturn;
	//}
	//public set ()
	
	//long hascode()
	//boolean equals (Object o)
	// public String toString()
}
