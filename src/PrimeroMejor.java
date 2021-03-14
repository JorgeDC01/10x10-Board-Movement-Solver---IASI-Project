import java.util.Collections;
import java.util.*;

public class PrimeroMejor {
    private Arbol arbol;
    private NodoArbol actual; //Puntero para recorrer el arbol.
    private int nodosGenerados;
    private Queue<NodoArbol> nodosAbiertos = new PriorityQueue<NodoArbol>();
    private List<NodoArbol> nodosCerrados = new ArrayList<NodoArbol>();

    public PrimeroMejor(){

    }

    public NodoArbol getActual() { return actual; }

    public void setActual(NodoArbol actual) { this.actual = actual; }

    public Arbol getArbol() { return arbol; }

    public void setArbol(Arbol arbol) { this.arbol = arbol; }

    public int getNodosGenerados() { return nodosGenerados; }

    public void setNodosGenerados(int nodosGenerados) { this.nodosGenerados = nodosGenerados; }

    public Queue<NodoArbol> getNodosAbiertos() { return nodosAbiertos; }

    public void setNodosAbiertos(Queue<NodoArbol> nodosAbiertos) { this.nodosAbiertos = nodosAbiertos; }

    public List<NodoArbol> getNodosCerrados() { return nodosCerrados; }

    public void setNodosCerrados(List<NodoArbol> nodosCerrados) { this.nodosCerrados = nodosCerrados; }

    /*

     */
    public void ejecutar(){

     System.out.println("--- Algoritmo Primero Mejor ---");
        // expando hijos
        // meto el actual expandido a la lista de cerrados
        // meto los hijos en lista de abiertos y ordeno
        // elijo el mejor en actual






    }


}
