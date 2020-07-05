package br.com.william.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.com.william.model.Funcionario;

public class TelaConsultaFuncionario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfIdade;
	private JTextField tfEndereco;
	private JTextField tfMatricula;

	public TelaConsultaFuncionario(String titulo) {
		super(titulo);
		getContentPane().setBackground(new Color(50, 205, 50));
		setBounds(100, 100, 450, 300);

		JLabel lNome = new JLabel("Nome");

		tfNome = new JTextField();
		tfNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");

		JLabel lblIdade = new JLabel("Idade");

		JLabel lblEndereo = new JLabel("Endere\u00E7o");

		tfSobrenome = new JTextField();
		tfSobrenome.setColumns(10);

		tfIdade = new JTextField();
		tfIdade.setText("");
		tfIdade.setColumns(10);

		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EntityManagerFactory factory = Persistence.createEntityManagerFactory("empresa");
				EntityManager manager = factory.createEntityManager();

				Query query = manager.createQuery("select f from Funcionario as f " + "where f.nome = :parametro1");
				query.setParameter("parametro1", tfNome.getText());

				List<Funcionario> lista = query.getResultList();

				for (Funcionario funcionario : lista) {
					System.out.println("Id: " + funcionario.getId() + "\n");
					System.out.println("Nome: " + funcionario.getNome() + "\n");
					System.out.println("Sobrenome: " + funcionario.getSobrenome() + "\n");
					System.out.println("Endereço: " + funcionario.getEndereco() + "\n");
					System.out.println("Idade: " + funcionario.getIdade() + "\n");
					System.out.println("Matrícula: " + funcionario.getMatricula() + "\n");
				}

				/*
				 * Funcionario funcionario = manager.find(Funcionario.class,
				 * Integer.parseInt(tfMatricula.getText())); String resultado = "Nome: " +
				 * funcionario.getNome(); System.out.pri*ntln(resultado);
				 */
				manager.close();

			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfMatricula.setText("");
				tfNome.setText("");
				tfSobrenome.setText("");
				tfEndereco.setText("");
				tfIdade.setText("");

				System.out.println("Campos limpos.");
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Fechou a tela de cadastro de funcionários");
				dispose();
			}
		});

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");

		tfMatricula = new JTextField();
		tfMatricula.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(btnPesquisar).addGap(50)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(49)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addComponent(lblEndereo).addComponent(lblIdade)
								.addComponent(lblSobrenome).addComponent(lNome).addComponent(lblMatrcula))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfEndereco, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addComponent(tfIdade, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addComponent(tfSobrenome, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
								.addComponent(tfMatricula, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
						.addGap(75)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMatrcula))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lNome))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSobrenome))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdade))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndereo))
						.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnPesquisar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addGap(26)));
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] { lNome, tfNome, lblSobrenome, lblIdade,
				lblEndereo, tfSobrenome, tfIdade, tfEndereco, lblMatrcula, tfMatricula });
		getContentPane().setLayout(groupLayout);

	}
}
