package question2;

import question1.VisiteurExpression;

public class VisiteurBoolToJava extends VisiteurExpressionBooleenne<String> {

	private VisiteurExpression<String> ve;

	public VisiteurBoolToJava(VisiteurExpression<String> ve) {
		this.ve = ve;
	}

	 /**Expression bool�enne vrai.
     *@return un string "true"
     */
    public String visite(Vrai v) {
        return "true";
    }

    /**Expression bool�enne faux.
     *@return un string "false"
     */
    public String visite(Faux f) {
        return "false";
    }

    /**Expression bool�enne Non.
     *@return un string "!(expr)"
     */
    public String visite(Non n) {
        return "!(" + n.bop().accepter(this) + ")";
    }

    /**Expression bool�enne Ou.
     *@return un string "( expr1 || expr2)"
     */
    public String visite(Ou ou) {
        return "(" + ou.bop1().accepter(this) + " || " + ou.bop2().accepter(this) + ")";
    }

    /**Expression bool�enne Et.
     *@return un string "( expr1 && expr2)"
     */
    public String visite(Et et) {
        return "(" + et.bop1().accepter(this) + " && " + et.bop2().accepter(this) + ")";
    }

    /**Expression bool�enne Sup�rieur �.
     *@return un string "( expr1 > expr2)"
     */
    public String visite(Sup sup) {
        return "(" + sup.op1().accepter(ve) + " > " + sup.op2().accepter(ve) + ")";
    }

    /**Expression bool�enne Egal �.
     *@return un string "( expr1 == expr2)"
     */
    public String visite(Egal eg) {
        return "(" + eg.op1().accepter(ve) + " == " + eg.op2().accepter(ve) + ")";
    }

    /**Expression bool�enne Inf�rieur �.
     *@return un string "( expr1 < expr2)"
     */
    public String visite(Inf inf) {
        return "(" + inf.op1().accepter(ve) + " < " + inf.op2().accepter(ve) + ")";
    }
}
