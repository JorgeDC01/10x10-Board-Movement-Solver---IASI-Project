import java.util.Collections;
import java.util.*;

public class PrimeroMejor {
    private Arbol arbol;
    private NodoArbol actual; //Puntero para recorrer el arbol.
    private int nodosGenerados;
    private Queue<NodoArbol> nodosAbiertos = new PriorityQueue<>();
    private Set<NodoArbol> nodosCerrados = new HashSet<NodoArbol>();

    public PrimeroMejor(Pieza pieza){
        arbol = new Arbol(pieza);
        actual = arbol.getRaiz();
        nodosGenerados = 1;
        nodosAbiertos.add(actual);
        ejecutar();

    }

    public NodoArbol getActual() { return actual; }

    public void setActual(NodoArbol actual) { this.actual = actual; }

    public Arbol getArbol() { return arbol; }

    public void setArbol(Arbol arbol) { this.arbol = arbol; }

    public int getNodosGenerados() { return nodosGenerados; }

    public void setNodosGenerados(int nodosGenerados) { this.nodosGenerados = nodosGenerados; }

    public Queue<NodoArbol> getNodosAbiertos() { return nodosAbiertos; }

    public void setNodosAbiertos(Queue<NodoArbol> nodosAbiertos) { this.nodosAbiertos = nodosAbiertos; }

    public Set<NodoArbol> getNodosCerrados() { return nodosCerrados; }

    public void setNodosCerrados(Set<NodoArbol> nodosCerrados) { this.nodosCerrados = nodosCerrados; }

    /*
       Expande del nodo actual con todos sus operadores para posteriormente elegir la menor h'
    */
    public void expansionCompleta(){
        NodoArbol hijo = Tablero.getInstance().moverArriba(actual.getPieza());

        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
        hijo = Tablero.getInstance().moverDerecha(actual.getPieza());
        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
        hijo = Tablero.getInstance().moverAbajo(actual.getPieza());
        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
        hijo = Tablero.getInstance().moverIzquierda(actual.getPieza());
        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
        hijo = Tablero.getInstance().rotar(actual.getPieza());
        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
    }

    /*
        Algoritmo de Primero Mejor.
     */
    public void ejecutar(){

     System.out.println("--- Algoritmo Primero Mejor ---");

        /*while((listaAbiertos no esté vacia) && (no se encuentre la sol))
            Expandir hijos del nodo actual
            Inserto todos los hijos en la lista de abiertos, pero antes comprobar que no se repiten en ambos listas
            Inserto el actual en la lista de cerrados
            Elijo el mejor de la lista de abiertos y se lo asigno a actual
         */
    }
}
