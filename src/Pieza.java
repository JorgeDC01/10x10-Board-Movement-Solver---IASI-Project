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

    public Elemento getAislado () {
        return aislado;
    }

    public Elemento getAdyacente () {
        return adyacente;
    }

    public Elemento getExtremo () {
        return extremo;
    }

    /*
        Inicializa la pieza con la posicion inicial en el tablero
    */
    public Pieza(int filaVertice, int columnaVertice, String orientacion){
        this.filaVertice = filaVertice;
        this.columnaVertice = columnaVertice;
        this.orientacion = orientacion;
        aislado = new Elemento();
        adyacente = new Elemento();
        extremo = new Elemento();

        switch(orientacion){
            case "A":
                aislado.setFilaElemento(getFila());
                aislado.setColumnaElemento(getColumna()+1);
                adyacente.setFilaElemento(getFila()-1);
                adyacente.setColumnaElemento(getColumna());
                extremo.setFilaElemento(getFila()-2);
                extremo.setColumnaElemento(getColumna());
                break;
            case "B":
                aislado.setFilaElemento(getFila());
                aislado.setColumnaElemento(getColumna()-1);
                adyacente.setFilaElemento(getFila()+1);
                adyacente.setColumnaElemento(getColumna());
                extremo.setFilaElemento(getFila()+2);
                extremo.setColumnaElemento(getColumna());
                break;
            case "D":
                aislado.setFilaElemento(getFila()+1);
                aislado.setColumnaElemento(getColumna());
                adyacente.setFilaElemento(getFila());
                adyacente.setColumnaElemento(getColumna()+1);
                extremo.setFilaElemento(getFila());
                extremo.setColumnaElemento(getColumna()+2);
                break;
            case "I":
                aislado.setFilaElemento(getFila()-1);
                aislado.setColumnaElemento(getColumna());
                adyacente.setFilaElemento(getFila());
                adyacente.setColumnaElemento(getColumna()-1);
                extremo.setFilaElemento(getFila());
                extremo.setColumnaElemento(getColumna()-2);
                break;
        }
    }

    /*
        Muestra la pieza por pantalla
     */
    public void mostrarPieza(){
        System.out.println("VERTICE: "+filaVertice + " - " + columnaVertice + " -  " + orientacion);
        System.out.println("AISLADO: "+aislado.getFilaElemento() + " - " + aislado.getColumnaElemento());
        System.out.println("ADYACENTE: "+adyacente.getFilaElemento() + " - " + adyacente.getColumnaElemento());
        System.out.println("EXTREMO: "+extremo.getFilaElemento() + " - " + extremo.getColumnaElemento());
    }

}
