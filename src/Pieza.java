/**
 * Nombre: Pieza
 * Esta clase define las piezas que hay en el tablero, tanto la móvil como la objetivo.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class Pieza {
    private Elemento vertice; //Vértice de la L
    private Elemento aislado; //Elemento colindante al vértice que no se encuentra unido a ningún otro.
    private Elemento adyacente; //Elemento colindante al vértice que tiene más Elementos alrededor.
    private Elemento extremo; //Elemento más alejado del vértice.
    private String orientacion; //Orientación de la pieza.


    /**
     * Nombre: Pieza.
     * @param vertice es el vértice de la pieza.
     * @param orientacion es la orientación de la pieza.
     * Inicializa una instancia de la pieza.
     */

    public Pieza (Elemento vertice, String orientacion) {
        setVertice (vertice);
        setOrientacion (orientacion);
        aislado = new Elemento();
        adyacente = new Elemento();
        extremo = new Elemento();

        switch (orientacion) {
            case "A":
                aislado.setFilaElemento (getVertice ().getFilaElemento ());
                aislado.setColumnaElemento (getVertice ().getColumnaElemento () + 1);

                adyacente.setFilaElemento (getVertice ().getFilaElemento () - 1);
                adyacente.setColumnaElemento(getVertice ().getColumnaElemento ());

                extremo.setFilaElemento (getVertice ().getFilaElemento () - 2);
                extremo.setColumnaElemento (getVertice ().getColumnaElemento ());
                break;

            case "B":
                aislado.setFilaElemento (getVertice ().getFilaElemento ());
                aislado.setColumnaElemento (getVertice ().getColumnaElemento () - 1);

                adyacente.setFilaElemento (getVertice ().getFilaElemento () + 1);
                adyacente.setColumnaElemento (getVertice ().getColumnaElemento ());

                extremo.setFilaElemento (getVertice ().getFilaElemento () + 2);
                extremo.setColumnaElemento (getVertice ().getColumnaElemento ());
                break;

            case "D":
                aislado.setFilaElemento (getVertice ().getFilaElemento () + 1);
                aislado.setColumnaElemento (getVertice ().getColumnaElemento ());

                adyacente.setFilaElemento (getVertice ().getFilaElemento ());
                adyacente.setColumnaElemento (getVertice ().getColumnaElemento () + 1);

                extremo.setFilaElemento (getVertice ().getFilaElemento ());
                extremo.setColumnaElemento (getVertice ().getColumnaElemento () + 2);
                break;

            case "I":
                aislado.setFilaElemento (getVertice ().getFilaElemento () - 1);
                aislado.setColumnaElemento (getVertice ().getColumnaElemento ());

                adyacente.setFilaElemento (getVertice ().getFilaElemento ());
                adyacente.setColumnaElemento (getVertice ().getColumnaElemento () - 1);

                extremo.setFilaElemento (getVertice ().getFilaElemento ());
                extremo.setColumnaElemento (getVertice ().getColumnaElemento () - 2);
                break;
        }
    }


    /**
     * Nombre: getOrientacion
     * @return String la orientación de la Pieza.
     *
     * Devuelve la orientación de la pieza.
     *
     * El String devuelto sigue el formato: A (arriba), B (abajo), I (izquierda), D (derecha).
     */

    public String getOrientacion () {
        return orientacion;
    }


    /**
     * Nombre: setOrientacion
     * @param orientacion la nueva orientacion de la pieza.
     *
     * Asigna un nuevo valor a la orientación de la Pieza.
     */

    public void setOrientacion (String orientacion) {
        this.orientacion = orientacion;
    }


    /**
     * Nombre: getAislado
     * @return Elemento
     *
     * Devuelve el elemento definido como "aislado" de la Pieza.
     *
     * El objeto devuelto es dicho Elemento indicado.
     */

    public Elemento getAislado () {
        return aislado;
    }


    /**
     * Nombre: getAdyacente
     * @return Elemento
     *
     * Devuelve el elemento definido como "adyacente" de la Pieza.
     */

    public Elemento getAdyacente () {
        return adyacente;
    }


    /**
     * Nombre: getExtremo
     * @return Elemento
     *
     * Devuelve el elemento definido como "extremo" de la Pieza.
     */

    public Elemento getExtremo () {
        return extremo;
    }


    /**
     * Nombre: getVertice
     * @return Elemento
     *
     * Devuelve el elemento definido como "vertice" de la Pieza.
     */

    public Elemento getVertice () {
        return vertice;
    }


    /**
     * Nombre: setVertice
     * @param vertice el nuevo vertice de la Pieza.
     *
     * Asigna un nuevo objeto al vértice de la Pieza.
     */

    public void setVertice (Elemento vertice) {
        this.vertice = vertice;
    }


    /**
     * Nombre: mostrarPieza
     * Muestra la posición de la pieza en pantalla.
     *
     * El método no devuelve nada.
     */

    public void mostrarPieza () {
        System.out.println ("VERTICE: " + getVertice ().getFilaElemento () + " - " + getVertice().getColumnaElemento() +
                " -  " + getOrientacion ());
        System.out.println ("AISLADO: " + getAislado ().getFilaElemento () + " - " + getAislado ().getColumnaElemento ());
        System.out.println ("ADYACENTE: " + getAdyacente ().getFilaElemento () + " - " + getAdyacente ().getColumnaElemento ());
        System.out.println ("EXTREMO: " + getExtremo ().getFilaElemento () + " - " + getExtremo ().getColumnaElemento ());
        System.out.println();
    }


    /**
     * Nombre: clonarPieza
     * @return Pieza
     *
     * Clona la Pieza referenciada, generando una nueva Pieza con las mismas características.
     *
     * La Pieza devuelta es el nuevo clon de la referenciada (la que llama al método).
     */

    public Pieza clonarPieza () {
        return new Pieza (getVertice ().clonarElemento (), getOrientacion());
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
        int result = 13;
        result = 11 * result + getVertice().hashCode();
        result = 5 * result + getOrientacion().hashCode();
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
        } else if (!(obj instanceof Pieza)) {
            return false;
        } else {
            Pieza other = (Pieza) obj;
            return (this.orientacion.equals(other.getOrientacion()) && getVertice().equals(other.getVertice()));
        }
    }
}