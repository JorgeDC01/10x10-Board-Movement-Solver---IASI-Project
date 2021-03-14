/**
 * Esta clase define las piezas del tablero, ya sea la que se mueve o la objetivo.
 */

public class Pieza {
    private Elemento vertice; //Es el vértice de la L
    private Elemento aislado; //Es el elemento que se encuentra al lado del vértice y que no tiene nigún elemento más alrededor.
    private Elemento adyacente; //Es el elemento que se encuentra entre el vértice y el extremo de la L.
    private Elemento extremo; //Es el elemento más alejado del vértice de la L
    private String orientacion; //Indica la orientación de la pieza.


    /**
     * Inicializa una instancia de la pieza.
     * @param vertice es el vértice de la pieza.
     * @param orientacion es la orientación de la pieza.
     */

    public Pieza(Elemento vertice, String orientacion){
        setVertice (vertice);
        setOrientacion (orientacion);
        aislado = new Elemento();
        adyacente = new Elemento();
        extremo = new Elemento();

        switch (orientacion) {
            case "A":
                aislado.setFilaElemento(getVertice ().getFilaElemento ());
                aislado.setColumnaElemento(getVertice ().getColumnaElemento () + 1);

                adyacente.setFilaElemento(getVertice ().getFilaElemento () -1);
                adyacente.setColumnaElemento(getVertice ().getColumnaElemento ());

                extremo.setFilaElemento(getVertice ().getFilaElemento () - 2);
                extremo.setColumnaElemento(getVertice ().getColumnaElemento ());
                break;

            case "B":
                aislado.setFilaElemento(getVertice ().getFilaElemento ());
                aislado.setColumnaElemento(getVertice ().getColumnaElemento () - 1);

                adyacente.setFilaElemento(getVertice ().getFilaElemento () + 1);
                adyacente.setColumnaElemento(getVertice ().getColumnaElemento ());

                extremo.setFilaElemento(getVertice ().getFilaElemento () + 2);
                extremo.setColumnaElemento(getVertice ().getColumnaElemento ());
                break;

            case "D":
                aislado.setFilaElemento(getVertice ().getFilaElemento () + 1);
                aislado.setColumnaElemento(getVertice ().getColumnaElemento ());

                adyacente.setFilaElemento(getVertice ().getFilaElemento ());
                adyacente.setColumnaElemento(getVertice ().getColumnaElemento () + 1);

                extremo.setFilaElemento(getVertice ().getFilaElemento ());
                extremo.setColumnaElemento(getVertice ().getColumnaElemento () + 2);
                break;

            case "I":
                aislado.setFilaElemento(getVertice ().getFilaElemento () - 1);
                aislado.setColumnaElemento(getVertice ().getColumnaElemento ());

                adyacente.setFilaElemento(getVertice ().getFilaElemento ());
                adyacente.setColumnaElemento(getVertice ().getColumnaElemento () - 1);

                extremo.setFilaElemento(getVertice ().getFilaElemento ());
                extremo.setColumnaElemento(getVertice ().getColumnaElemento () - 2);
                break;
        }
    }

    /**
     * Devuelve la orientación de la pieza.
     * @return String la orientación: A (arriba), B (abajo), I (izquierda), D (derecha).
     */

    public String getOrientacion () {
        return orientacion;
    }

    /**
     * Inicializa la orientación de la pieza según el carácter dado.
     * @param orientacion
     */

    public void setOrientacion (String orientacion) {
        this.orientacion = orientacion;
    }

    /**
     * Devuelve el elemento aislado de la pieza.
     * @return Elemento
     */

    public Elemento getAislado () {
        return aislado;
    }

    /**
     * Devuelve el elemento adyacente al vértice de la pieza.
     * @return Elemento
     */

    public Elemento getAdyacente () {
        return adyacente;
    }

    /**
     * Devuelve el elemento más alejado del vértice de la L.
     * @return Elemento.
     */

    public Elemento getExtremo () {
        return extremo;
    }

    /**
     * Devuelve el vértice de la pieza.
     * @return Elemento.
     */

    public Elemento getVertice () {
        return vertice;
    }

    /**
     * Inicializa el vértice a uno dado.
     * @param vertice es el nuevo elemento.
     */

    public void setVertice (Elemento vertice) {
        this.vertice = vertice;
    }


    /**
     * Muestra la posición de la pieza en pantalla.
     */

    public void mostrarPieza () {
        System.out.println ("VERTICE: "+getVertice().getFilaElemento () + " - " + getVertice().getColumnaElemento() +
                " -  " + getOrientacion ());
        System.out.println ("AISLADO: "+getAislado().getFilaElemento() + " - " + getAislado().getColumnaElemento());
        System.out.println ("ADYACENTE: " + getAdyacente ().getFilaElemento () + " - " + getAdyacente().getColumnaElemento());
        System.out.println ("EXTREMO: " + getExtremo().getFilaElemento() + " - " + getExtremo().getColumnaElemento());
        System.out.println("");
    }

    /**
     * Clona la pieza auxiliar generando una nueva.
     * @return Pieza
     */

    public Pieza clonarPieza () {
        return new Pieza (getVertice().clonarElemento(), getOrientacion());
    }
}
