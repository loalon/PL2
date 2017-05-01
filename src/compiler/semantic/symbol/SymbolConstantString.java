package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolConstant.
 */

public class SymbolConstantString extends SymbolBase
{
	private String value; 
    /**
     * Constructor for SymbolConstant.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolConstantString (ScopeIF scope, String name, TypeIF type, String value)
    {
        super (scope, name, type);
		String cad2=value.replace("\"", ""); //quitar comillas del lexema
		cad2 += "\0"; //para que WRSTR detecte el fin necesita retorno de carro
		this.value=cad2;
		System.out.println(value);
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value)	{
		this.value = value;
	}
	public int getSize() {
		return value.length();
	}
    
}
