package Application;
import Entities.TipoTransacao;
import Entities.Transacao;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ArrayList<Transacao> transacoes = new ArrayList<>();
        int escolha = 0;
        do {
            exibirMenu();
            //exception caso o usuario entre com algo que não seja um numero
            try {
                escolha = sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Erro: Por favor, digite apenas um número para a opção.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            switch (escolha){
                case 1:

                    System.out.print("Tipo da transação (despesa/receita): ");
                    String tipoString = sc.nextLine();
                    TipoTransacao tipoEnum;

                    //criando exception para caso o usuario digite algo que não seja 'receita' ou 'despesa'
                    try {
                        tipoEnum = TipoTransacao.valueOf(tipoString.toUpperCase());
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("Erro: Tipo de transação inválido. Use 'receita' ou 'despesa'.");
                        continue;
                    }
                    double valor = 0;
                    boolean entradaValida = false;

                    while (!entradaValida){
                        try {
                            System.out.print("Valor: ");
                            valor = sc.nextDouble();
                            entradaValida = true;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Erro! O valor digitado não é um número válido. Tente novamente.");
                            sc.nextLine();
                        }
                    }
                    sc.nextLine();

                    System.out.print("Descrição da "+tipoString+": ");
                    String descricao = sc.nextLine();
                    try {
                        Transacao transacao = new Transacao(tipoEnum, valor, descricao);
                        transacoes.add(transacao);
                        System.out.println("Transação adicionada com sucesso!");
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("Erro ao salvar: " + e.getMessage());
                    }
                    break;
                case 2:
                    exibirTransacoes(transacoes);
                    break;
                case 3:
                    System.out.println("Valor total: "+ exibirTotal(transacoes));
                    break;
                case 4:
                    System.out.println("Fechando programa... Obrigado por usar.");
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
            if (trans.getTipo() == TipoTransacao.RECEITA){
                valorTotal += trans.getValor();
            }
            else {
                valorTotal -= trans.getValor();
            }
        }
        return valorTotal;
    }
}