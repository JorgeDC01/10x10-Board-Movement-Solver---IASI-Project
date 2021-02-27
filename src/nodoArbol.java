import java.util.ArrayList;
import java.util.List;

public class nodoArbol {
    private Pieza pieza;
    private List<nodoArbol> hijos = new ArrayList<nodoArbol>();
    private nodoArbol padre;
    private int heuristica;
    /*
        Constructor parametrizado dada la pieza y el estado padre.
        @param pieza La pieza que representa el estado.
        @param padre El estado padre del estado.
     */
    public nodoArbol(Pieza pieza, nodoArbol padre){
        this.pieza = pieza;
        this.heuristica = 0;
        this.padre = padre;
    }
    /*
        Devuelve la pieza del nodo.
        @return La pieza.
     */
    public Pieza getPieza(){return pieza;}
    /*
        Devuelve los hijos del estado actual.
        @return Lista de hijos
     */
    public List<nodoArbol> getHijos(){return hijos;}
    /*
        Devuelve el estado padre del nodo.
        @return nodoArbol El nodo padre.
     */
    public nodoArbol getPadre(){return padre;}
    /*
        Devuelve la heurística del estado con respecto el estado objetivo.
        @return int La heurística que indica la proximidad con respecto el estado objetivo.
     */
    public int getHeuristica(){return heuristica;}
    /*
        Añade un nuevo hijo al nodo.
        @param pieza La pieza hija del estado.
     */
    public void setHijo(Pieza pieza){
        nodoArbol nuevoHijo = new nodoArbol(pieza,this);
        this.getHijos().add(nuevoHijo);
    }

}
