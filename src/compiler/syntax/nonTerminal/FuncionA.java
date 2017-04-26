package compiler.syntax.nonTerminal;



import es.uned.lsi.compiler.semantic.type.TypeIF;

public class FuncionA extends NonTerminal{

	//private ArrayList<String> listaParametros;
	TypeIF returnType;
	boolean hasReturn=false;

	public FuncionA (TypeIF returnType) {
		super();
		this.returnType= returnType;
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
	/*
	public FuncionA (ArrayList<String> listaParametros) {
		this();
		this.listaParametros=listaParametros;
	}
	
	public ArrayList<String> getParametros() {
		return listaParametros;
	}
	*/
}