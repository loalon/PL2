package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorOR extends Translator {

	StringBuilder temporal=new StringBuilder();

	@Override
	protected String translate(QuadrupleIF quadruple) {

		Temporal result = (Temporal)quadruple.getResult();
		Temporal op1 = (Temporal)quadruple.getFirstOperand();
		Temporal op2 = (Temporal)quadruple.getSecondOperand();
		
		temporal.append("OR #"+op1.getAddress()+"[.IY], #"+op2.getAddress()+"[.IY]\n"); // op1 || op2, guarda resultado en A
		System.out.println("primera direccion Y: "+op1.getAddress()+"\n");
		System.out.println("segunda direccion Y: "+op2.getAddress()+"\n");
		temporal.append("MOVE .A, #"+result.getAddress()+"[.IY]"+"\n"); //lleva el resultado al temporal resultado
		System.out.println("resultado direccion Y: "+result.getAddress()+"\n");
		return temporal.toString();
	}

}
