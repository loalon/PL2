package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;



public class FuncionS extends NonTerminal {
	private ArrayList<Tipo> listaTipo;
	private ArrayList<VariableA> listaVariables;
	private ArrayList<Sentencia> listaSentencias;
	private FuncionE parametros;
	private boolean tieneParametros = false;
	private TypeIF returnType;
	//private boolean esReturn = false;
	
	public FuncionS () {
		super();
		//listaTipo = new ArrayList<Tipo>();
		//listaVariables = new ArrayList<VariableA>();
		//listaSentencias = new ArrayList<Sentencia>();
		parametros=new FuncionE();
		//listaParametros = new ArrayList<String>();
	}
	public FuncionS (TypeIF returnType) {
		this();
		//this.parametros=parametros;
		//this.tieneParametros=true;
		this.returnType=returnType;
	}
	public FuncionS (FuncionE parametros, TypeIF returnType) {
		this();
		this.parametros=parametros;
		this.tieneParametros=true;
		this.returnType=returnType;
	}

	public TypeIF getReturnType(){
		return returnType;
	}
	/*
	public FuncionS (ArrayList<Tipo> listaTipo, ArrayList<VariableA> listaVariables, ArrayList<Sentencia> listaSentencias) {
		this();
		this.listaTipo=listaTipo;
		this.listaVariables=listaVariables;
		this.listaSentencias=listaSentencias;
	}
	public FuncionS (ArrayList<Tipo> listaTipo, ArrayList<VariableA> listaVariables, ArrayList<Sentencia> listaSentencias, FuncionE parametros) {
		this(listaTipo, listaVariables, listaSentencias);
		this.parametros=parametros;
		this.tieneParametros=true;
	}
	
	public ArrayList<Tipo> getTipos()	{
		return listaTipo;
	}	
	public ArrayList<VariableA> getVariables()	{
		return listaVariables;
	}	
	public ArrayList<Sentencia> getSentencias()	{
		return listaSentencias;
	}
	*/	
	public FuncionE getParametros() {
		return parametros;
	}
	//public TypeIF getTipoRetorno()	{
		//return returnType;
	//}	
	//public void setTipoRetorno(TypeIF returnType){
		//this.returnType=returnType;
//	}
	public boolean tieneParametros (){
		return tieneParametros;
	}
	//public void setReturn (){
		//esReturn=true;
	//}
}