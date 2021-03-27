import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Nombre: CargarDatos
 * Esta clase lee del fichero de entrada e inicializa las instancias del Tablero.
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class CargarDatos {
    private String nombreFichero;

    /**
     * Nombre: CargarDatos
     * Constructor por defecto de la clase.
     */

    public CargarDatos () {
        nombreFichero = "";
    }


    /**
     * Nombre: setNombreFichero
     * @param nombreFichero el nombre del fichero.
     *
     * Almacena el nombre del fichero elegido para ejecutar los algoritmos en el objeto Tablero,
     * añadiéndole la ruta "Ficheros/..."
     *
     * El método no devuelve nada.
     */

    public void setNombreFichero (String nombreFichero) {
        this.nombreFichero = "Ficheros/" + nombreFichero;
    }


    /**
     * Nombre: getNombreFichero
     * @return String
     *
     * Devuelve el nombre de la ruta del fichero donde están escritos los datos de entrada.
     *
     * El String devuelto es el nombre del fichero.
     */

    public String getNombreFichero () {
        return nombreFichero;
    }


    /**
     * Nombre: cargaDeFichero
     * @param nombreFichero es el nombre del fichero a leer.
     * @throws IOException
     *
     * Carga el nombre del fichero que contiene el laberinto en una matriz de String.
     *
     * Este método no devuelve nada.
     */
    public void cargaDeFichero (String nombreFichero) throws IOException {
        System.out.println ("FICHERO - " + nombreFichero);
        setNombreFichero (nombreFichero);
        String linea = "";
        FileReader f = new FileReader (getNombreFichero ());
        BufferedReader b = new BufferedReader (f);
        String [] vector;
        int indiceFila = 0;

        while ((linea = b.readLine()) != null && (indiceFila <= 9)) {
            int indiceColumna = 0;
            vector = linea.split (",");
            for (String casilla: vector) {
                Tablero.getInstance ().getMatriz () [indiceFila][indiceColumna] =  casilla;
                indiceColumna++;
            }
            indiceFila++;
        }
        b.close ();
        Tablero.getInstance ().showLaberinto ();
        inicializarPieza ("2");
        inicializarPieza ("3");
    }


    /**
     * Nombre: inicializarPieza.
     * @param tipoPieza el carácter que indica el tipo de Pieza: "2" es la Pieza móvil, "3" es la Pieza objetivo.
     *
     * Encuentra e inicializa las Piezas del Tablero con los datos correspondientes.
     *
     * Este método no devuelve nada.
     */

    public void inicializarPieza (String tipoPieza) {
        boolean esVertice = false;
        for (int i = 1; i < 9 && !esVertice; i++) {
            for (int j = 1; j < 9 && !esVertice; j++) {
                if (Tablero.getInstance ().getMatriz () [i][j].equals (tipoPieza)){
                    esVertice = insertarVerticeEnPieza (i, j, tipoPieza);
                }
            }
        }

        if (esVertice)
            if (tipoPieza.equals ("2")){
                System.out.println ("Pieza origen...");
                Tablero.getInstance ().getMovil ().mostrarPieza ();
            }
            else{
                System.out.println ("Pieza objetivo...");
                Tablero.getInstance ().getObjetivo ().mostrarPieza ();
            }
    }


    /**
     * Nombre: insertarVerticeEnPieza
     * @return boolean
     * @param i la fila de la casilla.
     * @param j la columna de la casilla.
     * @param tipoPieza el tipo de Pieza a generar: "2" si es la móvil, "3" si es la objetivo.
     *
     * Indica si la casilla indicada es el vértice o no, y crea la Pieza en caso de que así lo sea.
     *
     * El boolean indica "True" si la casilla es el vértice, o "False" si no lo es.
     */

    public boolean insertarVerticeEnPieza (int i, int j, String tipoPieza) {
        boolean esVertice = true;
        String orientacion;
        if(Tablero.getInstance ().siEstaVacioOMuro (i,j-1,tipoPieza) &&
                Tablero.getInstance ().siEstaVacioOMuro (i, j+1,tipoPieza)) {
            esVertice = false;
        }
        else if (Tablero.getInstance ().siEstaVacioOMuro (i-1,j,tipoPieza) &&
                Tablero.getInstance ().siEstaVacioOMuro (i+1,j,tipoPieza)) {
            esVertice = false;
        }

        if (esVertice) {
            orientacion = calculoOrientacion (i,j,tipoPieza);
            if (tipoPieza.equals ("2")) {
                Tablero.getInstance ().setMovil (new Pieza (new Elemento (i, j), orientacion));
            }
            else{
                Tablero.getInstance ().setObjetivo (new Pieza (new Elemento (i, j), orientacion));
            }
        }
        return esVertice;
    }


    /**
     * Nombre: calculoOrientacion
     * @return String
     * @param fila la fila del vértice.
     * @param col la columna del vértice.
     * @param tipoPieza el tipo de Pieza sobre la que se calcula la orientación: "2" si es la móvil, "3" si es la objetivo.
     *
     * Calcula la orientación de la Pieza dadas las coordenadas del vértice.
     *
     * El String indica el carácter que expresa la orientación de la Piza: "A" si es arriba, "B" si es abajo,
     *                  "I" si es izquierda o "D" si es derecha.
     */

    public String calculoOrientacion (int fila, int col, String tipoPieza) {
        if (Tablero.getInstance ().dentroRango (fila-2) && Tablero.getInstance ().getMatriz () [fila-2][col].equals (tipoPieza)) {
            return "A";
        }
        else if (Tablero.getInstance ().dentroRango (fila+2) && Tablero.getInstance ().getMatriz () [fila+2][col].equals (tipoPieza)) {
            return "B"; // ABAJO
        }
        else if (Tablero.getInstance ().dentroRango (col-2) && Tablero.getInstance ().getMatriz () [fila][col-2].equals (tipoPieza)) {
            return "I";
        }
        else{
            return "D";
        }
    }
}