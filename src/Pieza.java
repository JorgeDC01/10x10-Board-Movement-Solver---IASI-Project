public class Pieza {

    private int filaVertice;
    private int columnaVertice;
    private String orientacion;

    // Todas las casillas de la pieza
    private Elemento aislado;
    private Elemento adyacente;
    private Elemento extremo;

    /*
        Devuelve la fila de la matriz donde se encuentra el vertice
     */
    public int getFila() {
        return filaVertice;
    }

    /*
        Establece la nueva fila donde se pone el vertice en la matriz
     */
    public void setFila(int fila) {
        this.filaVertice = fila;
    }

    /*
        Devuelve la columna de la matriz donde se encuentra el vertice
     */
    public int getColumna() {
        return columnaVertice;
    }

    /*
        Establece la nueva columna donde se pone el vertice en la matriz
     */
    public void setColumna(int columna) {
        this.columnaVertice = columna;
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
    public Pieza(int filaVertice, int columnaVertice, String orientacion){
        this.filaVertice = filaVertice;
        this.columnaVertice = columnaVertice;
        this.orientacion = orientacion;
    }

    /*
        Muestra la pieza por pantalla
     */
    public void mostrarPieza(){
        System.out.println(filaVertice + " - " + columnaVertice + " -  " + orientacion);
    }

}
