import java.util.ArrayList;
import java.util.List;

/**
 * Nombre: NodoArbol
 * Esta clase define un Nodo de los Árboles de búsqueda.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class NodoArbol {
    private Pieza pieza;
    private int heuristica;
    private NodoArbol padre;
    private String operacion;
    private List <NodoArbol> hijos;


    /**
     * Nombre: NodoArbol
     * @param pieza La pieza que representa el estado.
     * @param padre el puntero al nodo padre.
     * @param operacion indica el carácter, representando la operación.
     *
     * Constructor parametrizado de la clase.
     */

    public NodoArbol (Pieza pieza, NodoArbol padre, String operacion){
        this.pieza = pieza;
        this.heuristica = calcularHeuristica ();
        this.padre = padre;
        this.hijos = new ArrayList <NodoArbol> ();
        this.operacion = operacion;
    }


    /**
     * Nombre: getPieza
     * @return Pieza
     *
     * Devuelve la Pieza del Nodo
     *
     * El método devuelve la Pieza con los datos que reprentan un estado del problema.
     */

    public Pieza getPieza(){
        return pieza;
    }


    /**
     * Nombre: getHijos
     * @return List </NodoArbol>
     *
     * Devuelve los hijos del estado actual.
     *
     * El método devuelve la lista de Nodos hijos del Nodo actual.
     */

    public List<NodoArbol> getHijos(){
        return hijos;
    }


    /**
     * Nombre: getPadre
     * @return NodoArbol
     *
     * Devuelve el estado padre del actual.
     *
     * El valor devuelto es un puntero al Nodo padre del actual.
     */

    public NodoArbol getPadre(){
        return padre;
    }


    /**
     * Nombre: setPadre
     * @param padre el nuevo Nodo padre del Nodo actual
     *
     * Enlaza el Nodo actual con su Nodo padre.
     */

    public void setPadre(NodoArbol padre){
        this.padre = padre;
    }


    /**
     * Nombre: getHeuristica
     * @return int
     *
     * Devuelve el valor heurístico del Nodo que referencia la función.
     */

    public int getHeuristica(){
        return heuristica;
    }


    /**
     * Nombre: calcularHeuristica
     * @return int
     *
     * Calcula el valor de la función heurística del Nodo que referencia la función.
     *
     * El valor devuelto es la función heurística del Nodo.
     */

    public int calcularHeuristica () {
        int filaObjetivo = Tablero.getInstance ().getObjetivo ().getVertice ().getFilaElemento ();
        int columnaObjetivo = Tablero.getInstance ().getObjetivo ().getVertice ().getColumnaElemento ();
        int filaInicio = pieza.getVertice ().getFilaElemento ();
        int columnaInicio = pieza.getVertice ().getColumnaElemento ();

        int rotaciones = 0;
        boolean enc = false;
        for (int i = 0; (i < 4) && (!enc); i++) {
            if (pieza.getOrientacion ().equals (Tablero.getInstance ().getObjetivo ().getOrientacion ())) {
                enc = true;
                if (rotaciones > 0) {
                    for (int j = 0; j < (4 - rotaciones); j++) {
                        tickRotacion ();
                    }
                }
            }
            else {
                tickRotacion ();
                rotaciones++;
            }
        }
        return (Math.abs (filaObjetivo - filaInicio) + Math.abs (columnaObjetivo - columnaInicio) + rotaciones);
    }


    /**
     * Nombre: tickRotacion
     * Modifica el valor de la orientacion con fines de cálculos matemáticos.
     *
     * El método no devuelve nada.
     */

    public void tickRotacion () {
        switch (pieza.getOrientacion ()) {
            case "A":
                pieza.setOrientacion ("D");
                break;
            case "B":
                pieza.setOrientacion ("I");
                break;
            case "I":
                pieza.setOrientacion ("A");
                break;
            case "D":
                pieza.setOrientacion ("B");
                break;
        }
    }


    /**
     * Nombre: getOperacion
     * @return String
     *
     * Devuelve el carácter indicando la operación realizada para llegar al Nodo actual.
     *
     * El String devuelto es el carácter que cumple tales características.
     */

    public String getOperacion () {
        return operacion;
    }


    /**
     * Nombre: hashCode
     * @return int el valor de hash del objeto.
     *
     * Genera un número primo único para el objeto, útil y necesario para los métodos "contain".
     *
     * El valor devuelto es el número primo único del objeto.
     */

    @Override
    public int hashCode() {
        int result = 17;
        result = 7 * result +this.getPieza().hashCode();
        return result;
    }


    /**
     * Nombre: equals
     * @return boolean true si son iguales, false si no son iguales.
     * @param obj es el objeto con el que se compara.
     *
     * Indica si el objeto "obj" es igual al objeto que llama al método.
     *
     * El valor booleano es "True" si son iguales, o "False" si son distintos.
     */

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof NodoArbol)) {
            return false;
        } else {
            NodoArbol other = (NodoArbol) obj;
            return getPieza ().equals (other.getPieza ());
        }
    }
}