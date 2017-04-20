package compiler.code;

import compiler.intermediate.Value;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorTEXT extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		Value name = (Value) quadruple.getResult();
		Value cadena = (Value) quadruple.getFirstOperand();
		System.out.println(""+name.getValue()+": DATA \""+cadena.getValue()+"\"");
		return ""+name.getValue()+": DATA \""+cadena.getValue()+"\"";
	}
}