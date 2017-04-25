package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorINL extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		return  (""+quadruple.getResult()+":"+"\n");
	}
}
