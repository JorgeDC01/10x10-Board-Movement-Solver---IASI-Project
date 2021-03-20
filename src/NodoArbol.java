import java.util.ArrayList;
import java.util.List;

public class NodoArbol {
    private Pieza pieza;
    private int heuristica;
    private NodoArbol padre;
    private String operacion;
    private List <NodoArbol> hijos;


    /*
        Constructor parametrizado dada la pieza y el estado padre.
        @param pieza La pieza que representa el estado.
        @param padre El estado padre del estado.
     */

    public NodoArbol (Pieza pieza, NodoArbol padre, String operacion){
        this.pieza = pieza;
        this.heuristica = calcularHeuristica ();
        this.padre = padre;
        this.hijos = new ArrayList <NodoArbol> ();
        this.operacion = operacion;
    }


    /*
        Devuelve la pieza del nodo.
        @return La pieza.
     */

    public Pieza getPieza(){
        return pieza;
    }


    /*
        Devuelve los hijos del estado actual.
        @return Lista de hijos
     */

    public List<NodoArbol> getHijos(){
        return hijos;
    }

    /*
        Set de los hijos del nodo actual
        @param listaHijos Una lista de hijos
     */

    public void setHijos(List<NodoArbol> listaHijos){
        this.hijos = listaHijos;
    }

    /*
        Devuelve el estado padre del nodo.
        @return nodoArbol El nodo padre.
     */

    public NodoArbol getPadre(){
        return padre;
    }

    /*
        Enlaza el nodo actual con su padre.
        @param padre El nodo padre
     */

    public void setPadre(NodoArbol padre){
        this.padre = padre;
    }
    /*
        Devuelve la heurística del estado con respecto el estado objetivo.
        @return int La heurística que indica la proximidad con respecto el estado objetivo.
     */

    public int getHeuristica(){
        return heuristica;
    }


    /**
     * Calcula el valor de la heurística del nodo.
     * @return int el valor de h'
     */

    public int calcularHeuristica () {
        int filaObjetivo = Tablero.getInstance().getObjetivo ().getVertice ().getFilaElemento ();
        int columnaObjetivo = Tablero.getInstance().getObjetivo().getVertice().getColumnaElemento();
        int filaInicio = pieza.getVertice().getFilaElemento();
        int columnaInicio = pieza.getVertice().getColumnaElemento();

        int rotaciones = 0;
        boolean enc = false;
        for (int i = 0; (i < 4) && (!enc); i++) {
            if (pieza.getOrientacion ().equals (Tablero.getInstance().getObjetivo ().getOrientacion())) {
                enc = true;
                if (rotaciones > 0) {
                    for (int j = 0; j < (4 - rotaciones); j++) {
                        tickRotacion();
                    }
                }
            }
            else {
                tickRotacion();
                rotaciones++;
            }
        }
        return (Math.abs (filaObjetivo - filaInicio) + Math.abs (columnaObjetivo - columnaInicio) + rotaciones);
    }

    public void tickRotacion () {
        switch (pieza.getOrientacion()) {
            case "A":
                pieza.setOrientacion ("D");
                break;
            case "B":
                pieza.setOrientacion ("I");
                break;
            case "I":
                pieza.setOrientacion ("A");
                break;
            case "D":
                pieza.setOrientacion ("B");
                break;
        }
    }

    public String getOperacion () {
        return operacion;
    }

    public String mostrarDatos () {
        String resultado = "Hijos: ";
        if (getHijos ().size() != 0) {
            for (NodoArbol n: getHijos()) {
                resultado = resultado + n.operacion + " - ";
            }
        }
        else {
            resultado = "No hijos";
        }
        return resultado;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 7 * result +this.getPieza().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof NodoArbol)) {
            return false;
        } else {
            NodoArbol other = (NodoArbol) obj;
            return getPieza().equals(other.getPieza());
        }
    }
}
