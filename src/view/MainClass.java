package view;

import javax.swing.JFrame;

import banco.*;
import model.*;

public class MainClass {
		
	public static void main(String[] args) {
		
		DadosSalvos dadosSalvos = new DadosSalvos();
					
		TelaLogin testaTela = new TelaLogin(dadosSalvos);
			
//		testaTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		testaTela.setSize(500, 300);
//		testaTela.setVisible(true);	
//		setLayout(null);

//		testaTela.setLocationRelativeTo(null);
	}

}
