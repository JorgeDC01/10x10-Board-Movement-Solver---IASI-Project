/**
 * Esta clase define lo que es un elemento, es decir, los componentes de la pieza.
 */

public class Elemento {
    private int filaElemento; //Indica la fila de la matriz donde está el elemento.
    private int columnaElemento; //Indica la columna de la matriz donde está el elemento.

    /**
     * Constructor por defecto de la clase.
     */

    public Elemento () {
        filaElemento = 0;
        columnaElemento = 0;
    }

    /*
     *
     */

    public Elemento (int fila, int columna) {
        setFilaElemento (fila);
        setColumnaElemento (columna);
    }


    /**
     * Devuelve la fila donde se encuentra el elemento.
     * @return int la fila del elemento
     */

    public int getFilaElemento () {
        return filaElemento;
    }


    /**
     * Devuelve la columna donde se encuentra el elmento.
     * @return int la columna del elemento.
     */

    public int getColumnaElemento () {
        return columnaElemento;
    }


    /**
     * Inicializa el valor de la fila del elemento con el parámetro de entrada.
     * @param filaElemento
     */

    public void setFilaElemento (int filaElemento) {
        this.filaElemento = filaElemento;
    }


    /**
     * Inicializa el valor de la columna del elemento con el parámetro de entrada.
     * @param columnaElemento
     */

    public void setColumnaElemento (int columnaElemento) {
        this.columnaElemento = columnaElemento;
    }

    /*
        Clonar
     */
    public Elemento clonarElemento(){
        return new Elemento(this.filaElemento,this.columnaElemento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof Elemento)) {
            return false;
        }
        else {
            Elemento other = (Elemento) obj;
            return this.filaElemento == other.getFilaElemento() && this.columnaElemento == other.getColumnaElemento();
        }
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 3 * result + this.filaElemento;
        result = 23 * result + this.columnaElemento;
        return result;
    }
}


