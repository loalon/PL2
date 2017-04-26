package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorOR extends Translator {

	StringBuilder temporal=new StringBuilder();

	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		LabelFactory lf = new LabelFactory();
		//LabelIF label0 = lf.create();
		LabelIF label1 = lf.create();
		LabelIF labelEnd = lf.create();

		Temporal result = (Temporal)quadruple.getResult();
		Temporal op1 = (Temporal)quadruple.getFirstOperand();
		Temporal op2 = (Temporal)quadruple.getSecondOperand();
		
		//evaluacion perezosa
		//comprobar que el primero es 0, si no lo es (es true) entonces salto a meter un 1 en la casilla de resultado
		temporal.append("CMP #"+op1.getAddress()+"[.IY], #0\n"); // si es = 0
		temporal.append("BNZ /"+label1+"\n"); //si z=0, salta para evaluar como OR  
		//si z=1 hacer el OR
				
		temporal.append("OR #"+op1.getAddress()+"[.IY], #"+op2.getAddress()+"[.IY]\n"); // op1 || op2, guarda resultado en A
		temporal.append("CMP .A, #0\n"); // compara el resultado con 0
		//si z=0, (resultado no 0) salta a label1
		temporal.append("BNZ /"+label1+"\n"); //si z=0, salta para evaluar como OR
		//sino mete un 0 en el resultado y sale
		temporal.append("MOVE #0, #"+result.getAddress()+"[.IY]\n"); //guarda en el temporal 1 por ser verdad
		temporal.append("BR /"+labelEnd+"\n"); //si z=0, salta para evaluar como OR
			
		temporal.append(label1+":"+"\n"); //etiqueta si verdadero
		temporal.append("MOVE #1, #"+result.getAddress()+"[.IY]\n"); //guarda en el temporal 1 por ser verdad
		temporal.append(labelEnd+":"+"\n"); //etiqueta si verdadero
		return temporal.toString();
	}

}
