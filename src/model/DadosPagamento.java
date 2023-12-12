package model;

public class DadosPagamento {

    private String metodoPagamento, numeroCartao, validadeCartao;
    private int codPagamentos;

    public DadosPagamento(String metodoPagamento, String numeroCartao, String validadeCartao) {

        this.metodoPagamento = metodoPagamento;
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
    }
    
    public int getCodPagamentos() {
        return codPagamentos;
    }

    public void setCodPagamentos(int codPagamentos) {
        this.codPagamentos = codPagamentos;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }
}
