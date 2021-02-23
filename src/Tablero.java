import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tablero {
    private static Tablero t;
    private String nombreFichero;
    private String matriz[][];
    private Pieza pieza;
    private Pieza objetivo;

    /*
        Devuelve la pieza que hay que mover por el tablero hasta dar con la solucion
     */
    public Pieza getPieza() {
        return pieza;
    }

    /*
        Devuelve la posicion en la que tiene que debe estar la pieza para acabar
     */
    public Pieza getObjetivo() {
        return objetivo;
    }

    /*
        Constructor por defecto del tablero que se usará. Es único.
     */
    private Tablero(){
        this.nombreFichero = "";
        this.pieza = null;
        this.objetivo = null;
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
                    matriz[indiceFila][indiceColumna] =  casilla;
                    indiceColumna++;
                }
                indiceFila++;
            }
            showLaberinto();
            b.close();
    }
    /*
        Muestra el tablero por pantalla
     */
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
    /*
        Recorre el tablero hasta que encuentra el primer elemento de la pieza. A continuacion, comprueba si es el vértice.
     */
    public void inicializarPieza(String tipoPieza){
        boolean esVertice=false;
        for(int i = 1; i < 9 && !esVertice; i++){
            for(int j = 1; j < 9 && !esVertice; j++){
                if(this.matriz[i][j].equals(tipoPieza)){
                    esVertice = comprobarVertice(i, j, tipoPieza);
                }
            }
        }
        if(esVertice)
            if(tipoPieza.equals("2")){
                pieza.mostrarPieza();
            }
        else{
                objetivo.mostrarPieza();
            }
    }

    /*
        Comprueba si la casilla de la fila i y columna j del tablero es el vertice de la pieza.
        @param i La fila de la casilla a comprobar.
        @param j La columna de la casilla a comprobar.
        @return True si la casilla dada por parametro es el vertice de la pieza y False en caso contrario.
     */
    public boolean comprobarVertice(int i, int j, String tipoPieza) {
       boolean esVertice = true;
       String orientacion;
        if(siEstaVacioOMuro(i,j-1,tipoPieza) && siEstaVacioOMuro(i, j+1,tipoPieza)){
            esVertice = false;
        }
        else if(siEstaVacioOMuro(i-1,j,tipoPieza) && siEstaVacioOMuro(i+1,j,tipoPieza)){
            esVertice = false;
        }

        if(esVertice){
            orientacion = calculoOrientacion(i,j,tipoPieza);
            if(tipoPieza.equals("2"))
            this.pieza = new Pieza(i,j,orientacion);
            else{
                this.objetivo = new Pieza(i,j,orientacion);
            }
        }
        return esVertice;
    }
    /*
        Comprueba si la casilla de fila y columna está vacia, hay un muro o es una casilla de la posicion de la pieza objetivo.
        @param fila La fila de la casilla a comprobar
        @param col La columna de la casilla a comprobar
        @return Un booleano: TRUE si la casilla es 0,1 o 3 y FALSE en caso contrario.
     */
    public boolean siEstaVacioOMuro(int fila, int col, String tipoPieza){
        // Si las casillas de la pieza a buscar es 2, entonces hay que comprobar con los muros.
        String casillasDePieza;
        if(tipoPieza.equals("2")){
            casillasDePieza = "3";
        }
        else{
            casillasDePieza = "2";
        }

        boolean enc = false;
        if(this.matriz[fila][col].equals("0") || this.matriz[fila][col].equals("1") || this.matriz[fila][col].equals(casillasDePieza)){
            enc = true;
        }
        return enc;
    }

    /*
        Calcula la orientacion de la pieza dadas las coordenadas del vertice.
        @param fila La fila del vertice de la pieza L
        @param col La columna del vertice de la pieza L
        @return String La orientacion de la pieza
     */
    public String calculoOrientacion(int fila, int col, String tipoPieza){
        if( dentroRango(fila-2) && this.matriz[fila-2][col].equals(tipoPieza)){
            return "A";
        }
        else if(dentroRango(fila+2) && this.matriz[fila+2][col].equals(tipoPieza)){
            return "B"; // ABAJO
        }
        else if(dentroRango(col-2) && this.matriz[fila][col-2].equals(tipoPieza)){
            return "I";
        }
        else{
            return "D";
        }
    }
    /*
        Comprueba si la casilla de fila y col está dentro o fuera de la matriz.
        @param indice El indice que se va a comprobar si está dentro del rango del tablero
        @return TRUE si está dentro del rango y FALSE en caso contrario
     */
    public boolean dentroRango(int indice){
        if(indice > 0 && indice < 9){
            return true;
        }
        return false;
    }

    public void arriba(){
        if( (pieza.getFila()-1 > 0) && (matriz[pieza.getFila() - 1][pieza.getColumna()] != "1")){
            pieza.setFila(pieza.getFila()-1);
        }
    }

    public void abajo(){
        if( (pieza.getFila()+1 < 9) && (matriz[pieza.getFila() + 1][pieza.getColumna()] != "1")){
            pieza.setFila(pieza.getFila()+1);
        }
    }

    public void derecha(){
        if( (pieza.getColumna()+1 < 9) && (matriz[pieza.getFila()][pieza.getColumna() + 1] != "1")){
            pieza.setColumna(pieza.getColumna()+1);
        }
    }

    public void izquierda(){
        if( (pieza.getColumna()-1 > 0) && (matriz[pieza.getFila()][pieza.getColumna() - 1] != "1")){
            pieza.setColumna(pieza.getColumna()-1);
        }
    }

    public void rotar(){
        if(pieza.getOrientacion() == "A"){
            if((pieza.getColumna()+2 < 9) && (matriz[pieza.getFila()][pieza.getColumna()+2] != "1")
                && (pieza.getFila()+1 < 9) &&(matriz[pieza.getFila()+1][pieza.getColumna()] != "1")){
                matriz[pieza.getFila()][pieza.getColumna()+2] = matriz[pieza.getFila()-2][pieza.getColumna()];
                matriz[pieza.getFila()][pieza.getColumna()+1] = matriz[pieza.getFila()-1][pieza.getColumna()];
                matriz[pieza.getFila()+1][pieza.getColumna()] = matriz[pieza.getFila()][pieza.getColumna()+1];
            }
        }
    }
}

