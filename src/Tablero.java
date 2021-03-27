/**
 * Nombre: Tablero
 * Esta clase define el Tablero sobre el que se construyen las Piezas móvil y objetivo, y la matriz donde se
 * encuentran dichas Piezas y los muros.
 * Esta clase está implementada utilizando el patrón Singleton, para asegurar que solo existe una instancia de dicho Tablero.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class Tablero {
    private static Tablero t;

    private String matriz[][];
    private Pieza movil;
    private Pieza objetivo;


    /**
     * Nombre: getInstance.
     * @return Tablero
     *
     * Devuelve un Tablero único; y en caso de no haber sino creado, llama al constructor de la clase.
     *
     * El Tablero devuelto es dicha instancia única de la clase.
     */

    public static Tablero getInstance () {
        if(t == null) {
            t = new Tablero ();
        }
        return t;
    }


    /**
     * Nombre: Tablero
     * Constructor por defecto de la clase.
     */

    private Tablero () {
        movil = null;
        objetivo = null;
        matriz = new String [10][10];
    }


    /**
     * Nombre: setPieza
     * @param pieza la nueva Pieza a asignar.
     *
     * Asigna la pieza que se mueve al tablero.
     *
     * Este método no devuelve nada.
     */

    public void setMovil (Pieza pieza) {
        this.movil = pieza;
    }


    /**
     * Nombre: setObjetivo
     * @param pieza
     *
     * Asigna la pieza objetivo a la del Tablero.
     *
     * El método no devuelve nada.
     */

    public void setObjetivo (Pieza pieza) {
        objetivo = pieza;
    }


    /**
     * Nombre: getPieza
     * @return Pieza
     *
     * Devuelve la Pieza móvil del Tablero.
     *
     * La Pieza devuelta es la móvil del Tablero.
     */

    public Pieza getMovil () {
        return movil;
    }


    /**
     * Nombre: getObjetivo
     * @return Pieza
     *
     * Devuelve la Pieza que contiene los datos a los que debe llegar la móvil.
     *
     * La Pieza devuelta es la objetivo del Tablero.
     */

    public Pieza getObjetivo () {
        return objetivo;
    }


    /**
     * Nombre: getMatriz
     * @return String [][]
     *
     * Devuelve la matriz que contiene al Tablero
     *
     * La matriz de String devuelta es la del Tablero.
    */

    public String[][] getMatriz(){
        return matriz;
    }


    /**
     * Nombre: showLaberinto.
     * Muestra la matriz del Tablero por pantalla.
     *
     * El método no devuelve nada.
     */

    public void showLaberinto () {
        StringBuilder stringbuilder = new StringBuilder ();
        for(int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {
                stringbuilder.append(matriz[i][j] + " ");
            }
            stringbuilder.append("\n");
        }
        System.out.println(stringbuilder.toString());
    }


    /**
     * Nombre: siEstaVacioOMuro
     * @return boolean
     * @param fila la fila que se quiere comprobar.
     * @param col la columna que se quiere comprobar.
     * @param tipoPieza el tipo de Pieza de la que se quiere comprobar ("2" la Pieza móvil, "3" la Pieza objetivo).
     *
     * Comprueba si la casilla de fila y columna está vacia, hay un muro o es una casilla de la posicion de la Pieza buscada.
     *
     * El método devuelve "True" si la casilla contiene "0", "1" o un Elemento de las Piezas móvil y objetivo (buscando siempre la contraria); y "False" en caso contrario.
     */

    public boolean siEstaVacioOMuro (int fila, int col, String tipoPieza) {
        String casillasDePieza = "";
        if (tipoPieza.equals ("2")) {
            casillasDePieza = "3";
        }
        else{
            casillasDePieza = "2";
        }
        boolean enc = false;
        if (this.matriz [fila][col].equals ("0") || this.matriz [fila][col].equals ("1") || this.matriz [fila][col].equals (casillasDePieza)) {
            enc = true;
        }
        return enc;
    }


    /**
     * Nombre: dentroRango
     * @return boolean
     * @param indice el valor a comprobar.
     *
     * Comprueba si el valor está dentro del rango de números que controla el tamaño del Tablero.
     *
     * Devuelve "True" si está dentro del rango, y "False" en caso contrario.
     */

    public boolean dentroRango (int indice) {
        if(indice > 0 && indice < 9){
            return true;
        }
        return false;
    }


    /**
     * Nombre: moverArriba
     * @return NodoArbol
     * @param pieza la Pieza a desplazar.
     *
     * Mueve la Pieza una posición hacia arriba.
     *
     * El valor devuelto es un Nodo del Árbol con todos las datos ya inicializados.
     */

    public NodoArbol moverArriba (Pieza pieza) {
        Pieza piezaAux = pieza.clonarPieza();
        piezaAux.getAislado ().setFilaElemento (piezaAux.getAislado ().getFilaElemento () - 1);
        piezaAux.getVertice ().setFilaElemento (piezaAux.getVertice().getFilaElemento() - 1);
        piezaAux.getAdyacente ().setFilaElemento (piezaAux.getAdyacente ().getFilaElemento () - 1);
        piezaAux.getExtremo ().setFilaElemento (piezaAux.getExtremo ().getFilaElemento () - 1);

        if (checkearMovimiento (piezaAux)) {
            return new NodoArbol (piezaAux,null,"A");
        }
        else {
            return null;
        }
    }


    /**
     * Nombre: moverAbajo
     * @return NodoArbol
     * @param pieza la Pieza a desplazar.
     *
     * Mueve la Pieza una posición hacia abajo
     *
     * El valor devuelto es un Nodo del Árbol con todos las datos ya inicializados.
     */

    public NodoArbol moverAbajo (Pieza pieza) {
        Pieza piezaAux = pieza.clonarPieza();
        piezaAux.getAislado ().setFilaElemento (piezaAux.getAislado ().getFilaElemento () + 1);
        piezaAux.getVertice ().setFilaElemento (piezaAux.getVertice().getFilaElemento() + 1);
        piezaAux.getAdyacente ().setFilaElemento (piezaAux.getAdyacente ().getFilaElemento () + 1);
        piezaAux.getExtremo ().setFilaElemento (piezaAux.getExtremo ().getFilaElemento () + 1);

        if (checkearMovimiento (piezaAux)) {
            return new NodoArbol (piezaAux,null,"B");
        }
        else {
            return null;
        }
    }


    /**
     * Nombre: moverDerecha
     * @return NodoArbol
     * @param pieza la Pieza a desplazar.
     *
     * Mueve la Pieza una posición a la derecha.
     *
     * El valor devuelto es un Nodo del Árbol con todos los datos ya inicializados.
     */

    public NodoArbol moverDerecha (Pieza pieza) {
        Pieza piezaAux = pieza.clonarPieza();
        piezaAux.getAislado ().setColumnaElemento (piezaAux.getAislado ().getColumnaElemento () + 1);
        piezaAux.getVertice ().setColumnaElemento (piezaAux.getVertice().getColumnaElemento() + 1);
        piezaAux.getAdyacente ().setColumnaElemento (piezaAux.getAdyacente ().getColumnaElemento () + 1);
        piezaAux.getExtremo ().setColumnaElemento (piezaAux.getExtremo ().getColumnaElemento () + 1);

        if (checkearMovimiento (piezaAux)) {
            return new NodoArbol (piezaAux,null,"D");
        }
        else {
            return null;
        }
    }


    /**
     * Nombre: moverIzquierda
     * @return NodoArbol
     * @param pieza la Pieza a desplazar
     *
     * Mueve la Pieza una posición a la izquierda.
     *
     * El valor devuelto es un Nodo del Árbol con todos los datos ya inicializados.
     */

    public NodoArbol moverIzquierda (Pieza pieza) {
        Pieza piezaAux = pieza.clonarPieza();
        piezaAux.getAislado ().setColumnaElemento (piezaAux.getAislado ().getColumnaElemento () - 1);
        piezaAux.getVertice ().setColumnaElemento (piezaAux.getVertice().getColumnaElemento() - 1);
        piezaAux.getAdyacente ().setColumnaElemento (piezaAux.getAdyacente ().getColumnaElemento () - 1);
        piezaAux.getExtremo ().setColumnaElemento (piezaAux.getExtremo ().getColumnaElemento () - 1);

        if (checkearMovimiento (piezaAux)) {
            return new NodoArbol (piezaAux,null,"I");
        }
        else {
            return null;
        }
    }


    /**
     * Nombre: rotar
     * @return NodoArbol
     * @param pieza la Pieza a desplazar.
     *
     * Rota la Pieza 90º en sentido horario.
     *
     * El valor devuelto es un Nodo de Árbol con todos los datos ya inicializados.
     */

    public NodoArbol rotar (Pieza pieza) {
        Pieza piezaAux = pieza.clonarPieza ();
        String orientacion = piezaAux.getOrientacion ();

        switch (orientacion) {
            case "A":
                piezaAux.getAdyacente ().setFilaElemento (piezaAux.getAislado ().getFilaElemento ());
                piezaAux.getAdyacente ().setColumnaElemento (piezaAux.getAislado ().getColumnaElemento ());

                piezaAux.getExtremo ().setFilaElemento (piezaAux.getAdyacente ().getFilaElemento ());
                piezaAux.getExtremo ().setColumnaElemento (piezaAux.getAdyacente ().getColumnaElemento () + 1);

                piezaAux.getAislado ().setFilaElemento (piezaAux.getVertice ().getFilaElemento () + 1);
                piezaAux.getAislado ().setColumnaElemento (piezaAux.getVertice ().getColumnaElemento ());

                piezaAux.setOrientacion ("D");
                break;

            case "B":
                piezaAux.getAdyacente ().setFilaElemento (piezaAux.getVertice ().getFilaElemento ());
                piezaAux.getAdyacente ().setColumnaElemento (piezaAux.getVertice ().getColumnaElemento () - 1);

                piezaAux.getExtremo ().setFilaElemento (piezaAux.getAdyacente ().getFilaElemento ());
                piezaAux.getExtremo ().setColumnaElemento (piezaAux.getAdyacente ().getColumnaElemento () - 1);

                piezaAux.getAislado ().setFilaElemento (piezaAux.getVertice ().getFilaElemento () - 1);
                piezaAux.getAislado ().setColumnaElemento (piezaAux.getVertice ().getColumnaElemento ());

                piezaAux.setOrientacion ("I");
                break;

            case "I":
                piezaAux.getAdyacente ().setFilaElemento (piezaAux.getVertice ().getFilaElemento () - 1);
                piezaAux.getAdyacente ().setColumnaElemento (piezaAux.getVertice ().getColumnaElemento ());

                piezaAux.getExtremo ().setFilaElemento (piezaAux.getAdyacente ().getFilaElemento () - 1);
                piezaAux.getExtremo ().setColumnaElemento (piezaAux.getAdyacente ().getColumnaElemento ());

                piezaAux.getAislado ().setFilaElemento (piezaAux.getVertice ().getFilaElemento ());
                piezaAux.getAislado ().setColumnaElemento (piezaAux.getVertice ().getColumnaElemento () + 1);

                piezaAux.setOrientacion ("A");
                break;

            case "D":
                piezaAux.getAdyacente ().setFilaElemento (piezaAux.getVertice ().getFilaElemento () + 1);
                piezaAux.getAdyacente ().setColumnaElemento (piezaAux.getVertice ().getColumnaElemento ());

                piezaAux.getExtremo ().setFilaElemento (piezaAux.getVertice ().getFilaElemento () + 1);
                piezaAux.getExtremo ().setColumnaElemento (piezaAux.getVertice ().getColumnaElemento ());

                piezaAux.getAislado ().setFilaElemento (piezaAux.getVertice ().getFilaElemento ());
                piezaAux.getAislado ().setColumnaElemento (piezaAux.getVertice ().getColumnaElemento () - 1);

                piezaAux.setOrientacion ("B");
                break;
        }
        if (checkearMovimiento (piezaAux)) {
            return new NodoArbol (piezaAux,null,"R");
        }
        else {
            return null;
        }
    }


    /**
     * Nombre: checkearMovimiento
     * @return boolean
     * @param piezaAux la Pieza auxiliar que indicará si se puede desplazar a su posición, o no; según los muros que haya en el Tablero.
     *
     * Indica si las posiciones de la Pieza auxiliar no colisionan con ningún muro.
     *
     * El método devuelve "True" si no hay colisiones, o "False" si sí las hay.
     */

    public boolean checkearMovimiento (Pieza piezaAux) {
        boolean result = true;
        if (getMatriz () [piezaAux.getAislado ().getFilaElemento ()][piezaAux.getAislado ().getColumnaElemento ()].equals ("1") ||
                getMatriz () [piezaAux.getVertice().getFilaElemento()][piezaAux.getVertice ().getColumnaElemento ()].equals ("1") ||
                getMatriz () [piezaAux.getAdyacente ().getFilaElemento ()][piezaAux.getAdyacente ().getColumnaElemento ()].equals ("1") ||
                getMatriz () [piezaAux.getExtremo ().getFilaElemento ()][piezaAux.getExtremo ().getColumnaElemento ()].equals ("1")) {
            result = false;
        }
        return result;
    }
}