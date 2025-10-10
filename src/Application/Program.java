package Application;
import Entities.Transacao;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ArrayList<Transacao> transacoes = new ArrayList<>();
        int escolha;
        do {
            exibirMenu();
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha){
                case 1:
                    System.out.print("Tipo da transação (despesa/receita): ");
                    String tipo = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Descrição da receita: ");
                    String descricao = sc.nextLine();
                    Transacao transacao = new Transacao(tipo, valor, descricao);
                    transacoes.add(transacao);
                    break;
                case 2:
                    exibirTransacoes(transacoes);
                    break;
                case 3:
                    System.out.println("Valor total: "+ exibirTotal(transacoes));
                    break;
                case 4:
                    System.out.println("Fechando programa. . . Obrigado por usar.");
                    break;

            }
        } while (escolha != 4);
        sc.close();
    }
    public static void exibirMenu(){
        System.out.println("===================-Menu-===================");
        System.out.println("||                                        ||");
        System.out.println("||     1 - Adicionar nova transação       ||");
        System.out.println("||     2 - Listar transações              ||");
        System.out.println("||     3 - Exibir saldo total             ||");
        System.out.println("||     4 - Sair                           ||");
        System.out.println("||                                        ||");
        System.out.println("============================================");
        System.out.print("Escolha ==> ");
    }
    public static void exibirTransacoes(ArrayList<Transacao> transacoes){
        for (Transacao trans : transacoes){
            System.out.println("--------------------");
            System.out.println("Tipo: " + trans.getTipo());
            System.out.println("Valor: " + trans.getValor());
            System.out.println("Descrição: " + trans.getDescricao());
        }
    }
    public static double exibirTotal(ArrayList<Transacao> transacoes) {
        double valorTotal = 0;
        for (Transacao trans : transacoes) {
            if ("receita".equals(trans.getTipo())){
                valorTotal += trans.getValor();
            }
            else {
                valorTotal -= trans.getValor();
            }
        }
        return valorTotal;
    }
}