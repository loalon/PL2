package compiler.code;

import compiler.intermediate.Value;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase traductora para las operaciones TEXT
 * Gestiona los strings al comienzo del ensamblador
 */

public class TranslatorTEXT extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		Value name = (Value) quadruple.getResult();
		Value cadena = (Value) quadruple.getFirstOperand();
		//System.out.println(""+name.getValue()+": DATA \""+cadena.getValue()+"\"");
		return ""+name.getValue()+": DATA \""+cadena.getValue()+"\"";
	}
}