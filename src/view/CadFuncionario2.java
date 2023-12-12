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

public class CadFuncionario2 extends JFrame{


	private static final long serialVersionUID = 5756598100844974336L;

	private JLabel empregosJLabel;
	private JTextField empregosJTxtField;
	public JButton addBtn;
	public JButton continuarBtn;
	
	private DadosSalvos dadosSalvos;
	private DadosBasicos dadosPessoais;
	private List<String> empregos = new ArrayList();

	public CadFuncionario2(DadosSalvos dadosSalvos, DadosBasicos dadosPessoais) {
		super("Cadastro de Funcionarios");
		
		this.dadosSalvos = dadosSalvos;
		this.dadosPessoais = dadosPessoais;
		
		empregosJLabel = new JLabel("Emprego");
		empregosJTxtField = new JTextField();
		addBtn = new JButton("Adicionar");
		continuarBtn = new JButton("Continuar");

		setSize(500, 300);
		// setTitle("Cadastro de Clientes");
		setVisible(true);
		setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);


		empregosJLabel.setBounds(30, 30, 100, 25);
		empregosJTxtField.setBounds(120, 30, 200, 25);	
		addBtn.setBounds(30, 70, 130, 25);
		continuarBtn.setBounds(160,210,200,25);

		add(empregosJLabel);
		add(empregosJTxtField);
		add(addBtn);
		add(continuarBtn);
		requestFocusInWindow();
		
		addBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				
				if (!empregosJTxtField.getText().trim().isEmpty()){
					empregos.add(empregosJTxtField.getText());
					empregosJTxtField.setText("");
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
				 CadFuncionario3 cadFuncionario3 = new CadFuncionario3(dadosSalvos, dadosPessoais, empregos);
				 dispose();
			}
		});

	}
}
