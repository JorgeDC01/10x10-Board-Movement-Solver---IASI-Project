import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase lee del fichero de entrada e inicializa las instancias del tablero.
 */

public class CargarDatos {
    private String nombreFichero;


    /**
     * Constructor por defecto de la clase.
     */

    public CargarDatos () {
        nombreFichero = "";
    }

    /**
     * Almacena el nombre del fichero elegido para ejecutar los algoritmos en el objeto tablero, añadiéndole la ruta Ficheros/...
     * @param nombreFichero el nombre del fichero
     */

    public void setNombreFichero (String nombreFichero) {
        this.nombreFichero = "Ficheros/" + nombreFichero;
    }

    /**
     * Devuelve el nombre de la ruta del fichero donde están escritos los datos de entrada.
     * @return String el nombre del fichero
     */

    public String getNombreFichero () {
        return nombreFichero;
    }


    /**
     * Carga el nombre del fichero que contiene el laberinto en una matriz de String.
     * @param nombreFichero es el nombre del fichero a leer.
     * @throws IOException
     */
    public  void CargaDeFichero (String nombreFichero) throws IOException {

        System.out.println("FICHERO - " + nombreFichero);
        setNombreFichero(nombreFichero);
        String linea = "";
        FileReader f = new FileReader (getNombreFichero());
        BufferedReader b = new BufferedReader(f);
        String[] vector;
        int indiceFila = 0;

        while((linea = b.readLine()) != null && (indiceFila <= 9)) {
            int indiceColumna = 0;
            vector = linea.split(",");
            for(String casilla: vector){
                Tablero.getInstance().getMatriz()[indiceFila][indiceColumna] =  casilla;
                indiceColumna++;
            }
            indiceFila++;
        }
        b.close();
        Tablero.getInstance().showLaberinto();
        inicializarPieza("2");
        inicializarPieza("3");
    }


    /**
     * Recorre el tablero hasta que encuentra el primer elemento de la pieza. A continuacion, comprueba si es el vértice llamando a
     *         comprobarVertice. En caso afirmativo, muestra la pieza por pantalla.
     * @param tipoPieza el número de las casillas de la pieza a inicializar y almacenar en el tablero. "2" si es la pieza en movimiento y "3" si es la objetivo.
     */

    public void inicializarPieza (String tipoPieza) {
        boolean esVertice = false;
        for(int i = 1; i < 9 && !esVertice; i++){
            for(int j = 1; j < 9 && !esVertice; j++){
                if(Tablero.getInstance().getMatriz()[i][j].equals(tipoPieza)){
                    esVertice = insertarVerticeEnPieza(i, j, tipoPieza);
                }
            }
        }
        // Cargar los elementos de la pieza.

        if(esVertice)
            if(tipoPieza.equals("2")){
                System.out.println("Pieza origen...");
                Tablero.getInstance().getPieza().mostrarPieza();
            }
            else{
                System.out.println("Pieza objetivo...");
                Tablero.getInstance().getObjetivo().mostrarPieza();
            }
    }

    /*
        Comprueba si la casilla de la fila i y columna j del tablero es el vertice de la pieza. En caso afirmativo, inicializa la pieza y la almacena en el tablero.
        @param i La fila de la casilla a comprobar.
        @param j La columna de la casilla a comprobar.
        @param tipoPieza La pieza en la que se encuentra la casilla (i,j).
        @return True si la casilla dada por parametro es el vertice de la pieza y False en caso contrario.
     */
    public boolean insertarVerticeEnPieza(int i, int j, String tipoPieza) {
        boolean esVertice = true;
        String orientacion;
        if(Tablero.getInstance().siEstaVacioOMuro(i,j-1,tipoPieza) && Tablero.getInstance().siEstaVacioOMuro(i, j+1,tipoPieza)){
            esVertice = false;
        }
        else if(Tablero.getInstance().siEstaVacioOMuro(i-1,j,tipoPieza) && Tablero.getInstance().siEstaVacioOMuro(i+1,j,tipoPieza)){
            esVertice = false;
        }

        if(esVertice){
            orientacion = calculoOrientacion(i,j,tipoPieza);
            if(tipoPieza.equals("2")) {
                Tablero.getInstance().setPieza(new Pieza(new Elemento (i, j),orientacion));
            }
            else{
                Tablero.getInstance().setObjetivo(new Pieza(new Elemento (i, j),orientacion));
            }
        }
        return esVertice;
    }
    /*
        Calcula la orientacion de la pieza dadas las coordenadas del vertice.
        @param fila La fila del vertice de la pieza L
        @param col La columna del vertice de la pieza L
        @param tipoPieza La pieza en la que se encuentra el vertice.
        @return String La orientacion de la pieza
     */
    public String calculoOrientacion(int fila, int col, String tipoPieza){
        if( Tablero.getInstance().dentroRango(fila-2) && Tablero.getInstance().getMatriz()[fila-2][col].equals(tipoPieza)){
            return "A";
        }
        else if(Tablero.getInstance().dentroRango(fila+2) && Tablero.getInstance().getMatriz()[fila+2][col].equals(tipoPieza)){
            return "B"; // ABAJO
        }
        else if(Tablero.getInstance().dentroRango(col-2) && Tablero.getInstance().getMatriz()[fila][col-2].equals(tipoPieza)){
            return "I";
        }
        else{
            return "D";
        }
    }
}
