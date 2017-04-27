package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.Quadruple;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.syntax.nonTerminal.NonTerminalIF;

/**
 * Abstract class for non terminals.
 */
public abstract class NonTerminal implements NonTerminalIF
{
    private List<QuadrupleIF> intermediateCode;
	private LabelIF label;
	private TemporalIF temporal;
	//añadir fila y columna?
	
    /**
     * Constructor for NonTerminal.
     */
    public NonTerminal () {
        super ();
        this.intermediateCode = new ArrayList<QuadrupleIF> ();
        this.intermediateCode.add(new Quadruple("QUITAR")); //para evitar vacio
    }

    public List<QuadrupleIF> getIntermediateCode () {
        return intermediateCode;
    }

    public void setIntermediateCode (List<QuadrupleIF> intermediateCode) {
        this.intermediateCode = intermediateCode;
    }
	/*
    public QuadrupleIF getCode() {
		return code;
	}
	
	public void setCode(QuadrupleIF code) {
		this.code = code;
	}
	*/
    /*
	public LabelIF getLabel() {
		return label;
	}
	public void setLabel(LabelIF label) {
		this.label = label;
	}
	*/
	public TemporalIF getTemporal() {
		return temporal;
	}
	public void setTemporal(TemporalIF temporal) {
		this.temporal = temporal;
	}
}