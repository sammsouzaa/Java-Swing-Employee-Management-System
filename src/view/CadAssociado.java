package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import banco.DadosSalvos;
import model.DadosBasicos;
import model.DadosPagamento;

public class CadAssociado extends JFrame{
	
	private static final long serialVersionUID = 5756598100844974336L;

	private JLabel nomeJLabel;
	private JTextField nomeJTxtField;
	
	private JLabel enderecoJLabel;
	private JTextField enderecoJTxtField;
	
	private JLabel emailJLabel;
	private JTextField emailJTxtField;
	
	private JLabel foneJLabel;
	private JTextField foneJTxtField;
	
	private JLabel numeroCartaoJLabel;
	private JTextField numeroCartaoJTxtField;
	
	private JLabel metodoPagamentoJLabel;
	private JTextField metodoPagamentoJTxtField;
	
	private JLabel validadeCartaoJLabel;
	private JTextField validadeCartaoJTxtField;
	
	public JButton continuarBtn;
	
	public DadosSalvos dadosSalvos;
	
	public CadAssociado(DadosSalvos dadosSalvos) {
		super("Cadastro de Associado");
		
		this.dadosSalvos = dadosSalvos;

		nomeJLabel = new JLabel("Nome");
		nomeJTxtField = new JTextField();
		foneJLabel = new JLabel("Telefone");
		foneJTxtField = new JTextField();
		emailJLabel = new JLabel("email");
		emailJTxtField = new JTextField();
		enderecoJLabel = new JLabel("endereco");
		enderecoJTxtField = new JTextField();
		
		numeroCartaoJLabel = new JLabel("Numero do Cartão");
		numeroCartaoJTxtField = new JTextField();
		metodoPagamentoJLabel = new JLabel("Metodo de Pagamento");
		metodoPagamentoJTxtField = new JTextField();
		validadeCartaoJLabel = new JLabel("Validade");
		validadeCartaoJTxtField = new JTextField();
		
		
		continuarBtn = new JButton("Continuar");

		setSize(500, 350);
		// setTitle("Cadastro de Clientes");
		setVisible(true);
		setLayout(null);
        setLocationRelativeTo(null);
        requestFocusInWindow();
        setResizable(false);

		nomeJLabel.setBounds(30, 20, 100, 25);
		nomeJTxtField.setBounds(120, 20, 200, 25);
		foneJLabel.setBounds(30, 60, 130, 25);
		foneJTxtField.setBounds(120, 60, 200, 25);
		enderecoJLabel.setBounds(30, 100, 100, 25);
		enderecoJTxtField.setBounds(120, 100, 200, 25);
		emailJLabel.setBounds(30, 140, 100, 25);
		emailJTxtField.setBounds(120, 140, 200, 25);
		
		numeroCartaoJLabel.setBounds(30, 180, 130, 25);
		numeroCartaoJTxtField.setBounds(190, 180, 200, 25);
		metodoPagamentoJLabel.setBounds(30, 220, 100, 25);
		metodoPagamentoJTxtField.setBounds(190, 220, 200, 25);
		validadeCartaoJLabel.setBounds(30, 260, 100, 25);
		validadeCartaoJTxtField.setBounds(120, 260, 200, 25);
		
		continuarBtn.setBounds(160,330,200,25);

		add(nomeJLabel);
		add(nomeJTxtField);
		add(foneJLabel);
		add(foneJTxtField);
		add(emailJLabel);
		add(emailJTxtField);
		add(enderecoJLabel);
		add(enderecoJTxtField);
		
		add(numeroCartaoJLabel);
		add(numeroCartaoJTxtField);
		add(metodoPagamentoJLabel);
		add(metodoPagamentoJTxtField);
		add(validadeCartaoJLabel);
		add(validadeCartaoJTxtField);
		
		add(continuarBtn);
		
		continuarBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				try {
					if(!nomeJTxtField.getText().trim().isEmpty() && !emailJTxtField.getText().trim().isEmpty() &&
							!foneJTxtField.getText().trim().isEmpty() && !enderecoJTxtField.getText().trim().isEmpty() &&
							!numeroCartaoJTxtField.getText().trim().isEmpty() && !metodoPagamentoJTxtField.getText().trim().isEmpty() && 
							!validadeCartaoJTxtField.getText().trim().isEmpty() ) {
						
								
						DadosBasicos dadosPessoais = new DadosBasicos(nomeJTxtField.getText(), enderecoJTxtField.getText(), foneJTxtField.getText(), emailJTxtField.getText());
						DadosPagamento pagamento = new DadosPagamento(numeroCartaoJTxtField.getText(), metodoPagamentoJTxtField.getText(), validadeCartaoJTxtField.getText());
						
						CadAssociado2 cadAssociado2 = new CadAssociado2(dadosSalvos, dadosPessoais, pagamento);
						
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Complete Todos os Campos!!");
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e);
				}
			}
		});
	}

}
