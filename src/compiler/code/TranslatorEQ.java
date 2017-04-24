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
		
		temporal.append("CMP #-"+op1.getAddress()+"[.IY], #-"+op2.getAddress()+"[.IY]\n"); // CMP #-2[.IX], #-4[.IX]
		temporal.append("BZ /"+labelT+"\n"); //si son iguales z=1 y salta
		//temporal.append("BR /"+labelT+"\n"); //salto a la etiqueta verdadera
		temporal.append("MOVE #0, #-"+result.getAddress()+"[.IY]\n"); //guarda en el temporal 0 por ser falso
		temporal.append("BR /"+labelF+"\n"); //salto a la etiqueta falso
		//temporal.append("MOVE #0, .A"+"\n"); //guarda false en el acumulador
		temporal.append(labelT+":"+"\n"); //etiqueta si verdadero
		temporal.append("MOVE #1, #-"+result.getAddress()+"[.IY]\n"); //guarda en el temporal 1 por ser verdad
		//temporal.append("MOVE #1, .A"+"\n"); //guarda true en el acumulador
		//temporal.append("MOVE .A, #-"+result.getAddress()+"[.IX]"); //guarda en el temporal
		temporal.append(labelF+":"+"\n"); //etiqueta si falso		
		return temporal.toString();
	}
}
