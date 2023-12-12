package view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import model.*;
import banco.*;

public class TelaGerente extends JFrame {
	
	private static final long serialVersionUID = -2875856536877113449L;

	private JMenuBar barMenu; //cria a barra de menus
	private JMenu cadastroMenu; //cria o menu Cadastro
	private JMenu ajudaMenu; //cria o menu Compra
	private JMenu listMenu;
	
	private JMenuItem cadFuncionarioMenuItem; //cria o item de menu cliente
	private JMenuItem cadAtividadeMenuItem;
	
	private JMenuItem listFuncionarioMenuItem; //cria o item de menu fornecedor
	private JMenuItem listAtividadeMenuItem;
	
	private JMenuItem sobreMenuItem; //cria o item de menu sobre
	private JMenuItem sairMenuItem; //cria o item de menu sair
	
	private DadosSalvos dadosSalvos;

	public TelaGerente(DadosSalvos dadosSalvos) {
		super("Tela do Gerênte");
		
		this.dadosSalvos = dadosSalvos;
		
		ConfigurarTela();
		

		sobreMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sobre) 
			{
//				JOptionPane.showMessageDialog(TelaPrincipal.this, "Este é um exemplo\n"
//						+ "do uso de menus.");
			}
		});
		
		sairMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				TelaLogin telaLogin = new TelaLogin(dadosSalvos);
				dispose();
//				System.exit(0);
			}
		});
		
		cadFuncionarioMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				 CadFuncionario cadFuncionario = new CadFuncionario(dadosSalvos);
				 dispose();

			}
		});
		
		listFuncionarioMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				ListFuncionario listFuncionario = new ListFuncionario(dadosSalvos);
				dispose();
			}
		});
	}
	
	public void ConfigurarTela() {
		setSize(500, 300);
		setVisible(true);
		setLayout(null);
        setLocationRelativeTo(null);
        requestFocusInWindow();
		setResizable(false);

		barMenu = new JMenuBar();
		cadastroMenu = new JMenu("Cadastrar");
		listMenu = new JMenu("Listar");
		ajudaMenu = new JMenu("Ajuda");
		
		cadAtividadeMenuItem = new JMenuItem("Atividade");
		cadFuncionarioMenuItem = new JMenuItem("Funcionario");
		
		listAtividadeMenuItem = new JMenuItem("Atividade");
		listFuncionarioMenuItem = new JMenuItem("Funcionario");
		sobreMenuItem = new JMenuItem("Sobre");
		sairMenuItem = new JMenuItem("Sair");

		cadastroMenu.setMnemonic('C');//configura o mnemônico como C
		listMenu.setMnemonic(0);
		ajudaMenu.setMnemonic('A'); //configura o mnemônico como A

		setJMenuBar(barMenu); //adiciona uma barra de menu na tela
		barMenu.add(cadastroMenu);
		barMenu.add(listMenu);
		barMenu.add(ajudaMenu);

		cadastroMenu.add(cadFuncionarioMenuItem);
		cadastroMenu.add(cadAtividadeMenuItem);
		
		listMenu.add(listFuncionarioMenuItem);
		listMenu.add(listAtividadeMenuItem);
		
		ajudaMenu.add(sobreMenuItem);
		ajudaMenu.add(sairMenuItem);
	}

}
