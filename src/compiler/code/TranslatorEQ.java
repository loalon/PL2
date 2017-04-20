package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorEQ extends Translator{
	
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		//CMP
		//BZ /etiqueta1, si Z=1 (significa operacion=0)salta a la instruccion etiqueta 1, la comparacion es FALSA!!!
		//si es verdadera no salta
		//ACUMULADOR GUARDA un 1
		//salta a etiqeuta2
		//L_etiqueta1
		//ACUMULADOR guarda un 0
		//l_etiqeuta 2
		
		LabelFactory lf = new LabelFactory();
		LabelIF labelF = lf.create();
		LabelIF labelT = lf.create();
		
		Temporal result = (Temporal)quadruple.getResult(); //almacena resultado
		Temporal op1 = (Temporal)quadruple.getFirstOperand();
		Temporal op2 = (Temporal)quadruple.getSecondOperand();
		
		temporal.append("CMP #-"+op1.getAddress()+"[.IX], #-"+op2.getAddress()+"[.IX]\n"); // CMP #-2[.IX], #-4[.IX]
		temporal.append("BZ /"+labelF+"\n");
		temporal.append("MOVE #1, .A"+"\n"); //guarda true en el acumulador 
		temporal.append("BR /"+labelT+"\n"); //salto a la etiqueta verdadera
		temporal.append(labelF+":"+"\n"); //etiqueta si falso
		temporal.append("MOVE #0, .A"+"\n"); //guarda false en el acumulador
		temporal.append(labelT+":"+"\n"); //etiqueta si verdadero
		temporal.append("MOVE .A, #-"+result.getAddress()+"[.IX]"); //guarda en el temporal
		
		return temporal.toString();
	}
}
