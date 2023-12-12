package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

import dao.ExceptionDAO;

public class AssociadoController {
	
	public void cadastrarAssociado(String nome, String email, String endereco, String fone, List<DadosBasicos> dependentes,
			DadosPagamento dadosPagamento) throws Exception{
		
		if (nome != null && nome.length() > 0 && email != null && email.length() > 0 && endereco != null && endereco.length() > 0
				&& fone != null && fone.length() > 0 && dadosPagamento != null) {
			
			Associado associado = new Associado(nome, email, endereco, fone, dependentes, dadosPagamento);
			associado.cadastrarAssociado(associado);
			
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
	public List<Associado> listarAssociado(String nome) throws ExceptionDAO{
		Associado associado = new Associado();
		return associado.listarAssociados(nome);
	}
}
