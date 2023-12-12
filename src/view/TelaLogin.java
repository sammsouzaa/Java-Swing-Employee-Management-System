package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import banco.*;
import controller.FuncionarioController;

import javax.swing.*;
//import controller.ClienteController;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class TelaLogin extends JFrame{
	
	private static final long serialVersionUID = 5756598100844974336L;

	private JLabel usuarioJLabel;
	private JTextField usuarioJTxtField;
	private JLabel passwordJLabel;
	private JPasswordField passwordJTxtField;
	public JButton loginBtn;
	private String usuario, senha = "";
	
	private DadosSalvos dadosSalvos;
	

	public TelaLogin(DadosSalvos dadosSalvos) {
		super("Entrar no Sistema");
		
		this.dadosSalvos = dadosSalvos;
		
		ConfigurarTela();
		requestFocusInWindow();
		setResizable(false);
		
		loginBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				try {
					if(!usuarioJTxtField.getText().trim().isEmpty() && !passwordJTxtField.getText().trim().isEmpty()) {
												
						verificarConta();
					}
					else {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
					}
					
				} catch (Exception e) {
					
					//tratar erro
					JOptionPane.showMessageDialog(null, "Erro: " + e);
				}
			}
		});
	}
	
	


	protected void verificarConta() {
		
		usuario = usuarioJTxtField.getText();
		senha = passwordJTxtField.getText();
		
		boolean exist = false;
		
		if(usuario.equals("gerente") && senha.equals("senha")) {
			TelaGerente telaGerente = new TelaGerente(dadosSalvos);
			dispose();
			exist = true;
		}
		
		try {
			FuncionarioController funcionarioController = new FuncionarioController();
			List<Funcionario> funcionarios = funcionarioController.listarFuncionario("");
			
			for (int i = 0; i < funcionarios.size(); i++) {
			
				if(usuario.equals(funcionarios.get(i).getUsuario()) && senha.equals(funcionarios.get(i).getSenha())) {
						
//					exist = true;
//					dadosSalvos.setCurrentUser(funcionarios.get(i).getID());
//					TelaFuncionario telaFuncionario = new TelaFuncionario(dadosSalvos);
//					dispose();
					JOptionPane.showMessageDialog(null, "Olá " + funcionarios.get(i).getNome());
					
					break;
				}
			}
			if(!exist) {
				passwordJTxtField.setText("");
				usuarioJTxtField.setText("");
				JOptionPane.showMessageDialog(null, "Conta não encontrada");
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}		
	}
	
	public void ConfigurarTela() {
		
		usuarioJLabel = new JLabel("Usuario");
		usuarioJTxtField = new JTextField();
		passwordJLabel = new JLabel("Password");
		passwordJTxtField = new JPasswordField();
		loginBtn = new JButton("Login");

		setSize(500, 300);
		setVisible(true);
		setLayout(null);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		usuarioJLabel.setBounds(100, 40, 100, 25);
		usuarioJTxtField.setBounds(100, 70, 300, 25);
		passwordJLabel.setBounds(100, 100, 100, 25);
		passwordJTxtField.setBounds(100, 130, 300, 25);
		loginBtn.setBounds(200,180,100,25);
		
		add(usuarioJLabel);
		add(usuarioJTxtField);
		add(passwordJLabel);
		add(passwordJTxtField);
		add(loginBtn);
		
	}
}