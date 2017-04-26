package compiler.syntax.nonTerminal;

import compiler.semantic.type.TypeSimpleVoid;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class FuncionD extends NonTerminal{

	TypeIF returnType;
	boolean hasReturn=false;

	public FuncionD (ScopeIF scope) {
		super();
		returnType= new TypeSimpleVoid(scope); // por defecto es tipo void
	}
	
	public TypeIF getReturnType(){
		return returnType;
	}
	public void setReturnType(TypeIF returnType){
		this.returnType=returnType;
		this.hasReturn=true;
	}
	public boolean hasReturn(){
		return hasReturn;
	}
}
