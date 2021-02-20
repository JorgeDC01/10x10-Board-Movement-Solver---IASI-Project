public class Pieza {

    private int fila;
    private int columna;
    String orientacion;

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
