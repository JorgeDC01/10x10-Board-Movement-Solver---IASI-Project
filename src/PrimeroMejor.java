import java.util.*;

/**
 * Nombre: PrimeroMejor
 * Esta clase define el Algoritmo de Primero Mejor siguiendo los apuntes de la teoría de la asignatura.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class PrimeroMejor {
    private Arbol arbol;
    private NodoArbol actual;
    private int nodosGenerados;
    private Queue<NodoArbol> nodosAbiertos = new PriorityQueue <NodoArbol> (new MenorHeuristica ());
    private Set <NodoArbol> nodosCerrados = new HashSet< NodoArbol> ();

    /**
     * Nombre: PrimeroMejor
     * @param pieza la Pieza con la que se empieza a resolver el problema.
     *
     * Constructor parametrizado de la clase.
     */

    public PrimeroMejor (Pieza pieza) {
        arbol = new Arbol (pieza);
        actual = arbol.getRaiz ();
        nodosGenerados = 1;
        nodosAbiertos.add (actual);
        ejecutar ();
    }


    /**
     * Nombre: getActual
     * @return NodoArbol
     *
     * Devuelve el Nodo al que apunta el puntero "actual".
     */

    public NodoArbol getActual() {
        return actual;
    }


    /**
     * Nombre: getNodosGenerados
     * @return int
     *
     * Devuelve el número de Nodos generados por el Algorimto.
     *
     * El int devuelto indica el número de Nodos generados.
     */

    public int getNodosGenerados() {
        return nodosGenerados;
    }


    /**
     * Nombre: getNodosAbiertos
     * @return Queue </NodoArbol>
     *
     * Devuelve la cola de Nodos abiertos.
     *
     * El valor devuelto es un puntero a la Estructura de Datos.
     */

    public Queue <NodoArbol> getNodosAbiertos () {
        return nodosAbiertos;
    }


    /**
     * Nombre: getNodosCerrados
     * @return Set </NodoArbol>
     *
     * Devuelve el conjunto de Nodos cerrados
     *
     * El valor devuelto es un puntero a la Estructura de Datos.
     */

    public Set <NodoArbol> getNodosCerrados () {
        return nodosCerrados;
    }


    /**
     * Nombre: expansionCompleta
     *
     * Expande el Nodo actual, intentando generar todos sus hijos con todos sus operadores.
     *
     * El método no devuelve nada.
     */

    public void expansionCompleta () {
        NodoArbol hijo = Tablero.getInstance ().moverArriba (actual.getPieza ());
        if (hijo != null) {
            hijo.setPadre (actual);
            nodosGenerados++;
            actual.getHijos ().add (hijo);
        }

        hijo = Tablero.getInstance ().moverDerecha (actual.getPieza ());
        if (hijo != null) {
            hijo.setPadre (actual);
            nodosGenerados++;
            actual.getHijos ().add (hijo);
        }

        hijo = Tablero.getInstance ().moverAbajo (actual.getPieza ());
        if (hijo != null) {
            hijo.setPadre (actual);
            nodosGenerados++;
            actual.getHijos ().add (hijo);
        }

        hijo = Tablero.getInstance ().moverIzquierda (actual.getPieza ());
        if (hijo != null) {
            hijo.setPadre (actual);
            nodosGenerados++;
            actual.getHijos ().add (hijo);
        }

        hijo = Tablero.getInstance ().rotar (actual.getPieza ());
        if (hijo != null) {
            hijo.setPadre (actual);
            nodosGenerados++;
            actual.getHijos ().add (hijo);
        }

        for (NodoArbol aux : getActual ().getHijos ()) {
            if (!getNodosAbiertos ().contains (aux) && !getNodosCerrados ().contains (aux)) {
                getNodosAbiertos ().add (aux);
            }
        }
    }


    /**
     * Nombre: mostrarSolucion
     *
     * Muestra por pantalla la solución al problema.
     *
     * Este método no devuelve nada.
     */

    public void mostrarSolucion () {
        List <NodoArbol> solucion = new ArrayList <NodoArbol> ();
        String resultado = "";
        while (actual.getPadre () != null) {
            solucion.add (actual);
            actual = actual.getPadre ();
        }
        for (int i = solucion.size () - 1; i >= 0; i--) {
            resultado += solucion.get (i).getOperacion () + ", ";
        }
        System.out.println ("Secuencia solucion: " + resultado);
    }


    /**
     * Nombre: ejecutar
     *
     * Ejecuta el Algoritmo de Primero Mejor.
     *
     * Este método no devuelve nada.
     */

    public void ejecutar () {
        long inicio = System.currentTimeMillis ();
        System.out.println ("--- Algoritmo Primero Mejor ---");
        boolean solEncontrada = false;
        while (actual != null && !solEncontrada) {
            expansionCompleta ();
            getNodosCerrados ().add (actual);
            actual = getNodosAbiertos ().poll ();
            if (actual != null && actual.getHeuristica () == 0) {
                solEncontrada = true;
            }
        }
        if (solEncontrada) {
            mostrarSolucion ();
            System.out.println ("Número de nodos generados: " + getNodosGenerados ());
        } else {
            System.out.println ("No se ha encontrado una solución...");
            System.out.println ("Número de nodos generados: " + getNodosGenerados ());
        }
        long fin = System.currentTimeMillis ();
        double tiempo = (double) (fin - inicio);
        System.out.println ("Tiempo en ejecutarse Primero Mejor: " + tiempo + " milisegundos.");
    }
}