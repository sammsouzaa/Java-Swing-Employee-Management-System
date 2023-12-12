package model;

import java.util.List;

import dao.AssociadoDAO;
import dao.ExceptionDAO;

public class Associado extends DadosBasicos{
    
	private int codAssociado;
    private List<DadosBasicos> dependentes;
    private DadosPagamento dadosPagamento;
    private List<String> lanches;
    
    public Associado() {
    
    }

    public Associado(String nome, String email, String endereco, String fone, List<DadosBasicos> dependentes, DadosPagamento dadosPagamento) {
    	super(nome, endereco, fone, email);
    	this.dependentes = dependentes;
        this.dadosPagamento = dadosPagamento;
    }
    
    public int getCodAssociado() {
        return codAssociado;
    }

    public void setCodAssociado(int codAssociado) {
        this.codAssociado = codAssociado;
    }

    public List<DadosBasicos> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<DadosBasicos> dependentes) {
        this.dependentes = dependentes;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
    
    public List<String> getLanches() {
        return lanches;
    }

    public void addLanches(List<String> lanches) {
        this.lanches = lanches;
    }
    
    public void cadastrarAssociado(Associado associado) throws ExceptionDAO{
		new AssociadoDAO().cadastrarAssociado(associado);
	}
	
	public List<Associado> listarAssociados(String nome) throws ExceptionDAO{
		return new AssociadoDAO().listarAssociados(nome);
	}
    
    
}