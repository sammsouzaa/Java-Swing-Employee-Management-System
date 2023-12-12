package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import banco.DadosSalvos;
import model.DadosBasicos;
import model.Funcionario;

public class UpdateDadosPessoais extends JFrame {
	
	 private JButton voltarBtn;
	 private JButton menuBtn;
	 private JButton atualizarBtn;
	 private DadosSalvos dadosSalvos;
	 
	 private JLabel nomeJLabel;
	 private JTextField nomeJTxtField;
		
	 private JLabel enderecoJLabel;
	 private JTextField enderecoJTxtField;
		
	 private JLabel emailJLabel;
	 private JTextField emailJTxtField;
		
	 private JLabel foneJLabel;
	 private JTextField foneJTxtField;
	 
	 private int index;
	 private Funcionario currentFuncionario;
	 
	 public UpdateDadosPessoais(DadosSalvos dadosSalvos, int index, String cargo) {
	        super("Listar Funcionarios");

	        this.dadosSalvos = dadosSalvos;
	        this.index = index;
	        currentFuncionario = dadosSalvos.getFuncionarios().get(index);

	        ConfigurarTela();
	        requestFocusInWindow();
	        setResizable(false);
			
			CarregarDados();

	        // Configurações de posicionamento e eventos dos botões
	        voltarBtn.addActionListener(e-> {
	        	
	        	if(cargo.equals("gerente")) {
		        	ListFuncionario listFuncionario = new ListFuncionario(dadosSalvos);
	           
	        	}else {
	        		TelaFuncionario novatela = new TelaFuncionario(dadosSalvos);
	            	
	        	}
	            dispose();	        	
	        });
	        
	        menuBtn.addActionListener(e-> {
	        	
	        	if(cargo.equals("gerente")) {
	        		TelaGerente novatela = new TelaGerente(dadosSalvos);
	           
	        	}else {
	        		TelaFuncionario novatela = new TelaFuncionario(dadosSalvos);
	            	
	        	}
	            
            	dispose();
	        	
	        });

	        atualizarBtn.addActionListener(e-> {
			    
	        	if(!nomeJTxtField.getText().trim().isEmpty() && !emailJTxtField.getText().trim().isEmpty() && 
	        			!foneJTxtField.getText().trim().isEmpty() && !enderecoJTxtField.getText().trim().isEmpty()) {
	        		
	        		String nome = nomeJTxtField.getText();
		        	String email = emailJTxtField.getText();
		        	String fone = foneJTxtField.getText();
		        	String endereco = enderecoJTxtField.getText();
		        	
		        	currentFuncionario.setNome(nome);
		        	currentFuncionario.setEmail(email);
		        	currentFuncionario.setTelefone(fone);
		        	currentFuncionario.setEndereco(endereco);
		        	dadosSalvos.updateFuncionario(index, currentFuncionario);
		        	
		        	if(cargo.equals("gerente")) {
		        		ListFuncionario novatela = new ListFuncionario(dadosSalvos);
		        	}else {
		        		TelaFuncionario novatela = new TelaFuncionario(dadosSalvos);
		        	}
		        	dispose();
        			JOptionPane.showMessageDialog(null, "Dados Atualizados!!");
	        		
	        	}else {
        			JOptionPane.showMessageDialog(null, "Complete todos os campos!!");
	        	}
			});
	 }
	 
	 public void ConfigurarTela() {
		 
		setSize(500, 300);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(null);
	    setVisible(true);
	    setLocationRelativeTo(null);
	      
	    voltarBtn = new JButton("Voltar");
	    menuBtn = new JButton("Menu");
	    atualizarBtn = new JButton("Atualizar");
	        
	    nomeJLabel = new JLabel("Nome");
		nomeJTxtField = new JTextField();
		foneJLabel = new JLabel("Telefone");
		foneJTxtField = new JTextField();
		emailJLabel = new JLabel("email");
		emailJTxtField = new JTextField();
		enderecoJLabel = new JLabel("endereco");
		enderecoJTxtField = new JTextField();
			
		nomeJLabel.setBounds(30, 20, 100, 25);
		nomeJTxtField.setBounds(120, 20, 200, 25);
		foneJLabel.setBounds(30, 50, 130, 25);
		foneJTxtField.setBounds(120, 50, 200, 25);
		enderecoJLabel.setBounds(30, 80, 100, 25);
		enderecoJTxtField.setBounds(120, 80, 200, 25);
		emailJLabel.setBounds(30, 110, 100, 25);
		emailJTxtField.setBounds(120, 110, 200, 25);
			
		atualizarBtn.setBounds(160,170,200,25);
	        
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(voltarBtn);
	    buttonPanel.add(menuBtn);

	    add(buttonPanel, BorderLayout.SOUTH);
	    add(nomeJLabel);
		add(nomeJTxtField);
		add(foneJLabel);
		add(foneJTxtField);
		add(emailJLabel);
		add(emailJTxtField);
		add(enderecoJLabel);
		add(enderecoJTxtField);
		add(atualizarBtn);
	 }
	 
	 public void CarregarDados() {
		 
		nomeJTxtField.setText(currentFuncionario.getNome());
		foneJTxtField.setText(currentFuncionario.getTelefone());
		emailJTxtField.setText(currentFuncionario.getEmail());
		enderecoJTxtField.setText(currentFuncionario.getEndereco());
		 
	 }
	       
}
