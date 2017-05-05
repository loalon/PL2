package compiler.code;

import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;
/**
 * Clase traductora para las operaciones MV
 * Gestion de movimientos de temporales y variables
 */
public class TranslatorMV extends Translator {
	

	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		LabelFactory lf = new LabelFactory();
		LabelIF labelLocal = lf.create();
		LabelIF labelNoLocal = lf.create();
		
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
			int level = to.getScope().getLevel();
			String name = to.getScope().getName();
			if(level==0) //scope global
				temporal.append("MOVE #"+ from.getAddress()+"[.IY], /"+to.getAddress()+"\n"); //se mueve a la direccion global reservada
			else {
				if (name.equals("main"))
					level=0;
				//if(to.isParameter()) {
					//temporal.append("MOVE #"+ from.getAddress()+"[.IY], #"+to.getAddress()+"[.IX] \n");
					//es local o mas lejano??
				//} else {
					//comparar el display0+1 (el sitio donde dice que ambito es el actual)//con el nivel de esta variable
					temporal.append("CMP /"+(DISPLAY0+1)+", #"+level+"\n"); 
					/*
					temporal.append(";dime que niveles primero activo display, luego var\n");//var de origen+offset
					temporal.append("WRINT #222\n");
					temporal.append("WRCHAR #10\n"); 
					temporal.append("WRINT /"+(DISPLAY0+1)+"\n");
					temporal.append("WRCHAR #10\n"); 
					temporal.append("WRINT #"+(level)+"\n");
					temporal.append("WRCHAR #10\n");
					*/
					temporal.append("BZ /"+labelLocal+"\n"); //si son iguales es referencia local 
					//temporal.append(";display. de temp a varp\n");//var de origen+offset
					//temporal.append("WRINT .A\n");
					if(to.isParameter()){ 
						temporal.append("ADD #"+(to.getAddress())+", /"+(DISPLAY0-level)+"\n"); //cojo el valor del array y lo sumo all offset de destino
						temporal.append("MOVE #"+ from.getAddress()+"[.IY], [.A] \n"); //muevo el valor del temporal local hastaa el destino
					
					}	else		{	//original		
					temporal.append("ADD #"+(to.getAddress()+SIZE_RA)+", /"+(DISPLAY0-level)+"\n"); //cojo el valor del array y lo sumo all offset de destino
					temporal.append("MOVE #"+ from.getAddress()+"[.IY], [.A] \n"); //muevo el valor del temporal local hastaa el destino
					}
					//temporal.append("WRINT .A\n");
					temporal.append("BR /"+labelNoLocal+"\n"); //si so iguales es referencia local
					temporal.append(labelLocal+":"+"\n"); //etiqueta si verdadero
					if(to.isParameter()) 
						temporal.append("MOVE #"+ from.getAddress()+"[.IY], #"+to.getAddress()+"[.IX] \n");
					else
						temporal.append("MOVE #"+ from.getAddress()+"[.IY], #"+(to.getAddress()+SIZE_RA)+"[.IX] \n"); //desde el temporal local hasta la var local
					
					temporal.append(labelNoLocal+":"+"\n"); //etiqueta si verdadero
					temporal.append("NOP\n");
				//}
			}
		}
		//caso 3 mover variable a un temporal (para imprimir por ejemplo)
		if(result instanceof Temporal && op1 instanceof Variable) {
			Variable from = (Variable) op1;
			Temporal to = (Temporal) result;
			int level = from.getScope().getLevel();
			String name = from.getScope().getName();
			if(level==0) //scope global
				temporal.append("MOVE /"+ from.getAddress()+", #"+to.getAddress()+"[.IY]");  
			else {
				if (name.equals("main"))
					level=0;
				
			//	if(from.isParameter()) {
					//temporal.append("MOVE #"+ from.getAddress()+"[.IX], #"+to.getAddress()+"[.IY] \n");
					
				//} else {
					temporal.append("CMP /"+(DISPLAY0+1)+", #"+level+"\n"); //compara el nivel de ejecucion y este nivel
					/*
					temporal.append(";dime que niveles primero activo display, luego var\n");//var de origen+offset
					temporal.append("WRINT #333\n");
					temporal.append("WRCHAR #10\n"); 
					temporal.append("WRINT /"+(DISPLAY0+1)+"\n");
					temporal.append("WRCHAR #10\n"); 
					temporal.append("WRINT #"+(level)+"\n");
					temporal.append("WRCHAR #10\n");
					*/
					temporal.append("BZ /"+labelLocal+"\n"); //si son iguales es referencia local
					
					if(from.isParameter()){ 
						temporal.append("ADD #"+(from.getAddress())+", /"+(DISPLAY0-level)+"\n"); //cojo el valor del array y lo sumo all offset de destino
						temporal.append("MOVE [.A], #"+ to.getAddress()+"[.IY]\n");
					}	else		{			
						temporal.append("ADD #"+(from.getAddress()+SIZE_RA)+", /"+(DISPLAY0-level)+"\n");//var de origen+offset 
						temporal.append("MOVE [.A], #"+ to.getAddress()+"[.IY]\n"); //lo referencia do por A hasta el temporal local
					}
					
					
					//temporal.append(";display. de var a temp\n");//var de origen+offset
					//temporal.append("WRINT .A\n");
					//temporal.append("ADD #"+(from.getAddress()+SIZE_RA)+", /"+(DISPLAY0-level)+"\n");//var de origen+offset 
					//temporal.append("MOVE [.A], #"+ to.getAddress()+"[.IY]\n"); //lo referencia do por A hasta el temporal local
					//temporal.append("WRINT .A\n");
					temporal.append("BR /"+labelNoLocal+"\n"); //si so iguales es referencia local
					temporal.append(labelLocal+":"+"\n"); //etiqueta si local
					if(from.isParameter()) 
						temporal.append("MOVE #"+ from.getAddress()+"[.IX], #"+to.getAddress()+"[.IY] \n");
					else
						temporal.append("MOVE #"+ (from.getAddress()+SIZE_RA)+"[.IX], #"+to.getAddress()+"[.IY] \n"); //desde var local a temp local
					temporal.append(labelNoLocal+":"+"\n"); //etiqueta si verdadero
					temporal.append("NOP\n");
			//	}
			}
		}
		// caso 4 copiar una variable en una nueva variable 

		return temporal.toString();
	}
}
