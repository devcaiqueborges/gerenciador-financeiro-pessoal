package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private TipoTransacao tipoEnum; //receita ou despesa
    private double valor;
    private String descricao;
    private LocalDateTime dataTransacao;

    public Transacao(TipoTransacao tipoEnum, double valor, String descricao){

        if (valor <= 0){
            throw new IllegalArgumentException("O valor da transação deve ser positivo.");
        }

        this.tipoEnum = tipoEnum;
        this.valor = valor;
        this.descricao = descricao;
        this.dataTransacao = LocalDateTime.now();
    }

    public TipoTransacao getTipo(){
        return tipoEnum;
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
        return  "Tipo da transação: "+ tipoEnum+ "\n"+
                "Valor: "+ valor+"\n"+
                "Descrição: "+ descricao+"\n"+
                "Data: "+dataFormatada+"\n";
    }
}
