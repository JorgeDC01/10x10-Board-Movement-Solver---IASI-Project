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

    public void ejecutar () {
        Pieza aux = Tablero.getInstance().moverAbajo (actual.getPieza ());
        actual.anadirHijo (aux, "B");
        nodosGenerados++;

        System.out.println ("Hijos de actual: " + actual.mostrarDatos());
        System.out.println ("Hijos de raiz: " + arbol.getRaiz().mostrarDatos());
    }
}
