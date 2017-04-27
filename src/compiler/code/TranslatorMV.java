package compiler.code;

import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMV extends Translator {
	

	
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
			temporal.append("MOVE #"+ from.getValue() +", #"+to.getAddress()+"[.IY]\n");  
			//temporal.append("DEC .R8\n");
			//temporal.append("DEC .R8\n");
		}
	
		//caso 2 mover temporal --> variable
		if(result instanceof Variable && op1 instanceof Temporal) {
			
			Temporal from = (Temporal) op1;
			Variable to = (Variable) result;
			//es global?
			if(to.getScope().getLevel()==0) //scope global
				temporal.append("MOVE #"+ from.getAddress()+"[.IY], /"+to.getAddress()+"\n"); //se mueve a la direccion global reservada
			else {
				if(to.isParameter()) {
					//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
					//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
					//temporal.append("SUB .IX, #"+to.getAddress()+"\n"); //le quito el offset de la var
					//temporal.append("MOVE #"+ from.getAddress()+"[.IY], [.A] \n"); //el temporal se mueve del heap a la direccion referenciada por A
					temporal.append("MOVE #"+ from.getAddress()+"[.IY], #"+to.getAddress()+"[.IX] \n");
				} else {
					temporal.append("MOVE #"+ from.getAddress()+"[.IY], #"+(to.getAddress()+1)+"[.IX] \n");
					//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
					//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
					//temporal.append("ADD .R3, #"+to.getAddress()+"\n"); //a R3 le sumo el offset de la variable
					//temporal.append("MOVE #"+ from.getAddress()+"[.IY], [.A]\n"); //el temporal se mueve del heap a la direccion referenciada por A
				}
			}
			//es local??
			//es glocal?
			
			
		}
		//caso 3 mover variable a un temporal (para imprimir por ejemplo)
		if(result instanceof Temporal && op1 instanceof Variable) {
			Variable from = (Variable) op1;
			Temporal to = (Temporal) result;
			if(from.getScope().getLevel()==0) //scope global
				temporal.append("MOVE /"+ from.getAddress()+", #-"+to.getAddress()+"[.IY]");  
			else {
				if(from.isParameter()) {
					//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
					//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
					//temporal.append("SUB .IX, #"+from.getAddress()+"\n"); //a R3 le sumo el offset de la variable
					//temporal.append("MOVE  [.A], #"+ to.getAddress()+"[.IY] \n"); //el temporal se mueve del heap a la direccion referenciada por A
					temporal.append("MOVE #"+ from.getAddress()+"[.IX], #"+to.getAddress()+"[.IY] \n");
				} else {
					temporal.append("MOVE #"+ (from.getAddress()+1)+"[.IX], #"+to.getAddress()+"[.IY] \n");
					
					//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
					//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
					//temporal.append("ADD .R3, #"+from.getAddress()+"\n"); //a R3 le sumo el offset de la variable
					//temporal.append("MOVE [.A], #"+to.getAddress()+"[.IY]\n"); 
					//temporal.append("DEC .R8\n");	
				}
				
			}
			
			// 
		}
		// caso 4 copiar una variable en una nueva variable 

		return temporal.toString();
	}
}
