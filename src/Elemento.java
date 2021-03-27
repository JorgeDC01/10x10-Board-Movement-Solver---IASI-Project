/**
 * Nombre: Elemento
 * Esta clase define un elemento de la pieza como un par de coordenadas "fila" y "columna";
 * correspondiendo a la posición de dicho elemento en la matriz.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class Elemento {
    private int filaElemento;
    private int columnaElemento;


    /**
     * Nombre: Elemento
     * Constructor por defecto de la clase.
     */

    public Elemento () {
        filaElemento = 0;
        columnaElemento = 0;
    }


    /**
     * Nombre: Elemento
     * @param fila es la fila donde se posiciona.
     * @param columna es la columna donde se posiciona.
     *
     * Constructor parametrizado de la clase.
     */

    public Elemento (int fila, int columna) {
        setFilaElemento (fila);
        setColumnaElemento (columna);
    }


    /**
     * Nombre: getFilaElemento
     * @return int la fila donde se encuentra el elemento.
     *
     * Devuelve la fila donde se encuentra el elemento.
     */

    public int getFilaElemento () {
        return filaElemento;
    }


    /**
     * Nombre: getColumnaElemento
     * @return int la columna donde se encuentra el elemento.
     *
     * Devuelve la columna donde se encuentra el elemento.
     */

    public int getColumnaElemento () {
        return columnaElemento;
    }


    /**
     * Nombre: setFilaElemento
     * @param filaElemento el nuevo valor de la fila.
     *
     * Inicializa el valor de la fila del elemento con el parámetro de entrada.
     *
     * El método no devuelve nada.
     */

    public void setFilaElemento (int filaElemento) {
        this.filaElemento = filaElemento;
    }


    /**
     * Nombre: setColumnaElemento
     * @param columnaElemento el nuevo valor de la columna.
     *
     * Inicializa el valor de la columna del elemento con el parámetro de entrada.
     *
     * El método no devuelve nada.
     */

    public void setColumnaElemento (int columnaElemento) {
        this.columnaElemento = columnaElemento;
    }


    /**
     * Nombre: clonarElemento
     * @return Elemento
     *
     * Clona el elemento que llama al método.
     *
     * El método devuelve el nuevo Elemento clonado.
     */

    public Elemento clonarElemento (){
        return new Elemento (this.filaElemento, this.columnaElemento);
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
    public int hashCode () {
        int result = 19;
        result = 3 * result + this.filaElemento;
        result = 23 * result + this.columnaElemento;
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
        }
        else if (!(obj instanceof Elemento)) {
            return false;
        }
        else {
            Elemento other = (Elemento) obj;
            return (this.filaElemento == other.getFilaElemento () && this.columnaElemento == other.getColumnaElemento ());
        }
    }
}