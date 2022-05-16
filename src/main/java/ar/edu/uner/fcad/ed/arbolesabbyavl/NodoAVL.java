package ar.edu.uner.fcad.ed.arbolesabbyavl;

/**
 *
 * @author Nacho
 */
public class NodoAVL <T extends Comparable<T>> extends NodoABB<T> {

    protected int factorBalance;

    public NodoAVL(T valor) {
        super(valor);
        this.factorBalance = 0;
    }

    /**
     * @return the factorBalance
     */
    public int getFactorBalance() {
        return factorBalance;
    }

    /**
     * @param factorBalance the factorBalance to set
     */
    public void setFactorBalance(int factorBalance) {
        this.factorBalance = factorBalance;
    }

}
