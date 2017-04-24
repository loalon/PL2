package compiler.code;

import compiler.intermediate.Label;
import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorBRT extends Translator{
	
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		Temporal result = (Temporal)quadruple.getResult(); //temporal para comprobar si es falso
		Label op1 = (Label)quadruple.getFirstOperand(); // salta si es falso
		
		temporal.append("CMP #-"+result.getAddress()+"[.IX], #1\n"); // CMP #-2[.IX], 1 . compara con 1
		temporal.append("BZ /"+op1+"\n"); //solo si z=1, comparacion verdadera. si z=1 significa que CMP son iguales
		return  temporal.toString();
	}
}

