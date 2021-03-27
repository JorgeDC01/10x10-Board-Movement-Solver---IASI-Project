/**
 * Nombre: Arbol
 * Esta clase define toda la funcionalidad para el modelo de Árbol que utilizamos en nuestro proyecto.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class Arbol {
    private NodoArbol raiz;

    /**
     * Nombre: Arbol
     * @param pieza la pieza que contendrá la raíz.
     *
     * Constructor parametrizado de la clase.
     */

    public Arbol (Pieza pieza) {
        this.raiz = new NodoArbol (pieza,null, "0");
    }


    /**
     * Nombre: getRaiz
     * @return NodoArbol
     *
     * Devuelve la raíz del árbol.
     *
     * El valor devuelto equivale a la raíz del árbol.
     */

    public NodoArbol getRaiz () {
        return this.raiz;
    }
}