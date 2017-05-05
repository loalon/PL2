package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import es.uned.lsi.compiler.intermediate.Quadruple;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.syntax.nonTerminal.NonTerminalIF;

/**
 * Abstract class for non terminals.
 * 
 * Modificada para incluir nuevos metodos, 
 * Las modificaciones se comentan con la palabra new!
 */
public abstract class NonTerminal implements NonTerminalIF
{
    private List<QuadrupleIF> intermediateCode;
	private TemporalIF temporal; //new!
	
    /**
     * Constructor for NonTerminal.
     */
    public NonTerminal () {
        super ();
        this.intermediateCode = new ArrayList<QuadrupleIF> ();
        this.intermediateCode.add(new Quadruple("NADA")); //new! añade linea de CI para evitar vacio
    }

    public List<QuadrupleIF> getIntermediateCode () {
        return intermediateCode;
    }
    public void setIntermediateCode (List<QuadrupleIF> intermediateCode) {
        this.intermediateCode = intermediateCode;
    }
    /** new!
     * Devuelve el temporal correspondiente a este no terminal
     */
	public TemporalIF getTemporal() {
		return temporal;
	}
	
	/** new!
     * Establece el temporal correspondiente a este no terminal
     */
	public void setTemporal(TemporalIF temporal) {
		this.temporal = temporal;
	}
}