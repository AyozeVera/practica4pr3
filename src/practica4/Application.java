package practica4;

public class Application {

    private static String erL = "Error en los límites";
    private static String erN = "Error en el número de menores pedidos";

    public static void main(String[] args) throws Exception {
        int longitud = 9;
        int m_menores = 4;
        int[] randomVec = {2,7,1,8,6,4,0,5,9,3};//crearVectorAleatorio(longitud);
        
        System.out.println("El vector tiene "+longitud+" elementos.");
        System.out.println("Se mostrarán los "+m_menores+" más pequeños que tiene, ordenados de mayor a menor.\n");
       
        muestraVector(randomVec,"Vector original");
        randomVec = m_menores(randomVec, 0, longitud - 1, m_menores);
        muestraVector(randomVec, "Vector modificado, los "+m_menores+" menores sin ordenar");

        //--El siguiente método ordena los M primeros elementos del vector,
        //--se ha implementado usando el algoritmo 'Shell', usado en la practia 2
        //--pero modificado para ordenar de mayor a menor.
        ordenaShell(randomVec, m_menores);
    }

    private static int[] crearVectorAleatorio(int longitud) {
        int[] vec = new int[longitud];
        for (int j = 0; j < vec.length; j++) {
            vec[j] = (int) (Math.random() * 101);
        }
        return vec;
    }

    private static int[] m_menores(int[] vec, int linf, int lsup, int m) throws Exception {
        if (linf > lsup) throw new Exception(erL);
        if (m > lsup || m < linf) throw new Exception(erN);
        if (linf == lsup) return vec;

        Division entero = new Division();
        entero.division(vec, linf, lsup);
        int pini = entero.getPini();
        int pfin = entero.getPfin();

        if (pfin + 1 == m) return vec;
        if (pfin + 1 > m) return m_menores(vec, linf, pfin, m);

        return m_menores(vec, pini, lsup, m);
    }
    
    public static void ordenaShell(int[] vec, int m) {
        int dist = m / 2;
        int j, aux;

        while (dist > 0) {
            for (int i = 0; i < (m - dist); i++) {
                j = i + dist;
                while ((j >= dist) && (vec[j] > vec[j - dist])) {
                    aux = vec[j];
                    vec[j] = vec[j - dist];
                    vec[j - dist] = aux;
                    j = j - dist;
                }
            }
            dist /= 2;
        }
        
        //--Aquí se muestra por pantalla los 'm' elementos del vector.
        //--Ahora están ordenados de mayor a menor.
        muestraVector(vec,"Los "+ m+" menores ordenados");
    }

    private static void muestraVector(int[] vector, String mensaje) {
        System.out.println(mensaje);
        for (int entero : vector) {
            System.out.print(entero + ", ");
        }
        System.out.println("\n");
    }
}
