package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolProcedure.
 */

public class SymbolProcedure extends SymbolBase
{
	private int numberOfParameters=0;
    /**
     * Constructor for SymbolProcedure.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolProcedure (ScopeIF scope, String name, TypeIF type)
    {
        super (scope, name, type);

    } 	
    public SymbolProcedure (ScopeIF scope, String name, TypeIF type, int numberOfParameters)
    {
        this (scope, name, type);
        this.numberOfParameters=numberOfParameters;
    } 
	public int getNumberOfParameters(){
		return numberOfParameters;
	}
	public void setNumberOfParameters(int numberOfParameters){
		this.numberOfParameters = numberOfParameters;
	}

}
