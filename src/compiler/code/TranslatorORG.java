package compiler.code;

import compiler.intermediate.Label;
import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorORG extends Translator{
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		temporal.append("ORG "+ quadruple.getResult().toString()+"\n");
		temporal.append("MOVE #65000, .IX");
		
		return  temporal.toString();
	}
}
