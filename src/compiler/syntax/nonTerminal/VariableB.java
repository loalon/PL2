package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class VariableB extends NonTerminal {

	private TypeIF tipo=null; //tipo de la lista de variables
	private ArrayList<String> lista;
	
	public VariableB (String nombre) {
		super();
		this.lista=new ArrayList<String>();
		this.lista.add(nombre);
	}
	
	public VariableB (String nombre, TypeIF tipo) {
		super();
		this.tipo=tipo;
		this.lista=new ArrayList<String>();
		this.lista.add(nombre);
	}
	public TypeIF getType(){
		return tipo;
	}
	public void setType(TypeIF tipo){
		this.tipo=tipo;
	}
		
	public ArrayList<String> getVariables(){
		return lista;
	}
	public void addVariable(String var){
		this.lista.add(var);
	}
	
	//public get ()
	//public set ()
	
	//long hascode()
	//boolean equals (Object o)
	// public String toString()
}
