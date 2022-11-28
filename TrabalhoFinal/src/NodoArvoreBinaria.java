public class NodoArvoreBinaria {
    Produto produto;
    NodoArvoreBinaria esquerda;
    NodoArvoreBinaria direita;
    NodoArvoreBinaria pai;

    public NodoArvoreBinaria(Produto produto){
        this.produto = produto;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
