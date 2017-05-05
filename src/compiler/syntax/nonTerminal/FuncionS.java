package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class FuncionS extends NonTerminal {
	//private ArrayList<Tipo> listaTipo;
	//private ArrayList<VariableA> listaVariables;
	//private ArrayList<Sentencia> listaSentencias;

	private ArrayList<String> parameters;
	private TypeIF returnType;
	boolean hasReturn=false;
	
	public FuncionS () {
		super();
		parameters=new ArrayList<String>();
	}
	public FuncionS (TypeIF returnType) {
		this();
		this.returnType=returnType;
	}
	public FuncionS (ArrayList<String> parameters, TypeIF returnType) {
		this(returnType);
		this.parameters=parameters;
	}
	
	public TypeIF getReturnType(){
		return returnType;
	}
	public boolean hasReturn(){
		return hasReturn;
	}
	public void setHasReturn(){
		this.hasReturn=true;
	}
	public ArrayList<String> getParameters() {
		return parameters;
	}
	public int getParameterNumber(){
		return parameters.size();
	}

}