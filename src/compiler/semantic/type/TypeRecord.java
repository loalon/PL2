package compiler.semantic.type;

import java.util.HashMap;
import java.util.Map;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

/**
 * Class for TypeRecord.
 */

public class TypeRecord extends TypeBase
{   
	private Map<String, Integer> offset= new HashMap<String, Integer>();
	private int size=0;
	
       
    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     */
    public TypeRecord (ScopeIF scope)
    {
        super (scope);
    }

    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     * @param name The name of the type.
     */
    public TypeRecord (ScopeIF scope, String name)
    {   
        super (scope, name);
    }
   
    /**
     * Constructor for TypeRecord.
     * @param record The record to copy.
     */
    public TypeRecord (TypeRecord record)
    {
        super (record.getScope (), record.getName ());
    } 
    
    public TypeRecord (ScopeIF scope, String name, int size, Map<String, Integer> map)
    {   
        super (scope, name);
        this.size=size;
        this.offset=map;
    }

    public void addOffsetMap(Map<String, Integer> map){
    	this.offset=map;
    }
    public void setSize(int size){
    	this.size=size;
    }
    public int getOffset(String name){ //para una variable, devuelve su desplazamiento
    	return (int) offset.get(name);
    }
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
        return size;
    }
    

}
