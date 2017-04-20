package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

public class TypeString extends TypeBase
{
    private String cadena="";
        
	public TypeString(ScopeIF scope) 
	{
		super(scope, "STRING");		
	}
	public TypeString(ScopeIF scope, String cadena) 
	{
		this(scope);
		String cad2=cadena.replace("\"", ""); //quitar comillas del lexema
		cad2 += "\0"; //para que WRSTR detecte el fin necesita retorno de carro
		this.cadena=cad2;
		System.out.println(cad2);
		
	}
	public String getString() {
		return cadena;
	}
	@Override
	public int getSize() {
		return cadena.length();
	}
	

}
