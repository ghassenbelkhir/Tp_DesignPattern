package question3;

import java.io.*;

import question1.*;
import question2.*;

/**
 * 
 */
public class VisiteurInstToJava extends VisiteurInstruction<String> {

	  private final static int TAB = 2;
	    private static final String lineSeparator = System.getProperties().getProperty("line.separator");

	    private VisiteurExpression<String> vi;
	    private VisiteurExpressionBooleenne<String> vb;

	    private int tabulations;

	    /**
	     * Cr�ation d'un visiteur d'instructions
	     * 
	     * @param vi
	     *            le visiteur d'expressions arithm�tiques
	     * @param vb
	     *            le visiteur d'expression bool�ennes
	     * @param tabulations
	     *            tabulations initiales
	     */
	    public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb, int tabulations) {
	        this.vi = vi;
	        this.vb = vb;
	        this.tabulations = tabulations;
	    }

	    /**
	     * Cr�ation d'un visiteur d'instructions
	     * 
	     * @param vi
	     *            le visiteur d'expressions arithm�tiques
	     * @param vb
	     *            le visiteur d'expression bool�ennes
	     */
	    public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb) {
	        this(vi, vb, 0);
	    }

	    /**
	     * obtention du contexte, ici celui du visiteur d'expression arithm�tiques
	     * 
	     * @return le contexte ici de vi(le visiteur d'expression)
	     */
	    public Contexte contexte() {
	        return this.vi.contexte();
	    }

	    /**
	     * Visite d'une instance de la classe Affectation.
	     * 
	     * 
	     * @param a
	     *            une affectation
	     * @return a := exp
	     */
	    public String visite(Affectation a) {
	        return a.v().accepter(this.vi) + "=" + a.exp().accepter(this.vi);
	    }

	    /**
	     * Visiste d'une s�quence seq(I1,I2) <br>
	     * 
	     * @param seq
	     *            une s�quence
	     * @return i1;i2
	     */
	    public String visite(Sequence seq) {
	        String str = tab(0)+seq.i1().accepter(this);
	        if (seq.i1() instanceof Affectation){
	            str+=";";
	        }
	        str += tab(0)+seq.i2().accepter(this);
	        
	        return str;
	    }

	    public String visite(Selection sel) {
	        String str = "if" + sel.cond().accepter(this.vb)+"{"+tab(1)+ sel.i1().accepter(this)+";"+tab(-1)+"}";
	        if (sel.i2() != null) str = str +tab(0)+"else {" + tab(1)+sel.i2().accepter(this)+";"+tab(-1)+"}";
	        
	        return str;
	    }

	    
	    public String visite(TantQue tq) {
	       return tab(0)+"while"+ tq.cond().accepter(this.vb) +"{"+ 
	                            tab(1)+tq.i1().accepter(this)  +";"+tab(-1)
	                    +"}";
	    }

	    public String visite(Pour pour) {
	        String str = tab(0)+"for(" + pour.init().accepter(this) + ";" 
	                                   + pour.cond().accepter(this.vb) + ";"
	                                   + pour.inc().accepter(this) + ") {" +  tab(1) + pour.i1().accepter(this);
	       if (pour.i1() instanceof Affectation){
	            str+=";";
	        }
	        str = str +tab(-1)+"}";   
	       return str;
	    }

	    public String visite(Afficher a) {
	        return "System.out.println(" + a.exp().accepter(this.vi) + ");"; 
	       
	    }

	    public String visite(Assertion a) {
	        return "assert(" + a.cond().accepter(this.vb) + ");"; 
	       
	    }

	    private String tab(int n) {
	        String str = new String();

	        str = str + lineSeparator;
	        for (int i = 0; i < this.tabulations + n; i++) {
	            str = str + " ";
	        }
	        this.tabulations += n;
	        return str;
	    }

}
