public class ArvoreProduto {
    private int contador;
    private NodoArvoreBinaria raiz;
    private int operacoesBusca;

    public ArvoreProduto() {
        contador = 0;
        raiz = null;
    }

    public NodoArvoreBinaria getRaiz() {
        return raiz;
    }

    public void limpar() {
        contador = 0;
        raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public int size() {
        return contador;
    }

    public void preOrder() {
        preOrder(raiz);
    }

    private void preOrder(NodoArvoreBinaria node) {
        if (node == null) {
            return;
        }
        System.out.printf("%s ", node.produto.getCodigo());
        preOrder(node.esquerda);
        preOrder(node.direita);
    }

    public ListaProdutos caminharPreOrdem() {
        ListaProdutos lista = new ListaProdutos();
        preOrdemRecursivo(lista, raiz);
        return lista;
    }

    public void preOrdemRecursivo(ListaProdutos caminho, NodoArvoreBinaria nodo) {
        caminho.adicionar(nodo.produto);
        if (nodo.esquerda != null) {
            preOrdemRecursivo(caminho, nodo.esquerda);
        }
        if (nodo.direita != null) {
            preOrdemRecursivo(caminho, nodo.direita);
        }
    }

    public Produto get(int posicao, NodoArvoreBinaria nodo) {
        while (nodo != null && nodo.produto.getCodigo() != posicao) {
            operacoesBusca++;
            nodo = posicao < nodo.produto.getCodigo() ? nodo.esquerda : nodo.direita;
        }
        return nodo.produto;
    }

    public void add(Produto p) {
        NodoArvoreBinaria aux = new NodoArvoreBinaria(p);
        contador++;

        if (raiz == null) {
            raiz = aux;
            return;
        }

        NodoArvoreBinaria pai = raiz;
        boolean adicionou = false;

        while (!adicionou) {
            if (aux.produto.getCodigo() <= pai.produto.getCodigo()) {
                if (pai.esquerda == null) {
                    pai.esquerda = aux;
                    aux.pai = pai;
                    adicionou = true;
                } else
                    pai = pai.esquerda;
            } else {
                if (pai.direita == null) {
                    pai.direita = aux;
                    aux.pai = pai;
                    adicionou = true;
                } else
                    pai = pai.direita;
            }
        }
    }

    public ListaProdutos preorder(){
        ListaProdutos lista = new ListaProdutos();
        preorderRec(raiz, lista);
        return lista;
    }

    public void preorderRec(NodoArvoreBinaria node, ListaProdutos lista) {
        if (node == null)
          return;
          preorderRec(node.direita, lista);
        // traverse the left child
        preorderRec(node.esquerda, lista);
        // traverse the right child
        
        lista.adicionar(node.produto);

      }

    public boolean contem(int id) {
        ListaProdutos aux = preorder();
        while (true) {
            if (aux == null) {
                return false;
            }

            if (aux.contem(id)) {
                break;
            }
            return false;
        }
        return true;
    }

    public int getOperacoesBusca() {
        return operacoesBusca;
    }

    public int alturaArvore(NodoArvoreBinaria raiz) {
        if (raiz == null) {
            return -1;
        }
        return max(alturaArvore(raiz.esquerda), alturaArvore(raiz.direita)) + 1;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}