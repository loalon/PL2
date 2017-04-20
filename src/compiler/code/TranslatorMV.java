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
		
		//caso 1 mover constante, result sera un temp y op1 un valor
		//MV temporal cnte
		if(result instanceof Temporal && op1 instanceof Value) {
			Temporal to = (Temporal) result;
			Value from = (Value) op1;
			temporal.append("MOVE #"+ from.getValue() +", #-"+to.getAddress()+"[.IX]");  
		}
		//caso 2 mover temporal a una variable
		if(result instanceof Variable && op1 instanceof Temporal) {
			Variable to = (Variable) result;
			Temporal from = (Temporal) op1;
			temporal.append("MOVE #-"+ from.getAddress()+"[.IX], #-"+to.getAddress()+"[.IX]");  
		}
		//caso 3 mover variable a un temporal (para imprimir por ejemplo)
		if(result instanceof Temporal && op1 instanceof Variable) {
			Temporal to = (Temporal) result;
			Variable from = (Variable) op1;
			temporal.append("MOVE #-"+ from.getAddress()+"[.IX], #-"+to.getAddress()+"[.IX]");  
		}
		
		
		return temporal.toString();
	}
}
