import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arbol {

    private nodoArbol raiz;

    /*
        Constructor del arbol dado el contenido del nodo.
        @param raiz El contenido
     */
    public arbol(Pieza raiz){
        this.raiz = new nodoArbol(raiz,null);
    }
    /*
        Constructor del arbol dado el nodo raiz
        @param raiz La raiz del arbol
     */
    public arbol(nodoArbol raiz){
        this.raiz = raiz;
    }
    /*
        Devuelve el nodo raiz
        @return nodoArbol La raiz
     */
    public nodoArbol getRaiz(){return this.raiz;}
    /*
        Muestra árbol.
     */
    public void mostrar(){
        System.out.println(getRaiz().getPieza());
        List <nodoArbol> hijos = getRaiz().getHijos();
        Iterator <nodoArbol> it = hijos.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getPieza());
        }
    }
}
