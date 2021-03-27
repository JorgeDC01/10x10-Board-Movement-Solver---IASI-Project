import java.util.Collections;

/**
 * Nombre: EscaladaMaxPend
 * Esta clase define el Algoritmo de Escalada de Máxima Pendiente siguiendo los apuntes de la teoría de la asignatura.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class EscaladaMaxPend {
    private Arbol arbol;
    private NodoArbol actual;
    private int nodosGenerados;


    /**
     * Nombre: EscaladaMaxPend
     * @param pieza la Pieza con la que se empieza a resolver el problema.
     *
     * Constructor parametrizado de la clase.
     */

    public EscaladaMaxPend (Pieza pieza) {
        arbol = new Arbol (pieza.clonarPieza());
        actual = arbol.getRaiz ();
        nodosGenerados = 1;
        ejecutar ();
    }


    /**
     * Nombre: getNodosGenerados
     * @return int
     *
     * Devuelve el número de Nodos generados por el algoritmo.
     *
     * El int devuelto indica el número de Nodos generados en la construcción del Árbol.
     */

    public int getNodosGenerados () {
        return nodosGenerados;
    }


    /**
     * Nombre: expansionCompleta
     *
     * Expande del Nodo actual, intentando generar todos sus hijos con todos sus operadores.
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
    }


    /**
     * Nombre: ordenarHijos
     *
     * Ordena la estructura de Nodos hijos en orden ascendente en función del valor devuelto por la función heurística
     * en cada Nodo.
     */

    public void ordenarHijos () {
        Collections.sort (actual.getHijos (), new MenorHeuristica ());
    }


    /**
     * Nombre: mostrarSolucion
     *
     * Muestra por pantalla la solución al problema.
     *
     * Este método no devuelve nada.
     */

    public void mostrarSolucion () {
        actual = arbol.getRaiz ();
        String resultado = "";
        while (actual.getHijos ().size () != 0) {
            actual = actual.getHijos ().get (0);
            resultado += actual.getOperacion () + ", ";
        }
        System.out.println ("Secuencia solucion: " + resultado);
    }


    /**
     * Nombre: ejecutar
     *
     * Ejecuta el Algoritmo de Escalada Máxima Pendiente.
     *
     * Este método no devuelve nada.
     */

    public void ejecutar () {
        long inicio = System.currentTimeMillis ();
        System.out.println ("--- Algoritmo Escalada Máxima Pendiente ---");
        boolean finBucle = false;
        while (actual.getHeuristica() != 0 && !finBucle) {
            expansionCompleta ();
            ordenarHijos ();
            actual = actual.getHijos ().get (0);
            if(actual.getHeuristica () > actual.getPadre ().getHeuristica () || actual == null) {
                finBucle = true;
            }
        }
        if (actual.getHeuristica () == 0) {
            mostrarSolucion ();
            System.out.println ("Número de nodos generados: " + getNodosGenerados ());
        }
        else{
            System.out.println ("No se ha encontrado una solución...");
            System.out.println ("Número de nodos generados: " + getNodosGenerados ());
        }
        long fin = System.currentTimeMillis ();
        double tiempo = (double) (fin - inicio);
        System.out.println ("Tiempo en ejecutarse Escalada de Maxima pendiente: " + tiempo + " milisegundos.");
    }
}