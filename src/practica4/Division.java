package practica4;

public class Division {

    private int pini;
    private int pfin;

    public Division() {
        pini = 0;
        pfin = 0;
    }

    public int getPini() {
        return pini;
    }

    public int getPfin() {
        return pfin;
    }

    public void division(int[] vec, int linf, int lsup) {
        int piv = (int) (Math.random() * ((lsup - linf) + 1) + linf);
        pini = linf;
        pfin = lsup;
        while (pini <= pfin) {
            while ((pini <= lsup) && (vec[pini] <= vec[piv])) pini++;
            while ((pfin >= linf) && (vec[pfin] >= vec[piv])) pfin--;

            if (pini < pfin) {
                int aux = vec[pini];
                vec[pini] = vec[pfin];
                vec[pfin] = aux;
                pini++;
                pfin--;
            }
        }
        if (pini < piv) {
            int aux = vec[pini];
            vec[pini] = vec[piv];
            vec[piv] = aux;
            pini++;
        } else {
            if (pfin > piv) {
                int aux = vec[piv];
                vec[piv] = vec[pfin];
                vec[pfin] = aux;
                pfin--;
            }
        }
    }
}
