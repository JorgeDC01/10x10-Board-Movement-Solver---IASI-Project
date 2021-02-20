import java.io.*;
public class main {
    public static void main(String[] args) throws IOException {
        Tablero.getInstance().CargaDeFichero("ROTAL1.txt");
        Tablero.getInstance().inicializarPieza("2");
        Tablero.getInstance().inicializarPieza("3");
    }
}
