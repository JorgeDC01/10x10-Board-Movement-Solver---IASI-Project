public class Elemento {

    private int filaElemento;
    private int columnaElemento;

    public Elemento(){
        this.filaElemento = 0;
        this.columnaElemento = 0;
    }
    public Elemento(int filaElemento, int columnaElemento){
        this.filaElemento = filaElemento;
        this.columnaElemento = columnaElemento;
    }
    public int getFilaElemento(){return this.filaElemento;}
    public int getColumnaElemento(){return this.columnaElemento;}
    public void setFilaElemento(int filaElemento) { this.filaElemento = filaElemento; }
    public void setColumnaElemento(int columnaElemento) { this.columnaElemento = columnaElemento; }

}
