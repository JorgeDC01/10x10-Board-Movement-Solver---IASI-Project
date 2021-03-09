import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EscaladaMaxPend {
    private Arbol arbol;
    private NodoArbol actual; //Puntero para recorrer el arbol.
    private int nodosGenerados;

    public EscaladaMaxPend (Pieza pieza) {
        arbol = new Arbol (pieza.clonarPieza());
        actual = arbol.getRaiz();
        nodosGenerados = 1;
        ejecutar ();
    }

    public Arbol getArbol () {
        return arbol;
    }

    public int getNodosGenerados () {
        return nodosGenerados;
    }

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
        Ordena el arrayList de hijos del nodo de menor a mayor según su heuristica
     */

    public void ordenarHijos(){
        Collections.sort(actual.getHijos(), new MenorHeuristica());
    }

    public void ejecutar () {
        /*while(actual.calcularHeuristica() != 0){
            expansionCompleta();
            ordenarHijos();
            //Eleccion mejor h'
        }*/

        expansionCompleta();
        ordenarHijos();
        System.out.println ("Hijos de raiz: " + arbol.getRaiz().mostrarDatos());
        System.out.println ("Hijos de actual: " + actual.mostrarDatos());

    }
}
