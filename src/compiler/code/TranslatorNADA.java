package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorNADA extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		temporal.append("");
		return  temporal.toString();
	}
}
