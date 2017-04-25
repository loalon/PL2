package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorGR extends Translator{
	
	StringBuilder temporal=new StringBuilder();

	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		//GR
		//BP /etiqueta1, si S=0 (resultado positivo)salta a la instruccion etiqueta 1, la comparacion es TRUE!!!
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
		
		temporal.append("CMP #"+op1.getAddress()+"[.IY], #"+op2.getAddress()+"[.IY]\n"); // GR #-2[.IX], #-4[.IX] //op1>op2
		temporal.append("BP /"+labelF+"\n"); //si es verdad biestable S=0, salta a labelT
		temporal.append("MOVE #0, #"+result.getAddress()+"[.IY]\n"); //sino guarda false en el acumulador
		temporal.append("BR /"+labelF+"\n"); //salto a la etiqueta falsa
		temporal.append("BR /"+labelT+"\n"); //salto a la etiqueta verdadera
		temporal.append(labelT+":"); //etiqueta si verdadero
		//temporal.append("MOVE .A, #-"+result.getAddress()+"[.IX]"); //guarda en el temporal
		temporal.append("MOVE #1, #"+result.getAddress()+"[.IY]\n"); //guarda true en el acumulador 
		temporal.append(labelF+":"+"\n"); //etiqueta si falso
		return temporal.toString();
	}
}
