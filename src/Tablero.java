import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tablero {
    private static Tablero t;
    String nombreFichero;
    private String matriz[][];

    /*
        Constructor por defecto del tablero que se usará. Es único.
     */
    private Tablero(){
        this.nombreFichero = "";
        matriz = new String[10][10];
    }
    /*
        Devyelve el tablero único. Si no ha sido creado, llama al constructor privado. SINGLETON.
        @return El objeto tablero único.
     */
    public static Tablero getInstance(){
        if(t == null){
            t = new Tablero();
        }
            return t;
    }
    /*
        Almacena el nombre del fichero elegido para ejecutar los algoritmos en el objeto tablero, añadiéndole la ruta Ficheros/...
        @param nombreFichero El nombre del fichero.
     */
    public void setNombreFichero(String nombreFichero){ this.nombreFichero = "Ficheros/" + nombreFichero; }
    /*
        Devuelve el nombre de la ruta del fichero donde está descrito el laberinto.
        @return La ruta del fichero del laberinto a cargar.
     */
    public String getNombreFichero(){ return this.nombreFichero;}
    /*
        Carga el nombre del fichero que contiene el laberinto en una matriz de strings.
        @param fichero El nombre del fichero como un string.
     */
    public  void CargaDeFichero(String fichero) throws IOException {
            setNombreFichero(fichero);
            String linea;
            FileReader f = new FileReader(getNombreFichero());
            BufferedReader b = new BufferedReader(f);
            String[] vector;
            int indiceFila = 0;
            while((linea = b.readLine()) != null && (indiceFila <= 9)) {
                int indiceColumna = 0;
                vector = linea.split(",");
                for(String casilla: vector){
                    matriz[indiceFila][indiceColumna] = casilla;
                    indiceColumna++;
                }
                indiceFila++;
            }
            showLaberinto();
            b.close();
    }
    public void showLaberinto(){
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {
                stringbuilder.append(matriz[i][j]);
            }
            stringbuilder.append("\n");
        }
        System.out.println(stringbuilder.toString());
    }
}

