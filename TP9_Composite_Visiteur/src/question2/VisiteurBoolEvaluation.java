package question2;

import question1.VisiteurExpression;

public class VisiteurBoolEvaluation extends VisiteurExpressionBooleenne<Boolean> {

    private VisiteurExpression<Integer> ve;

    public VisiteurBoolEvaluation(VisiteurExpression<Integer> ve) {
        this.ve = ve;
    }

    /**Expression bool�enne vrai.
     *@return true
     */
    public Boolean visite(Vrai v) {
        return true; 
    }

    /**Expression bool�enne faux.
     *@return false
     */
    public Boolean visite(Faux f) {
        return false; 
    }

    /**Expression bool�enne non.
     *@return !n.bop()
     */
    public Boolean visite(Non n) { 
        return ! n.bop().accepter(this); 
    }

    /**Expression bool�enne ou.
     *@return ou.bop1() || ou.bop2()
     */
    public Boolean visite(Ou ou) {
        return  ou.bop1().accepter(this) || ou.bop2().accepter(this);
    }

    /**Expression bool�enne et.
     *@return et.bop1() && et.bop2()
     */
    public Boolean visite(Et et) {
        return  et.bop1().accepter(this) && et.bop2().accepter(this);
    }

    /**Expression bool�enne Sup�rieur.
     *@return sup.op1() > sup.op2()
     */
    public Boolean visite(Sup sup) {
        return  sup.op1().accepter(ve) > sup.op2().accepter(ve);
    }

    /**Expression bool�enne Egal �.
     *@return eg.op1() == eg.op2()
     */
    public Boolean visite(Egal eg) {
        return  eg.op1().accepter(ve) == eg.op2().accepter(ve);
    }

    /**Expression bool�enne Inf�rieur �.
     *@return inf.op1() < inf.op2()
     */
    public Boolean visite(Inf inf) {
        return  inf.op1().accepter(ve) < inf.op2().accepter(ve);
    }

}
