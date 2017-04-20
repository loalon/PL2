package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolVariable.
 */

// TODO: Student work
//       Include properties to characterize parameters

public class SymbolParameter extends SymbolBase
{  
	//private ScopeIF scope;
	//private TypeIF type;
	//private String name;
	private Integer address;
    /**
     * Constructor for SymbolParameter.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolParameter (ScopeIF scope, String name, TypeIF type)
    {
        super (scope, name, type);
    } 
    public Integer getAddress() 
	{
		return address;
	}

	public void setAddress(Integer address) 
	{
		this.address = address;
	} 
}
