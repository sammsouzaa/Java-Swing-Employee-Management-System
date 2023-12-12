package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import banco.DadosSalvos;
import model.Funcionario;

public class ListFuncionario extends JFrame {

    private DadosSalvos dadosSalvos;
    private List<Funcionario> funcionarios = new ArrayList<>();
    
    private JList<String> listaFuncionariosJList;
    private DefaultListModel<String> listModel;

    private JButton deleteBtn;
    private JButton updateBtn;
    private JButton menuBtn;
    
    private int index = -1;

    public ListFuncionario(DadosSalvos dadosSalvos) {
        super("Listar Funcionarios");

        this.dadosSalvos = dadosSalvos;

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//        setLayout(null);
        setLocationRelativeTo(null);
        requestFocusInWindow();
        setResizable(false);

        funcionarios = dadosSalvos.getFuncionarios();
        listModel = new DefaultListModel<>();

        for (Funcionario funcionario : funcionarios) {
            listModel.addElement(funcionario.getNome());
        }

        listaFuncionariosJList = new JList<>(listModel);
        deleteBtn = new JButton("Deletar");
        updateBtn = new JButton("Atualizar");
        menuBtn = new JButton("Menu");

        // Adiciona a JList a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(listaFuncionariosJList);

        // Cria um painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(menuBtn);

        // Adiciona os componentes ao JFrame usando um layout BorderLayout
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
//        add(BorderLayout.WEST, listaFuncionariosJList);
        
        listaFuncionariosJList.addListSelectionListener(e->{
        	
        	index = listaFuncionariosJList.getSelectedIndex();
        });

        // Configurações de posicionamento e eventos dos botões
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(index > 0) {
            		dadosSalvos.deleteFuncionario(index);
            		ListFuncionario listFuncionario = new ListFuncionario(dadosSalvos);
            		dispose();
        			JOptionPane.showMessageDialog(null, "Funcionario Deletado!!");
            	}else {
        			JOptionPane.showMessageDialog(null, "Selecione um Funcionario!!");
            	}
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	UpdateDadosPessoais updateFuncionario = new UpdateDadosPessoais(dadosSalvos, index, "gerente");
            	dispose();
            	
            }
        });
        
        menuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	TelaGerente telaGerente = new TelaGerente(dadosSalvos);
            	dispose();
            	
            }
        });
    }
}
