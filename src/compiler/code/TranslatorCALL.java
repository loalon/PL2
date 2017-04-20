package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorCALL extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		return  ("BR /"+ quadruple.getResult().toString());
	}
}
