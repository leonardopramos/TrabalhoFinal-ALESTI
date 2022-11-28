import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {

        ListaProdutos lst = new ListaProdutos();
        ArvoreProduto ap = new ArvoreProduto();
        
        File arquivoCSV50 = new File("A:/Documentos/Faculdade/2 Semestre/ALESTI/TrabalhoFinal/Produtos_50.csv");
        File arquivoCSV1000 = new File("A:/Documentos/Faculdade/2 Semestre/ALESTI/TrabalhoFinal/Produtos_1000.csv");
        File arquivoCSV10000 = new File("A:/Documentos/Faculdade/2 Semestre/ALESTI/TrabalhoFinal/Produtos_10000.csv");
        File arquivoCSV100000 = new File("A:/Documentos/Faculdade/2 Semestre/ALESTI/TrabalhoFinal/Produtos_100000.csv");

        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------TRABALHO 3 - ALESTI --------------------" + "\n");
        System.out.println("Indique o arquivo que deseja ser lido: " + "\n");
        System.out.println("1. Produtos_50.csv");
        System.out.println("2. Produtos_1000.csv");
        System.out.println("3. Produtos_10000.csv");
        System.out.println("4. Produtos_100000.csv" + "\n");
        System.out.print("Arquivo escolhido: ");
        int produtoEscolhido = sc.nextInt();
        
        System.out.println();

        switch(produtoEscolhido){
            case 1:
                try{
                    String linhas = new String();
                    Scanner sc1 = new Scanner(arquivoCSV50);
                    sc1.nextLine();
                    while(sc1.hasNext()){
                        linhas = sc1.nextLine();
                        String[] aux = linhas.split(",");
                        lst.adicionar(new Produto(Integer.parseInt(aux[0]), aux[1], aux[2], Double.parseDouble(aux[3])));
                        ap.add(new Produto(Integer.parseInt(aux[0]), aux[1], aux[2], Double.parseDouble(aux[3])));
                    }
                }catch(FileNotFoundException e){
                        System.out.println("Arquivo não encontrado");
                }
                break;
            case 2:
                try{
                    String linhas = new String();
                    Scanner sc1 = new Scanner(arquivoCSV1000);
                    sc1.nextLine();
                    while(sc1.hasNext()){
                        linhas = sc1.nextLine();
                        String[] aux = linhas.split(",");
                        lst.adicionar(new Produto(Integer.parseInt(aux[0]), aux[1], aux[2], Double.parseDouble(aux[3])));
                        ap.add(new Produto(Integer.parseInt(aux[0]), aux[1], aux[2], Double.parseDouble(aux[3])));
                    }
                }catch(FileNotFoundException e){
                        System.out.println("Arquivo não encontrado");
                }
                break;
            case 3:
                try{
                    String linhas = new String();
                    Scanner sc1 = new Scanner(arquivoCSV10000);
                    sc1.nextLine();
                    while(sc1.hasNext()){
                        linhas = sc1.nextLine();
                        String[] aux = linhas.split(",");
                        lst.adicionar(new Produto(Integer.parseInt(aux[0]), aux[1], aux[2], Double.parseDouble(aux[3])));
                        ap.add(new Produto(Integer.parseInt(aux[0]), aux[1], aux[2], Double.parseDouble(aux[3])));
                    }
                }catch(FileNotFoundException e){
                        System.out.println("Arquivo não encontrado");
                }
                break;
            case 4:
                try{
                    String linhas = new String();
                    Scanner sc1 = new Scanner(arquivoCSV100000);
                    sc1.nextLine();
                    while(sc1.hasNext()){
                        linhas = sc1.nextLine();
                        String[] aux = linhas.split(",");
                        lst.adicionar(new Produto(Integer.parseInt(aux[0]), aux[1], aux[2], Double.parseDouble(aux[3])));
                        ap.add(new Produto(Integer.parseInt(aux[0]), aux[1], aux[2], Double.parseDouble(aux[3])));
                    }
                }catch(FileNotFoundException e){
                        System.out.println("Arquivo não encontrado");
                }
                break;
        }

        System.out.println("Total de elementos na lista: " + lst.tamanho() + ".");
        System.out.println("Total de elementos na árvore: " + ap.size() + "." + "\n");
        System.out.println("Altura da árvore: " + ap.alturaArvore(ap.getRaiz()));
        
        for(;;){
            if(produtoEscolhido > 4){
                System.out.println("Arquivo inválido");
                break;
            }
            System.out.println("--------------------Função de consulta--------------------");
            System.out.println("Caso deseja sair, digite -1.");
            System.out.print("Digite o código do produto a ser buscado: ");
            System.out.println();
            int itemProcurado = sc.nextInt();

            if(itemProcurado == -1){
                break;
            }
            //procuraArvoreItem
            if(ap.contem(itemProcurado)){
                System.out.println();
                System.out.println("A Arvore contém o item procurado!");
                System.out.println("Item buscado na árvore: " + ap.get(itemProcurado, ap.getRaiz()) + "\n");
            }else {
                System.out.println("Item não encontrado.");
            }
            //procuraListaItem
            if(lst.contem(itemProcurado)){
                System.out.println("A lista contém o item procurado!");
                System.out.println("Item buscado na lista: " + lst.get(itemProcurado - 1).toString() + "\n");
            } else {
                System.out.println("Item não encontrado.");
            }

            System.out.println("Número de operações da Lista: " + lst.getQuantidadeOperacoes());
            System.out.println("Número de operações da Arvore: " + ap.getOperacoesBusca());
        }
        sc.close();
    }
}