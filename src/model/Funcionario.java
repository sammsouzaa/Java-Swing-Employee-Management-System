package model;

import java.util.List;

import dao.ExceptionDAO;
import dao.FuncionarioDAO;

public class Funcionario extends DadosBasicos{
	
	private int codFuncionario;
//    private DadosBasicos dadosBasicos;
    private String cargo;
    private Double salario;
    private List<String> empregos;
    private List<Treinamento> treinamentos;
    private List<String> feedbacks;
    private String usuario, senha;

    public Funcionario() {
        
    } 

    public Funcionario(String nome, String email, String endereco, String fone, String cargo, Double salario, List<String> empregos, List<Treinamento> treinamentos,
    		List<String> feedbacks, String usuario, String senha) {
    	super(nome, endereco, fone, email);
    	
        this.cargo = cargo;
        this.salario = salario;
        this.empregos = empregos;
        this.treinamentos = treinamentos;
        this.feedbacks = feedbacks;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<String> getEmpregos() {
        return empregos;
    }

    public void setEmpregos(List<String> empregos) {
        this.empregos = empregos;
    }

    public List<String> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<String> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Treinamento> getTreinamentos() {
        return treinamentos;
    }

    public void setTreinamentos(List<Treinamento> treinamentos) {
        this.treinamentos = treinamentos;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String Usuario) {
        this.usuario = usuario;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void cadastrarFuncionario(Funcionario funcionario) throws ExceptionDAO{
		new FuncionarioDAO().cadastrarFuncionario(funcionario);
	}
	
	public List<Funcionario> listarFuncionarios(String nome) throws ExceptionDAO{
		return new FuncionarioDAO().listarFuncionarios(nome);
	}
    
}

