import java.io.*;
public class main {
    public static void main(String[] args) throws IOException {
        CargarDatos carga = new CargarDatos();
        carga.CargaDeFichero("ROTAL1.txt");
        carga.inicializarPieza("2");

        System.out.println("\n");
        Tablero.getInstance().rotar();
        Tablero.getInstance().getPieza().mostrarPieza();
        System.out.println("\n");
        Tablero.getInstance().moverAbajo();
        Tablero.getInstance().getPieza().mostrarPieza();
    }

}
