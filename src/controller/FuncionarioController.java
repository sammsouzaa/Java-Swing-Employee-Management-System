package controller;

import java.util.List;

import dao.ExceptionDAO;
import model.*;

public class FuncionarioController {
	
	public void cadastrarFuncionario(DadosBasicos dadosPessoais, String cargo, double salario, List<String>empregos, List<Treinamento> treinamentos, 
			List<String>feedbacks, String usuario, String senha) throws Exception{
		
		if (dadosPessoais != null && cargo != null && cargo.length() > 0 && salario > 0.00 && empregos != null && treinamentos != null) {
			
			Funcionario funcionario = new Funcionario(dadosPessoais.getNome(), dadosPessoais.getEmail(), dadosPessoais.getEndereco(), dadosPessoais.getTelefone(),
					cargo, salario, empregos, treinamentos, feedbacks, usuario, senha);
			funcionario.cadastrarFuncionario(funcionario);
			
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
	public List<Funcionario> listarFuncionario(String nome) throws ExceptionDAO{
		Funcionario funcionario = new Funcionario();
		return funcionario.listarFuncionarios(nome);
	}
}
