package compiler.semantic.symbol;
// MODIFICADO
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolConstant.
 */


public class SymbolConstant extends SymbolBase
{
	private int value; // parametro para almacenar el valor

    /**
     * Constructor for SymbolConstant.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolConstant (ScopeIF scope, String name, TypeIF type, int value)
    {
        super (scope, name, type);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value)	{
		this.value = value;
	}
    
}
