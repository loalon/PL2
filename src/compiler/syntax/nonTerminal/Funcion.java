package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Funcion extends NonTerminal {

	private TypeIF type=null;
	private String name;
	private ArrayList<String> parameters;
	
	public Funcion () {
		super();
		this.parameters = new ArrayList<String>();
	}
	public Funcion (String name, TypeIF type) {
		this();
		this.type=type;
		this.name=name;
	}
	public Funcion (String name, TypeIF type, ArrayList<String> parameters) {
		this(name, type);
		this.parameters=parameters;
	}
	public String getNombre () {
		return name;
	}
	public TypeIF getTipo () {
		return type;
	}	
	public ArrayList<String> getParameters () {
		return parameters;
	}	
	public int getParameterNumber(){
		return parameters.size();
	}

}
