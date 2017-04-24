package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorSTART extends Translator{
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		temporal.append("MOVE #65000, .IY\n"); //relativo a monton
		temporal.append("ADD .PC, #4\n"); //relativo a pila y dos mas
		temporal.append("MOVE .A, .IX\n"); //relativo a pila y dos mas
		//temporal.append("BR /L_MAIN");
		
		return  temporal.toString();
	}
}
