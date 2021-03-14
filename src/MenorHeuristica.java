import java.util.Comparator;

public class MenorHeuristica implements Comparator<NodoArbol> {

    @Override
    public int compare(NodoArbol o1, NodoArbol o2) {
        if(o1.calcularHeuristica() < o2.calcularHeuristica()){
            return 1;
        }
        else if(o1.calcularHeuristica() > o2.getHeuristica()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
