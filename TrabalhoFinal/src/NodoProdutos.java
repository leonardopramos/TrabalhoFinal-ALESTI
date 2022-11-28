public class NodoProdutos{
    public Produto elemento;
    public NodoProdutos proximo;

    public NodoProdutos(Produto p){
        this.elemento = p;
        this.proximo = null;
    }
}