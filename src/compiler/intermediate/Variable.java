package compiler.intermediate;

import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolVariable;
import es.uned.lsi.compiler.intermediate.VariableIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for variables in intermediate code.
 */

public class Variable  implements VariableIF 
{
    private String  name = null;
    private ScopeIF scope = null;
    private TypeIF type = null;
	private SymbolVariable  sv;
	private SymbolParameter sp;
	private boolean isParameter = false;
    private int address=0;
    private int offset=0;
    private boolean isGlobal=false;
    /**
     * Constructor for Variable.
     * @param name The name.
     * @param scope The scope index.
     */
    public Variable (String name, ScopeIF scope)
    {
        super ();
        this.name = name;
        this.scope = scope;
    }
    public Variable (String name, ScopeIF scope, TypeIF type)
    {
        this (name, scope);
        this.type = type;
        
    }
    public Variable(SymbolVariable sv)
    {
    	this(sv.getName(), sv.getScope(), sv.getType());
    	this.address=sv.getAddress();
    	this.sv=sv;
    
    }
    public Variable(SymbolParameter sp)
    {
    	this(sp.getName(), sp.getScope(), sp.getType());
    	this.address=sp.getAddress();
    	this.sp=sp;
    	this.isParameter=true;//quizas no necesario
    
    }

    /**
     * Returns the name.
     * @return Returns the name.
     */
    @Override
    public final String getName ()    {
        return name;
    }

    /**
     * Returns the scope.
     * @return Returns the scope.
     */
    @Override
    public final ScopeIF getScope ()    {
        return scope;
    }


    public final TypeIF getType ()    {
        return type;
    }
    
    /**
     * Returns the address.
     * @return Returns the address.
     */
    @Override
    public final int getAddress () {
        
    	if(isParameter)
    		return sp.getAddress()+offset;
        else
        	return sv.getAddress()+offset;
  
    }
    public void setAddress (int address) {
    	    	
    	if(isParameter)
    		sp.setAddress(address);
        else
        	sv.setAddress(address);
    
    }
    public void setOffset (int offset) {
    	this.offset=offset;
    }

    /**
     * Indicates whether the address is a global address.
     * @return true if the address is a global address.
     */
    @Override
    public final boolean isGlobal ()
    {
        return isGlobal;
    }

    /**
     * Compares this object with another one.
     * @param other the other object.
     * @return true if both objects has the same properties.
     */
    @Override
    public final boolean equals (Object other)
    {
        if (other == null) 
        {
            return false;
        }
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof Variable))
        {
            return false;
        }
        
        final Variable aVariable = (Variable) other;
        return ((scope   == null) ? (aVariable.scope == null) : (aVariable.scope.equals (scope))) && 
               ((name    == null) ? (aVariable.name  == null) : (aVariable.name.equals (name)));
    }

    /**
     * Returns a hash code for the object.
     */
    @Override
    public final int hashCode ()
    {
        return 31 * scope.hashCode() +
                  ((name == null)? 0 : name.hashCode ());
    } 

    /**
     * Return a string representing the object.
     * @return a string representing the object.
     */
    @Override
    public final String toString ()
    {    
        return name;
    }
}
