package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorEND extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		return ("HALT");
	}
}
