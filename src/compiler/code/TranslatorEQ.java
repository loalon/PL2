package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorEQ extends Translator{
	
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		LabelFactory lf = new LabelFactory();
		LabelIF labelF = lf.create();
		LabelIF labelT = lf.create();
		
		Temporal result = (Temporal)quadruple.getResult(); //almacena resultado
		Temporal op1 = (Temporal)quadruple.getFirstOperand();
		Temporal op2 = (Temporal)quadruple.getSecondOperand();
		
		temporal.append("CMP #"+op1.getAddress()+"[.IY], #"+op2.getAddress()+"[.IY]\n"); // op1==op2 si True Z=1
		temporal.append("BZ /"+labelT+"\n"); //si son iguales z=1 y salta a etiqueta verdad
		temporal.append("MOVE #0, #"+result.getAddress()+"[.IY]\n"); //guarda en el temporal 0 por ser falso
		temporal.append("BR /"+labelF+"\n"); //salto a la etiqueta falso
		temporal.append(labelT+":"+"\n"); //etiqueta si verdadero
		temporal.append("MOVE #1, #"+result.getAddress()+"[.IY]\n"); //guarda en el temporal 1 por ser verdad
		temporal.append(labelF+":"+"\n"); //etiqueta si falso		
		return temporal.toString();
	}
}
