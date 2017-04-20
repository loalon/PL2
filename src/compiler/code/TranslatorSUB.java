package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorSUB extends Translator {
	
	StringBuilder temporal=new StringBuilder();

	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		//son todo temps
		Temporal result = (Temporal)quadruple.getResult();
		Temporal op1 = (Temporal)quadruple.getFirstOperand();
		Temporal op2 = (Temporal)quadruple.getSecondOperand();
		
		temporal.append("SUB #-"+op1.getAddress()+"[.IX], #-"+op2.getAddress()+"[.IX]\n"); // SUB #-2[.IX], #-4[.IX]
		temporal.append("MOVE .A, #-"+result.getAddress()+"[.IX]"); //MOVE .A, #-5[.IX]

		return temporal.toString();
	}

}
