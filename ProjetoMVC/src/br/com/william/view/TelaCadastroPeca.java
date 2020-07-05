package br.com.william.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.william.controller.PecaController;
import br.com.william.model.Peca;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javassist.bytecode.ExceptionsAttribute;

public class TelaCadastroPeca extends JInternalFrame {
	
	private JTextField tfDescricaoPeca; 
	
	public TelaCadastroPeca(String titulo) {
		super(titulo);
		getContentPane().setBackground(new Color(50,205,50));
		setBounds(100, 100, 450, 300);
		
		JLabel lDescricaoPeca = new JLabel("Descri��o da Pe�a");
		tfDescricaoPeca = new JTextField();
		tfDescricaoPeca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action0) {
				// TODO Auto-generated method stub
				Peca peca = new Peca();
				
				try {
					peca.setDescricaoPeca(tfDescricaoPeca.getText());
					
					PecaController pecaController = new PecaController(peca);
					String msg = pecaController.EntidadeGerenciadora();
					
					JOptionPane.showMessageDialog(null, msg);
					
				}catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Preencha o campo para poder cadastrar!");
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action1) {
				// TODO Auto-generated method stub
				tfDescricaoPeca.setText("");
				System.out.println("Campos limpos!");
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action2) {
				int simNao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
				if (simNao == 0) {
					dispose();
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(btnCadastrar).addGap(50)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(49)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addComponent(lDescricaoPeca))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfDescricaoPeca, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addGap(75))));
		
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfDescricaoPeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lDescricaoPeca))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnCadastrar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addGap(26)));
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] { lDescricaoPeca, tfDescricaoPeca });
		getContentPane().setLayout(groupLayout);

	}

}
