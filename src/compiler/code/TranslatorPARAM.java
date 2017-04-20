package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorPARAM extends Translator{
	
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		Temporal result = (Temporal)quadruple.getResult();

		temporal.append("PUSH #-"+result.getAddress()+"[.IX]"); // PUSH #-2[.IX] inserta en la cima de la pila

		return  temporal.toString();
	}
}
