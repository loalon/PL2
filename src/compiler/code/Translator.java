package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public abstract class Translator {

	protected int SIZE_RA=7;
	StringBuilder temporal=new StringBuilder();
	
	public Translator() {	
		
	}
	protected abstract String translate(QuadrupleIF quadruple);

}
