package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import banco.DadosSalvos;
import model.DadosBasicos;
import model.DadosPagamento;

public class CadAssociado2 extends JFrame{

	private JLabel nomeJLabel;
	private JTextField nomeJTxtField;
	
	private JLabel enderecoJLabel;
	private JTextField enderecoJTxtField;
	
	private JLabel emailJLabel;
	private JTextField emailJTxtField;
	
	private JLabel foneJLabel;
	private JTextField foneJTxtField;
	
	public JButton continuarBtn;
	public JButton addBtn;
	
	private DadosSalvos dadosSalvos;
	private DadosBasicos dadosPessoais;
	private DadosPagamento pagamento;
	private List<DadosBasicos> dependentes = new ArrayList();
	
	public CadAssociado2(DadosSalvos dadosSalvos, DadosBasicos dadosPessoais, DadosPagamento pagamento) {
		super("Cadastro de Associado");
		
		this.dadosSalvos = dadosSalvos;
		this.dadosPessoais = dadosPessoais;
		this.pagamento = pagamento;

		nomeJLabel = new JLabel("Nome");
		nomeJTxtField = new JTextField();
		foneJLabel = new JLabel("Telefone");
		foneJTxtField = new JTextField();
		emailJLabel = new JLabel("email");
		emailJTxtField = new JTextField();
		enderecoJLabel = new JLabel("endereco");
		enderecoJTxtField = new JTextField();
		
		continuarBtn = new JButton("Continuar");
		addBtn = new JButton("Adicionar");

		setSize(500, 300);
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
		
		continuarBtn.setBounds(160,210,200,25);
		addBtn.setBounds(300, 100, 200, 25);

		add(nomeJLabel);
		add(nomeJTxtField);
		add(foneJLabel);
		add(foneJTxtField);
		add(emailJLabel);
		add(emailJTxtField);
		add(enderecoJLabel);
		add(enderecoJTxtField);
		add(continuarBtn);
		add(addBtn);
		
		addBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				if(!nomeJTxtField.getText().trim().isEmpty() && !foneJTxtField.getText().trim().isEmpty() &&
						!emailJTxtField.getText().trim().isEmpty() && !enderecoJTxtField.getText().trim().isEmpty()) {
					
					DadosBasicos dependente = new DadosBasicos(nomeJTxtField.getText(),enderecoJTxtField.getText(),
							foneJTxtField.getText(),emailJTxtField.getText());
					
					dependentes.add(dependente);
					
				}else {
					JOptionPane.showMessageDialog(null, "Complete Todos os Campos!!");
				}
				
			}
		});
		
		continuarBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				try {
					if(!nomeJTxtField.getText().trim().isEmpty() && !foneJTxtField.getText().trim().isEmpty() &&
							!emailJTxtField.getText().trim().isEmpty() && !enderecoJTxtField.getText().trim().isEmpty()) {
						
//						DadosBasicos dadosPessoais = new DadosBasicos(nomeJTxtField.getText(), enderecoJTxtField.getText(), foneJTxtField.getText(), emailJTxtField.getText());
//						
//						CadFuncionario2 cadFuncionario2 = new CadFuncionario2(dadosSalvos, dadosPessoais);
//						dispose();
						
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
