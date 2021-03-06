public class Arbol {
    private NodoArbol raiz;

    /*
        Constructor del arbol dado el contenido del nodo.
        @param raiz El contenido
     */
    public Arbol (Pieza pieza) {
        this.raiz = new NodoArbol (pieza,null, "0");
    }


    /*
        Constructor del arbol dado el nodo raiz
        @param raiz La raiz del arbol
     */

    public void setRaiz (NodoArbol raiz) {
        this.raiz = raiz;
    }

    /*
        Devuelve el nodo raiz
        @return nodoArbol La raiz
     */

    public NodoArbol getRaiz () {
        return this.raiz;
    }
}
