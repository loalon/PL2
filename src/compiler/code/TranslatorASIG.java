package compiler.code;

import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase traductora para las operaciones ASIG
 * Asignacion a una variable
 */

public class TranslatorASIG extends Translator {
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		LabelFactory lf = new LabelFactory();
		LabelIF labelLocal = lf.create();
		LabelIF labelNoLocal = lf.create();
		
		OperandIF result = quadruple.getResult();
		Variable var = (Variable) result;
		int level = var.getScope().getLevel();
		/*
		OperandIF op1 = quadruple.getFirstOperand();
		Value val = (Value) op1;
		int thisLevel=(int) val.getValue();*/
		
		//if (var.isParameter())
			//semanticErrorManager.semanticFatalError("No coinciden los tipos en la asignación."+" Linea: ");
		
		if(var.getScope().getLevel()==0){ //scope global
			temporal.append("MOVE #1[.IX], /"+var.getAddress()+"\n"); //se mueve a la direccion global reservada
		} else {
			//WIP quizas meter aqui guardar en glocal
			//temporal.append("MOVE #1[.IX], #"+(var.getAddress()+SIZE_RA)+"[.IX] \n"); //Original
			//if(thisLevel==)
			System.out.println("Traduzco ASIG en nivel: " +level);
			temporal.append("CMP /"+(DISPLAY0+1)+", #"+level+"\n"); 
			temporal.append("BZ /"+labelLocal+"\n"); //si son iguales es referencia local 

			temporal.append("ADD #"+(var.getAddress()+SIZE_RA)+", /"+(DISPLAY0-level)+"\n"); //cojo el valor del array y lo sumo all offset de destino
			temporal.append("MOVE #1[.IX], [.A] \n"); //muevo el valor del resultado local hasta el destino no local, no global
			//temporal.append("WRINT [.A]\n");
			//temporal.append("WRCHAR #10\n"); 
			temporal.append("BR /"+labelNoLocal+"\n"); 
			temporal.append(labelLocal+":"+"\n"); //etiqueta si local
			temporal.append("MOVE #1[.IX], #"+(var.getAddress()+SIZE_RA)+"[.IX] \n"); //OK, lo mueve a la variable que corresponde
			//temporal.append("WRINT /"+(DISPLAY0+1)+"\n");
			//temporal.append("WRCHAR #10\n"); 
			temporal.append(labelNoLocal+":"+"\n"); //etiqueta si no local
			temporal.append("NOP\n");
			
		}
		return temporal.toString();
	}
}
