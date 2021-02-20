public class Pieza {

    private int fila;
    private int columna;
    String orientacion;

    /*
        Devuelve la fila de la matriz donde se encuentra el vertice
     */
    public int getFila() {
        return fila;
    }

    /*
        Establece la nueva fila donde se pone el vertice en la matriz
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /*
        Devuelve la columna de la matriz donde se encuentra el vertice
     */
    public int getColumna() {
        return columna;
    }

    /*
        Establece la nueva columna donde se pone el vertice en la matriz
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /*
        Devuelve la orientacion que tiene la pieza
     */
    public String getOrientacion() {
        return orientacion;
    }

    /*
        Establece la orientacion de la pieza
     */
    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    /*
        Inicializa la pieza con la posicion inicial en el tablero
    */
    public Pieza(int fila, int columna, String orientacion){
        this.fila = fila;
        this.columna = columna;
        this.orientacion = orientacion;
    }

    /*
        Muestra la pieza por pantalla
     */
    public void mostrarPieza(){
        System.out.println(fila + " - " + columna + " -  " + orientacion);
    }

}
