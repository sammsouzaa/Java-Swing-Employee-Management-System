package view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import banco.DadosSalvos;
import model.DadosBasicos;
import model.Funcionario;
import model.Treinamento;


public class CadFuncionario3 extends JFrame{

	private static final long serialVersionUID = 5756598100844974336L;

	private JLabel tituloJLabel;
	private JTextField tituloJTxtField;
	
	private JLabel descricaoJLabel;
	private JTextField descricaoJTxtField;
	
	public JButton addBtn;
	public JButton continuarBtn;
	
	private DadosSalvos dadosSalvos;
	private DadosBasicos dadosPessoais;
	private List<String> empregos;
	private List<Treinamento> treinamentos = new ArrayList();
	
	public CadFuncionario3(DadosSalvos dadosSalvos, DadosBasicos dadosPessoais, List<String> empregos) {
		super("Cadastro de Funcionarios");
		
		this.dadosSalvos = dadosSalvos;
		this.dadosPessoais = dadosPessoais;
		this.empregos = empregos;

		tituloJLabel = new JLabel("Titulo");
		tituloJTxtField = new JTextField();
		descricaoJLabel = new JLabel("Descrição");
		descricaoJTxtField = new JTextField();
		addBtn = new JButton("Adicionar");
		
		continuarBtn = new JButton("Continuar");

		setSize(500, 300);
		// setTitle("Cadastro de Clientes");
		setVisible(true);
		setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        requestFocusInWindow();


		tituloJLabel.setBounds(30, 30, 100, 25);
		tituloJTxtField.setBounds(120, 30, 200, 25);
		descricaoJLabel.setBounds(30, 70, 100, 25);
		descricaoJTxtField.setBounds(120, 70, 200, 25);
		addBtn.setBounds(120,120,200,25);
		continuarBtn.setBounds(160,210,200,25);

		add(tituloJLabel);
		add(tituloJTxtField);
		add(descricaoJLabel);
		add(descricaoJTxtField);
		add(addBtn);
		add(continuarBtn);
		
		
		addBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				
				if (!tituloJTxtField.getText().trim().isEmpty() && !descricaoJTxtField.getText().trim().isEmpty()){
					
					Treinamento treinamento = new Treinamento(tituloJTxtField.getText(), descricaoJTxtField.getText());
					
					treinamentos.add(treinamento);
					tituloJTxtField.setText("");
					descricaoJTxtField.setText("");
					
					JOptionPane.showMessageDialog(null, "Adicionado");
				}else {
					JOptionPane.showMessageDialog(null, "Complete o Campo!!");
				}
			}
		});
		
		continuarBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				CadFuncionario4 cadFuncionario4 = new CadFuncionario4(dadosSalvos, dadosPessoais, empregos, treinamentos);
				dispose();
			}
		});
	}
}
