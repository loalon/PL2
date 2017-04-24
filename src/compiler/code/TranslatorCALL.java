package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorCALL extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
//Registro de activacion		
		
		return  ("BR /"+ quadruple.getResult().toString());
	}
}
