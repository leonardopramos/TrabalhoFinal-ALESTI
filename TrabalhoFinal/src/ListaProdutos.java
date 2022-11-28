public class ListaProdutos {
    private NodoProdutos inicio;
    private NodoProdutos fim;
    private int quantidade;
    private int quantidadeOperacoes;

    public ListaProdutos(){
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    public void adicionar(Produto p){
        NodoProdutos nodo = new NodoProdutos(p);
        this.quantidade++;
        if(this.inicio == null){
            this.inicio = nodo;
            this.fim = nodo;
            return;
        }
        NodoProdutos antigoFim = this.fim;
        this.fim = nodo;
        antigoFim.proximo = this.fim;
    }

    public void adicionar(Produto produto, int posicao){
        if(posicao < 0 || posicao >= this.quantidade){
            throw new IndexOutOfBoundsException();
        }
        NodoProdutos nodo = new NodoProdutos(produto);
        if(posicao == 0){
            nodo.proximo = this.inicio;
            this.inicio = nodo;
            this.quantidade++;
            return;
        }

        if(posicao == this.quantidade - 1){
            this.adicionar(produto);
            return;
        }

        NodoProdutos aux = this.inicio;
        for(int i = 0; i < posicao - 1; i++){
            aux = aux.proximo;
        }
        nodo.proximo = aux.proximo;
        aux.proximo = nodo;
        this.quantidade++;
        return;
    }

    public Produto removePelaPosicao(int posicao){
        NodoProdutos aux = this.inicio;
        NodoProdutos elemento;
        if(posicao == 0){
            this.inicio = aux.proximo;
            elemento = aux;
            aux = null;
            this.quantidade--;
            return elemento.elemento;
        }
        for(int i = 0; i < posicao - 1; i++){
            aux = aux.proximo;
        }
        this.quantidade--;
        elemento = aux.proximo;
        aux.proximo = aux.proximo.proximo;
        return elemento.elemento;
    }

    public Produto remove(Produto elemento){
        int index = this.retornaPosicao(elemento);
        return this.removePelaPosicao(index);
    }

    public int tamanho(){
        return this.quantidade;
    }

    public Produto get(int posicao){
        NodoProdutos aux = this.inicio;
        for(int i = 0; i < posicao; i++){
            aux = aux.proximo;
            quantidadeOperacoes++;
        }
        return aux.elemento;
    }

    public int retornaPosicao(Produto elemento){
        int posicao = 0;
        NodoProdutos aux = this.inicio;
        while(true){
            if(aux == null){
                return -1;
            }

            if(aux.elemento == elemento){
                break;
            }

            aux = aux.proximo;
            posicao++;
        }

        return posicao;
    }

    public boolean vazia(){
        return this.quantidade == 0;
    }

    public boolean contem(int id){
        NodoProdutos aux = this.inicio;
        while(true){
            if(aux == null){
                return false;
            }

            if(aux.elemento.getCodigo() == id){
                break;
            }

            aux = aux.proximo;
        }

        return true;
    }

    public void escreve(int posicao, Produto produto){
        NodoProdutos aux = this.inicio;
        for(int i = 0; i < posicao; i++){
            aux = aux.proximo;
        }
        aux.elemento = produto;
    }

    public void limpa(){
        NodoProdutos aux = this.inicio;
        while(true){
            if(aux == null){
                break;
            }
            this.remove(aux.elemento);
            aux = aux.proximo;
        }
    }
    public int getQuantidadeOperacoes() {
        return quantidadeOperacoes;
    }

    @Override
    public String toString() {
        String aux = "[ ";
        NodoProdutos paux = inicio;
        while (paux != null) {
            aux = aux + paux.elemento + " ";
            paux = paux.proximo; // avanca para proximo novo
        }
        aux += "]";
        return aux;
    }
}