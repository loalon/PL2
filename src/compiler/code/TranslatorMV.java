package compiler.code;

import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMV extends Translator {
	
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		OperandIF result = quadruple.getResult();
		OperandIF op1 = quadruple.getFirstOperand();
		//OperandIF op2= quadruple.getSecondOperand(); //guarda desplazamiento relativo
		
		//caso 1 mover constante, result sera un temp y op1 un valor
		//MV temporal cnte
		if(result instanceof Temporal && op1 instanceof Value) {
			Value from = (Value) op1;
			Temporal to = (Temporal) result;
			temporal.append("MOVE #"+ from.getValue() +", #-"+to.getAddress()+"[.IY]");  
		}
	
		//caso 2 mover temporal a una variable
		if(result instanceof Variable && op1 instanceof Temporal) {
			Temporal from = (Temporal) op1;
			Variable to = (Variable) result;
			
			temporal.append("MOVE #-"+ from.getAddress()+"[.IY], /"+to.getAddress());  
		}
		//caso 3 mover variable a un temporal (para imprimir por ejemplo)
		if(result instanceof Temporal && op1 instanceof Variable) {
			Variable from = (Variable) op1;
			Temporal to = (Temporal) result;
			temporal.append("MOVE /"+ from.getAddress()+", #-"+to.getAddress()+"[.IY]");  
		}
		// caso 4 copiar una variable en una nueva variable 

		return temporal.toString();
	}
}
