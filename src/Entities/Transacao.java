package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private String tipo; //receita ou despesa
    private double valor;
    private String descricao;
    private LocalDateTime dataTransacao;

    public Transacao(String tipo, double valor, String descricao){
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.dataTransacao = LocalDateTime.now();
    }

    public String getTipo(){
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        String dataFormatada = dataTransacao.format(formatador);
        return  "Tipo da transação: "+ tipo+ "\n"+
                "Valor: "+ valor+"\n"+
                "Descrição: "+ descricao+"\n"+
                "Data: "+dataFormatada+"\n";
    }
}
