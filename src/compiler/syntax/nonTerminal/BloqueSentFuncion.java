package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class BloqueSentFuncion extends BloqueSent {

	private ArrayList<String> listaParametros;
	
	public BloqueSentFuncion (ArrayList<Tipo> listaTipo, ArrayList<VariableA> listaVariables, 
            ArrayList<Sentencia> listaSentencias) {
		super(listaTipo, listaVariables, listaSentencias);
		
	}
	
	public BloqueSentFuncion (ArrayList<Tipo> listaTipo, ArrayList<VariableA> listaVariables, 
			                  ArrayList<Sentencia> listaSentencias, ArrayList<String> listaParametros) {
		this(listaTipo, listaVariables, listaSentencias);
		this.listaParametros=listaParametros;
	}
	
	public ArrayList<String> getParametros() {
		return listaParametros;
	}
}
