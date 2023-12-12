package banco;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class DadosSalvos {
		
	private List<Associado> associados = new ArrayList<>();
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	private String currentUser;
	
	public DadosSalvos() {
	       
    }

    public DadosSalvos(List<Associado> associados, List<Funcionario> funcionarios) {
        this.associados = associados;
		this.funcionarios = funcionarios;
    }
    
    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
    	this.currentUser = currentUser;
    }
    
    //Metodos relacionados as contas cadastradas
	
	public List<ContaCadastrada> getContas() {
        return contas;
    }

    public void addConta(ContaCadastrada conta) {
    	contas.add(conta);
    }
    
    public void updateContas (int i, ContaCadastrada conta) {
    	contas.set(i, conta);
    }
    
    public void deleteContas (int i) {
    	contas.remove(i);
    }
    
    //Metodos relacionados aos associados cadastrados
    
    public List<Associado> getAssociados() {
        return associados;
    }

    public void addAssociado(Associado associado) {
    	associados.add(associado);
    }
    
    public void updateAssociado(int i, Associado associado) {
    	associados.set(i, associado);
    }
    
    public void deleteAssociado (int i) {
    	associados.remove(i);
    }
    
    //Metodos relacionados aos funcionarios cadastrados
    
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
    	funcionarios.add(funcionario);
    }
    
    public void updateFuncionario (int i, Funcionario funcionario) {
    	funcionarios.set(i, funcionario);
    }
    
    public void deleteFuncionario (int i) {
    	funcionarios.remove(i);
    }
    

}
