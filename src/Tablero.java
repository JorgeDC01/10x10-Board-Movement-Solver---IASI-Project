import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tablero {
    private static Tablero t;
    private String matriz[][];
    private Pieza pieza;
    private Pieza objetivo;
    /*
        Asigna la pieza que se mueve al tablero.
        @param pieza La pieza que se asignará.
     */
    public void setPieza(Pieza pieza){ this.pieza = pieza; }
    /*
        Asigna la pieza objetivo al tablero.
        @param pieza La pieza que se asignará.
     */
    public void setObjetivo(Pieza pieza){ this.objetivo = pieza; }
    /*
        Devuelve la pieza que hay que mover por el tablero hasta dar con la solucion
     */
    public Pieza getPieza() {
        return pieza;
    }
    /*
        Devuelve la posicion en la que tiene que debe estar la pieza para acabar
     */
    public Pieza getObjetivo() {
        return objetivo;
    }
    /*
       Devuelve el tablero como matriz
       @return matriz de enteros como tablero
    */
    public String[][] getMatriz(){ return this.matriz; }
    /*
        Constructor por defecto del tablero que se usará. Es único.
     */
    private Tablero(){
        this.pieza = null;
        this.objetivo = null;
        matriz = new String[10][10];
    }

    /*
        Devyelve el tablero único. Si no ha sido creado, llama al constructor privado. SINGLETON.
        @return El objeto tablero único.
     */
    public static Tablero getInstance(){
        if(t == null){
            t = new Tablero();
        }
            return t;
    }

    /*
        Muestra el tablero por pantalla
     */
    public void showLaberinto(){
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
    // ------------------------------------------------- CODIGO QUE SE VERÁ EL SÁBADO ---------------------------------------------------------- /
    public void arriba(){
        String movimiento = "arriba";
        Pieza aux = new Pieza(getPieza().getFila()+1,getPieza().getColumna(),getPieza().getOrientacion());
        if(checkeoMovimiento(movimiento, aux)){

        }
        /*if( (pieza.getFila()-1 > 0) && (matriz[pieza.getFila() - 1][pieza.getColumna()] != "1")){
            pieza.setFila(pieza.getFila()-1);
        }
         */
    }

    public void abajo(){
        if( (pieza.getFila()+1 < 9) && (matriz[pieza.getFila() + 1][pieza.getColumna()] != "1")){
            pieza.setFila(pieza.getFila()+1);
        }
    }

    public void derecha(){
        if( (pieza.getColumna()+1 < 9) && (matriz[pieza.getFila()][pieza.getColumna() + 1] != "1")){
            pieza.setColumna(pieza.getColumna()+1);
        }
    }

    public void izquierda(){
        if( (pieza.getColumna()-1 > 0) && (matriz[pieza.getFila()][pieza.getColumna() - 1] != "1")){
            pieza.setColumna(pieza.getColumna()-1);
        }
    }

    public void rotar(){
        if(pieza.getOrientacion() == "A"){
            if((pieza.getColumna()+2 < 9) && (matriz[pieza.getFila()][pieza.getColumna()+2] != "1")
                && (pieza.getFila()+1 < 9) &&(matriz[pieza.getFila()+1][pieza.getColumna()] != "1")){
                matriz[pieza.getFila()][pieza.getColumna()+2] = matriz[pieza.getFila()-2][pieza.getColumna()];
                matriz[pieza.getFila()][pieza.getColumna()+1] = matriz[pieza.getFila()-1][pieza.getColumna()];
                matriz[pieza.getFila()+1][pieza.getColumna()] = matriz[pieza.getFila()][pieza.getColumna()+1];
            }
        }
    }
    public boolean checkeoMovimiento(String movimiento, Pieza aux){
        switch(getPieza().getOrientacion()){
            case "A":
                // metodo
                break;
            case "D":
                break;
            case "B":
                break;
            case "I":
                break;
        }
        return true;
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

