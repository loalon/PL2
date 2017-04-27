package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class VariableA extends NonTerminal {

	private TypeIF tipo=null; //tipo de la lista de variables
	private ArrayList<String> lista;
	
	public VariableA () {
		super();
		this.lista=new ArrayList<String>();
	}
	public VariableA (TypeIF tipo) { //si solo un elemento
		this();
		this.tipo=tipo;
	}
	public VariableA (String nombre) { //si solo un elemento
		this();
		this.lista.add(nombre);
	}
	
	public VariableA (String nombre, TypeIF tipo) {
		this();
		this.tipo=tipo;
		this.lista.add(nombre);
	}
	public VariableA (ArrayList<String> lista, TypeIF tipo) {
		this();
		this.tipo=tipo;
		this.lista=lista;
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
}
