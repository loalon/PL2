package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorGR extends Translator{
	
	//StringBuilder temporal=new StringBuilder();

	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		LabelFactory lf = new LabelFactory();
		LabelIF labelF = lf.create();
		LabelIF labelT = lf.create();
		
		Temporal result = (Temporal)quadruple.getResult(); //almacena resultado
		Temporal op1 = (Temporal)quadruple.getFirstOperand();
		Temporal op2 = (Temporal)quadruple.getSecondOperand();
		
		temporal.append("CMP #"+op1.getAddress()+"[.IY], #"+op2.getAddress()+"[.IY]\n"); // operacion op1>op2, si True Z=0 S=0
		temporal.append("BP /"+labelT+"\n"); //si es verdad biestable S=0, salta a labelT
		temporal.append("MOVE #0, #"+result.getAddress()+"[.IY]\n"); //sino guarda False (0) en el temporal
		temporal.append("BR /"+labelF+"\n"); //salto a la etiqueta falsa
		temporal.append(labelT+":"+"\n"); //etiqueta si verdadero
		temporal.append("MOVE #1, #"+result.getAddress()+"[.IY]\n"); //guarda True (1) en el temporal 
		temporal.append(labelF+":"+"\n"); //etiqueta si falso
		return temporal.toString();
	}
}
