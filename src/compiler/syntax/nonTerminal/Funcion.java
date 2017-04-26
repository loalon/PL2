package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Funcion extends NonTerminal {

	private TypeIF tipo=null;
	private String nombre;
	private ArrayList<String> parameters;
	
	public Funcion () {
		super();
		this.parameters = new ArrayList<String>();
	}
	public Funcion (String nombre, TypeIF tipo) {
		this();
		this.tipo=tipo;
		this.nombre=nombre;
	}
	public Funcion (String nombre, TypeIF tipo, ArrayList<String> parameters) {
		this(nombre,tipo);
		this.parameters=parameters;
	}
	public String getNombre () {
		return nombre;
	}
	public TypeIF getTipo () {
		return tipo;
	}	
	public ArrayList<String> getParameters () {
		return parameters;
	}	
	public int getParameterNumber(){
		return parameters.size();
	}

}
