import java.util.Comparator;

/**
 * Nombre: MenorHeuristica
 * Esta clase define un Comparator para las ordenaciones de los Nodos en las Estructuras de Datos.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class MenorHeuristica implements Comparator <NodoArbol> {


    /**
     * Nombre: compare
     * @return int
     * @param o1 primer Nodo a comparar.
     * @param o2 segundo Nodo a comparar.
     *
     * Devuelve los valores -1, 0 o 1 en función del orden que deban seguir los objetos comparados.
     *
     * El valor devuelto indica el orden que deben seguir los objetos.
     */

    @Override
    public int compare (NodoArbol o1, NodoArbol o2) {
        if (o1.getHeuristica () < o2.getHeuristica ()){
            return -1;
        }
        else if (o1.getHeuristica () > o2.getHeuristica ()){
            return 1;
        }
        else{
            return 0;
        }
    }
}