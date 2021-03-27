import java.io.*;

/**
 * Nombre: Main
 * Esta clase define la ejecución principal del programa
 *
 * @version 1.0
 * @author Jorge Del Castillo Gómez, Eduardo Cano García y Raúl Hormigo Cerón.
 */

public class Main {

    /**
     * Nombre: main
     * @param args
     * @throws IOException
     *
     * Ejecuta lo necesario para permitir que el programa funcione perfectamente.
     *
     * El método no devuelve nada.
     */

    public static void main (String[] args) throws IOException {
        CargarDatos carga = new CargarDatos ();
        carga.CargaDeFichero ("ROTAL1.txt");
        new EscaladaMaxPend (Tablero.getInstance ().getMovil ());
        new PrimeroMejor (Tablero.getInstance ().getMovil ());
    }
}