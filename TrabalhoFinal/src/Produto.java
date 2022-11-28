public class Produto {

    private int codigo;
    private String nome;
    private String tamanho;
    private double valor;
    
    public Produto(int codigo, String nome, String tamanho, double valor){
        this.codigo = codigo;
        this.nome = nome;
        this.tamanho = tamanho;
        this.valor = valor;
    }
    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }
    public String getTamanho() {
        return tamanho;
    }
    public double getValor() {
        return valor;
    }
    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", nome=" + nome + ", tamanho=" + tamanho + ", valor=" + valor + "]";
    }
}
