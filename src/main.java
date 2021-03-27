import java.io.*;
public class main {
    public static void main(String[] args) throws IOException {
        CargarDatos carga = new CargarDatos();
        carga.CargaDeFichero("ROTAL1.txt");
        new EscaladaMaxPend(Tablero.getInstance().getPieza());
        new PrimeroMejor(Tablero.getInstance().getPieza());
    }
}
