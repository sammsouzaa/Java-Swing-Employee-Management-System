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

public class TelaFuncionario extends JFrame{
	
	private static final long serialVersionUID = -2875856536877113449L;

	private JMenuBar barMenu; //cria a barra de menus
	
	private JMenu cadastroMenu; //cria o menu Cadastro
	private JMenu ajudaMenu; //cria o menu Compra
	private JMenu listarMenu; //cria o menu Compra
	
	private JMenuItem associadoMenuItem; //cria o item de menu cliente
	private JMenuItem lancheMenuItem; //cria o item de menu fornecedor
	
	private JMenuItem listarAssociadoMenuItem; //cria o item de menu cliente
	private JMenuItem listarMeusDadosMenuItem;
	
	private JMenuItem sobreMenuItem; //cria o item de menu sobre
	private JMenuItem sairMenuItem; //cria o item de menu sair
	
	private DadosSalvos dadosSalvos;
	
	private int index;

	public TelaFuncionario(DadosSalvos dadosSalvos) {
		super("Tela do Funcionario");
		
		setSize(500, 300);
		setVisible(true);
		setLayout(null);
        setLocationRelativeTo(null);
        requestFocusInWindow();
		setResizable(false);
		
		this.dadosSalvos = dadosSalvos;

		barMenu = new JMenuBar();
		cadastroMenu = new JMenu("Cadastro");
		listarMenu = new JMenu("Listar");
		ajudaMenu = new JMenu("Ajuda");

		associadoMenuItem = new JMenuItem("Associado");
		lancheMenuItem = new JMenuItem("Atividade");
		
		listarAssociadoMenuItem = new JMenuItem("Associado");
		listarMeusDadosMenuItem = new JMenuItem("Meus Dados");
		
		sobreMenuItem = new JMenuItem("Sobre");
		sairMenuItem = new JMenuItem("Sair");

		cadastroMenu.setMnemonic('C');//configura o mnemônico como C
		ajudaMenu.setMnemonic('A'); //configura o mnemônico como A
		listarMenu.setMnemonic(0);

		setJMenuBar(barMenu); //adiciona uma barra de menu na tela
		barMenu.add(cadastroMenu);
		barMenu.add(listarMenu);
		barMenu.add(ajudaMenu);

		cadastroMenu.add(associadoMenuItem);
		cadastroMenu.add(lancheMenuItem);
		
		listarMenu.add(listarAssociadoMenuItem);
		listarMenu.add(listarMeusDadosMenuItem);
		
		ajudaMenu.add(sobreMenuItem);
		ajudaMenu.add(sairMenuItem);
		
		
		
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
		
		listarMeusDadosMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent sair)
			{
				pegarIndex();
				UpdateDadosPessoais telaMeusDados = new UpdateDadosPessoais(dadosSalvos, index, "funcionario");
				dispose();
//				System.exit(0);
			}
		});

	}
	public void pegarIndex() {
		List<Funcionario> funcionarios = dadosSalvos.getFuncionarios();
		int cont = 0;
		for (Funcionario fun: funcionarios) {
			if(fun.getID().equals(dadosSalvos.getCurrentUser())) {
				index = cont;
				break;
			}
			cont += 1;
		}
	}

}
