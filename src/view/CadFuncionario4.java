package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import banco.DadosSalvos;
import controller.FuncionarioController;
import model.*;

public class CadFuncionario4 extends JFrame {
	
	private JLabel usuarioJLabel;
	private JTextField usuarioJTxtField;
	
	private JLabel senhaJLabel;
	private JTextField senhaJTxtField;
	
	public JButton continuarBtn;
	
	private DadosSalvos dadosSalvos;
	private DadosBasicos dadosPessoais;
	private List<String> empregos;
	private List<Treinamento> treinamentos;
	private List<String> feedbacks = new ArrayList();
	
	public CadFuncionario4(DadosSalvos dadosSalvos, DadosBasicos dadosPessoais, List<String> empregos, List<Treinamento> treinamentos) {
		super("Cadastro de Funcionarios");
		
		this.dadosSalvos = dadosSalvos;
		this.dadosPessoais = dadosPessoais;
		this.empregos = empregos;
		this.treinamentos = treinamentos;

		usuarioJLabel = new JLabel("usuario");
		usuarioJTxtField = new JTextField();
		senhaJLabel = new JLabel("senha");
		senhaJTxtField = new JTextField();

		
		continuarBtn = new JButton("Continuar");

		setSize(500, 300);
		// setTitle("Cadastro de Clientes");
		setVisible(true);
		setLayout(null);
        setLocationRelativeTo(null);
//        requestFocuassInWindow();
        setResizable(false);

        usuarioJLabel.setBounds(30, 20, 100, 25);
        usuarioJTxtField.setBounds(120, 20, 200, 25);
        senhaJLabel.setBounds(30, 60, 130, 25);
        senhaJTxtField.setBounds(120, 60, 200, 25);

		
		continuarBtn.setBounds(160,210,200,25);

		add(usuarioJLabel);
		add(usuarioJTxtField);
		add(senhaJLabel);
		add(senhaJTxtField);
		add(continuarBtn);
		
		usuarioJTxtField.requestFocus();
		
		continuarBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				
				String senha = senhaJTxtField.getText();
				String usuario = usuarioJTxtField.getText();
				
				if(!senha.trim().isEmpty() && !usuario.trim().isEmpty()) {
					
					try {
						
						FuncionarioController funcionarioController = new FuncionarioController();
						funcionarioController.cadastrarFuncionario(dadosPessoais, "funcionario", 1500.00, empregos, treinamentos, feedbacks, usuario, senha);
						
						TelaGerente telaGerente = new TelaGerente(dadosSalvos);
						dispose();
						JOptionPane.showMessageDialog(null, "Funcionario Cadastrado!!");
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, "Erro: " + e);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Complete os Campos!!");
				}
			}
			
		});
	}
	 public static String gerarID() {
	        UUID uuid = UUID.randomUUID();
	        return uuid.toString();
	    }

}
