package question1;

public class VisiteurEvaluation extends VisiteurParDefaut<Integer> {

    private Contexte c;

    public VisiteurEvaluation(Contexte c) {
        this.c = c;
    }

    // à compléter
    // aucun "warning, de type unsafe à la compilation ne doit apparaître
    public Integer visite(Constante c) {
        return c.valeur();
    }

    /**
     * La méthode de visite d'une variable v
     * @return la valeur de cette Variable
     */
    public Integer visite(Variable v) {
        return this.c.lire(v.nom());
    }

    /**
     * La méthode de visite d'une Division d
     * @return la valeur de cette Division
     */
    public Integer visite(Division d) {
        return  d.op1().accepter(this) / d.op2().accepter(this);
    }

    /**
     * La méthode de visite d'une Addition a
     * @return la valeur de cette Addition
     */
    public Integer visite(Addition a) {
        return a.op1().accepter(this) + a.op2().accepter(this);
    }

    /**
     * La méthode de visite d'une Multiplication m
     * @return la valeur de cette Multiplication
     */
    public Integer visite(Multiplication m) {
        return  m.op1().accepter(this) * m.op2().accepter(this);
    }

    /**
     * La méthode de visite d'une Soustraction s
     * @return la valeur de cette Soustraction
     */
    public Integer visite(Soustraction s) {
        return  s.op1().accepter(this) - s.op2().accepter(this);
    }

    /**
     * Le getter du contexte de ce visiteur
     * @return Contexte du visiteur
     */

    
    public Contexte contexte() {
        return c;
    }

}
