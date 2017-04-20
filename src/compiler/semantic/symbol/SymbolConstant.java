package compiler.semantic.symbol;
// MODIFICADO
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolConstant.
 */

// TODO: Student work
//       Include properties to characterize constants

public class SymbolConstant extends SymbolBase
{
	private int valor; //añadir parametro para almacenar el valor
	//private ScopeIF scope;
	//private TypeIF type;
	//private String name;
    /**
     * Constructor for SymbolConstant.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolConstant (ScopeIF scope, String name, TypeIF type, int valor)
    {
        super (scope, name, type);
		this.valor = valor;
	}
	
	public int getValue() {
		return valor;
	}
	public void setValue(int valor)	{
		this.valor = valor;
	}
    
}
