import java.util.Collections;

public class EscaladaMaxPend {
    private Arbol arbol;
    private NodoArbol actual; //Puntero para recorrer el arbol.
    private int nodosGenerados;

    public EscaladaMaxPend (Pieza pieza) {
        arbol = new Arbol (pieza.clonarPieza());
        actual = arbol.getRaiz();
        nodosGenerados = 1;
        ejecutar ();
    }

    public Arbol getArbol () {
        return arbol;
    }

    public int getNodosGenerados () {
        return nodosGenerados;
    }

    /*
        Expande del nodo actual con todos sus operadores para posteriormente elegir la menor h'
     */
    public void expansionCompleta(){
        NodoArbol hijo = Tablero.getInstance().moverArriba(actual.getPieza());

        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
        hijo = Tablero.getInstance().moverDerecha(actual.getPieza());
        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
        hijo = Tablero.getInstance().moverAbajo(actual.getPieza());
        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
        hijo = Tablero.getInstance().moverIzquierda(actual.getPieza());
        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
        hijo = Tablero.getInstance().rotar(actual.getPieza());
        if(hijo != null){
            hijo.setPadre(actual);
            nodosGenerados++;
            actual.getHijos().add(hijo);
        }
    }

    /*
        Ordena el arrayList de hijos del nodo de menor a mayor según su heuristica
     */

    public void ordenarHijos(){
        Collections.sort(actual.getHijos(), new MenorHeuristica());
    }
    /*

     */
    public void mostrarSolucion(){
        actual = arbol.getRaiz();
        String resultado = "";
        while(actual.getHijos().size() != 0){
            actual = actual.getHijos().get(0);
            resultado = resultado + actual.getOperacion() + ", ";

        }
        System.out.println("Secuencia solucion: " + resultado);
    }

    public void ejecutar () {
        long inicio = System.currentTimeMillis();
        System.out.println("--- Algoritmo Escalada Máxima Pendiente ---");
        boolean finBucle = false;
        while(actual.calcularHeuristica() != 0 && !finBucle){
            expansionCompleta();
            ordenarHijos();
            //Eleccion mejor h'
            actual = actual.getHijos().get(0);
            if(actual.getHeuristica() > actual.getPadre().getHeuristica() || actual == null){
                finBucle = true;
            }
        }
        if(actual.getHeuristica() == 0){
            mostrarSolucion();
            System.out.println("Número de nodos generados: " + getNodosGenerados());
        }
        else{
            System.out.println("No se ha encontrado una solución...");
            System.out.println("Número de nodos generados: " + getNodosGenerados());
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) (fin - inicio);
        System.out.println("Tiempo en ejecutarse Escalada de Maxima pendiente: " + tiempo + " milisegundos.");
    }
}
