import java.lang.Math;

/**
 * Esta clase define el tablero con la matriz, las piezas, etc.
 */

public class Tablero {
    private static Tablero t; //Patrón Singleton, para asegurar que solo exista un tablero en la ejecución del programa.

    private String matriz[][]; //Matriz del tablero.
    private Pieza pieza; //Pieza que se mueve alrededor del tablero.
    private Pieza objetivo; //Pieza objetivo que hay que imitar.

    /*
        Devyelve el tablero único. Si no ha sido creado, llama al constructor privado. SINGLETON.
        @return El objeto tablero único.
     */
    public static Tablero getInstance(){
        if(t == null) {
            t = new Tablero();
        }
        return t;
    }


    /*
        Constructor por defecto del tablero que se usará. Es único.
     */

    private Tablero () {
        pieza = null;
        objetivo = null;
        matriz = new String [10][10];
    }


    /*
        Asigna la pieza que se mueve al tablero.
        @param pieza La pieza que se asignará.
     */

    public void setPieza (Pieza pieza){
        this.pieza = pieza;
    }

    /*
        Asigna la pieza objetivo al tablero.
        @param pieza La pieza que se asignará.
     */

    public void setObjetivo(Pieza pieza) {
        objetivo = pieza;
    }


    /*
        Devuelve la pieza que hay que mover por el tablero hasta dar con la solucion
     */

    public Pieza getPieza() {
        return pieza;
    }


    /*
        Devuelve la posicion en la que tiene que debe estar la pieza para acabar
     */

    public Pieza getObjetivo () {
        return objetivo;
    }


    /*
       Devuelve el tablero como matriz
       @return matriz de enteros como tablero
    */

    public String[][] getMatriz(){
        return matriz;
    }


    /*
        Muestra el tablero por pantalla
     */

    public void showLaberinto () {
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {
                stringbuilder.append(matriz[i][j]);
            }
            stringbuilder.append("\n");
        }
        System.out.println(stringbuilder.toString());
    }

    /*
        Comprueba si la casilla de fila y columna está vacia, hay un muro o es una casilla de la posicion de la pieza objetivo.
        @param fila La fila de la casilla a comprobar
        @param col La columna de la casilla a comprobar
        @return Un booleano: TRUE si la casilla es 0,1 o 3 y FALSE en caso contrario.
     */

    public boolean siEstaVacioOMuro(int fila, int col, String tipoPieza){
        // Si las casillas de la pieza a buscar es 2, entonces hay que comprobar con los muros.
        String casillasDePieza;
        if(tipoPieza.equals("2")){
            casillasDePieza = "3";
        }
        else{
            casillasDePieza = "2";
        }
        boolean enc = false;
        if(this.matriz[fila][col].equals("0") || this.matriz[fila][col].equals("1") || this.matriz[fila][col].equals(casillasDePieza)){
            enc = true;
        }
        return enc;
    }

    /*
        Comprueba si la casilla de fila y col está dentro o fuera de la matriz.
        @param indice El indice que se va a comprobar si está dentro del rango del tablero
        @return TRUE si está dentro del rango y FALSE en caso contrario
     */
    public boolean dentroRango(int indice){
        if(indice > 0 && indice < 9){
            return true;
        }
        return false;
    }


    /**
     * Mueve la pieza una posición hacia arriba.
     */

    public Pieza moverArriba (Pieza pieza) {
        Pieza piezaAux = new Pieza (pieza.getVertice(), pieza.getOrientacion ());
        piezaAux.getAislado ().setFilaElemento (piezaAux.getAislado ().getFilaElemento () - 1);
        piezaAux.getVertice ().setFilaElemento (piezaAux.getVertice().getFilaElemento() - 1);
        piezaAux.getAdyacente ().setFilaElemento (piezaAux.getAdyacente ().getFilaElemento () - 1);
        piezaAux.getExtremo ().setFilaElemento (piezaAux.getExtremo ().getFilaElemento () - 1);

        if (checkearMovimiento (piezaAux)) {
            return piezaAux;
        }
        else {
            return null;
        }
    }

    public Pieza moverAbajo (Pieza pieza) {
        Pieza piezaAux = new Pieza (pieza.getVertice(), pieza.getOrientacion ());
        piezaAux.getAislado ().setFilaElemento (piezaAux.getAislado ().getFilaElemento () + 1);
        piezaAux.getVertice ().setFilaElemento (piezaAux.getVertice().getFilaElemento() + 1);
        piezaAux.getAdyacente ().setFilaElemento (piezaAux.getAdyacente ().getFilaElemento () + 1);
        piezaAux.getExtremo ().setFilaElemento (piezaAux.getExtremo ().getFilaElemento () + 1);

        if (checkearMovimiento (piezaAux)) {
            return piezaAux;
        }
        else {
            return null;
        }
    }

    public Pieza moverDerecha (Pieza pieza) {
        Pieza piezaAux = new Pieza (pieza.getVertice(), pieza.getOrientacion ());
        piezaAux.getAislado ().setColumnaElemento (piezaAux.getAislado ().getColumnaElemento () + 1);
        piezaAux.getVertice ().setColumnaElemento (piezaAux.getVertice().getColumnaElemento() + 1);
        piezaAux.getAdyacente ().setColumnaElemento (piezaAux.getAdyacente ().getColumnaElemento () + 1);
        piezaAux.getExtremo ().setColumnaElemento (piezaAux.getExtremo ().getColumnaElemento () + 1);

        if (checkearMovimiento (piezaAux)) {
            return piezaAux;
        }
        else {
            return null;
        }
    }

    public Pieza moverIzquierda (Pieza pieza) {
        Pieza piezaAux = new Pieza (pieza.getVertice(), pieza.getOrientacion ());
        piezaAux.getAislado ().setColumnaElemento (piezaAux.getAislado ().getColumnaElemento () - 1);
        piezaAux.getVertice ().setColumnaElemento (piezaAux.getVertice().getColumnaElemento() - 1);
        piezaAux.getAdyacente ().setColumnaElemento (piezaAux.getAdyacente ().getColumnaElemento () - 1);
        piezaAux.getExtremo ().setColumnaElemento (piezaAux.getExtremo ().getColumnaElemento () - 1);

        if (checkearMovimiento (piezaAux)) {
            return piezaAux;
        }
        else {
            return null;
        }
    }

    public Pieza rotar (Pieza pieza) {
        Pieza piezaAux = new Pieza (pieza.getVertice(), pieza.getOrientacion ());
        String orientacion = piezaAux.getOrientacion();

        switch (orientacion) {
            case "A":
                piezaAux.getAdyacente().setFilaElemento(piezaAux.getAislado().getFilaElemento());
                piezaAux.getAdyacente().setColumnaElemento(piezaAux.getAislado().getColumnaElemento());

                piezaAux.getExtremo().setFilaElemento(piezaAux.getAdyacente().getFilaElemento());
                piezaAux.getExtremo().setColumnaElemento(piezaAux.getAdyacente().getColumnaElemento() + 1);

                piezaAux.getAislado().setFilaElemento(piezaAux.getVertice().getFilaElemento()+1);
                piezaAux.getAislado().setColumnaElemento(piezaAux.getVertice().getColumnaElemento());

                piezaAux.setOrientacion("D");
                break;

            case "B":
                piezaAux.getAdyacente().setFilaElemento(piezaAux.getVertice().getFilaElemento());
                piezaAux.getAdyacente().setColumnaElemento(piezaAux.getVertice().getColumnaElemento()-1);

                piezaAux.getExtremo().setFilaElemento(piezaAux.getAdyacente().getFilaElemento());
                piezaAux.getExtremo().setColumnaElemento(piezaAux.getAdyacente().getColumnaElemento()-1);

                piezaAux.getAislado().setFilaElemento(piezaAux.getVertice().getFilaElemento()-1);
                piezaAux.getAislado().setColumnaElemento(piezaAux.getVertice().getColumnaElemento());

                piezaAux.setOrientacion("I");

                break;

            case "I":
                piezaAux.getAdyacente().setFilaElemento(piezaAux.getVertice().getFilaElemento()-1);
                piezaAux.getAdyacente().setColumnaElemento(piezaAux.getVertice().getColumnaElemento());

                piezaAux.getExtremo().setFilaElemento(piezaAux.getAdyacente().getFilaElemento()-1);
                piezaAux.getExtremo().setColumnaElemento(piezaAux.getAdyacente().getColumnaElemento());

                piezaAux.getAislado().setFilaElemento(piezaAux.getVertice().getFilaElemento());
                piezaAux.getAislado().setColumnaElemento(piezaAux.getVertice().getColumnaElemento()+1);

                piezaAux.setOrientacion("A");

                break;

            case "D":
                piezaAux.getAdyacente().setFilaElemento(piezaAux.getVertice().getFilaElemento()+1);
                piezaAux.getAdyacente().setColumnaElemento(piezaAux.getVertice().getColumnaElemento());

                piezaAux.getExtremo().setFilaElemento(piezaAux.getVertice().getFilaElemento()+1);
                piezaAux.getExtremo().setColumnaElemento(piezaAux.getVertice().getColumnaElemento());

                piezaAux.getAislado().setFilaElemento(piezaAux.getVertice().getFilaElemento());
                piezaAux.getAislado().setColumnaElemento(piezaAux.getVertice().getColumnaElemento()-1);

                piezaAux.setOrientacion("B");

                break;
        }
        if (checkearMovimiento (piezaAux)) {
            return piezaAux;
        }
        else {
            return null;
        }
    }

    //mueve una pieza auxiliar y comprueba cada elemento para ver si ha colisionado
    //true si se puede mover sin colision; si no false
    public boolean checkearMovimiento (Pieza piezaAux) {
        boolean result = true;
        if (getMatriz () [piezaAux.getAislado ().getFilaElemento ()][piezaAux.getAislado ().getColumnaElemento ()].equals ("1") ||
                getMatriz () [piezaAux.getVertice().getFilaElemento()][piezaAux.getVertice().getColumnaElemento()].equals ("1") ||
                getMatriz () [piezaAux.getAdyacente ().getFilaElemento ()][piezaAux.getAdyacente ().getColumnaElemento ()].equals ("1") ||
                getMatriz () [piezaAux.getExtremo ().getFilaElemento ()][piezaAux.getExtremo ().getColumnaElemento ()].equals ("1")) {
            result = false;
        }
        return result;
    }

    /*

        Movimiento: 1 opcion
        1. Crear pieza auxiliar identica a la del nodo que se expande
        2. Relizar el movimiento de la pieza
        3. Comprobar si alguna casilla de la pieza(usando la fila y columna de cada elemento?) se solapa con un muro del tablero. Si coincide con un 1, devuelve false ?
           Teniendo las casillas almacenadas de la pieza
        4.




     */
}

