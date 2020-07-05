package br.com.william.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TelaComDesktop extends JFrame {

	private JFrame frame;
	private Image img;
	private JDesktopPane jDesktopPrincipal;

	public static void main(String[] args) {
		new TelaComDesktop("Tela Com Desktop");
	}

	public TelaComDesktop(String titulo) {
		super(titulo);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH); // Abre o desktop maximizado
		
		/*
		try {
			img = ImageIO.read(getClass().getResource("/images/breno.png"));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"A figura n�o foi encontrada!\n Verifique o caminho. \nErro: " + e.getMessage());

		}
		*/
		
		// Necess�rio para inserir a imagem
		jDesktopPrincipal = new JDesktopPane() {

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				BufferedImage bi;

				if (img != null) {

					Dimension dimension = this.getSize();
					int dWidth = (int) dimension.getWidth();
					int dHeight = (int) dimension.getHeight();

					bi = new BufferedImage(dWidth / 2, dHeight / 2, BufferedImage.TYPE_INT_RGB);

					Graphics2D g2 = bi.createGraphics();
					g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2.drawImage(img, 0, 0, dWidth / 2, dHeight / 2, null);
					g2.dispose();
					g.drawImage(bi, 100, 150, null);

				}
			}
		};

		jDesktopPrincipal.setBackground(new Color(0, 255, 100));
		this.add(jDesktopPrincipal);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mCadastros = new JMenu("Cadastros");
		menuBar.add(mCadastros);
		JMenu mConsultas = new JMenu("Consultas");
		menuBar.add(mConsultas);
		JMenu mRemover = new JMenu("Remover");
		menuBar.add(mRemover);

		JMenuItem miCadastroFuncionario = new JMenuItem("Funcion�rios");
		miCadastroFuncionario.setMnemonic(KeyEvent.VK_F); // cria tela de atalho
		mCadastros.add(miCadastroFuncionario);

		miCadastroFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaCadastroFuncionario telaFuncionario = new TelaCadastroFuncionario("Cadastro de Funcion�rios");
				telaFuncionario.setClosable(true);// true - habilita o X (fechar)
				telaFuncionario.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaFuncionario.setVisible(true);

				jDesktopPrincipal.add(telaFuncionario);

			}

		});

		JMenuItem miArmazem = new JMenuItem("Armazem");
		miArmazem.setMnemonic(KeyEvent.VK_A); // cria tela de atalho
		mCadastros.add(miArmazem);

		miArmazem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroArmazem telaArmazem = new TelaCadastroArmazem("Cadastro de Armaz�ns");
				telaArmazem.setClosable(true);// true - habilita o X (fechar)
				telaArmazem.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaArmazem.setVisible(true);

				jDesktopPrincipal.add(telaArmazem);
			}
		});
		
		JMenuItem miCliente = new JMenuItem("Cliente");
		miCliente.setMnemonic(KeyEvent.VK_A); // cria tela de atalho
		mCadastros.add(miCliente);

		miCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente telaCliente = new TelaCadastroCliente("Cadastro de Clientes");
				telaCliente.setClosable(true);// true - habilita o X (fechar)
				telaCliente.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaCliente.setVisible(true);

				jDesktopPrincipal.add(telaCliente);
			}
		});
		
		JMenuItem miPeca = new JMenuItem("Pe�a");
		miPeca.setMnemonic(KeyEvent.VK_A); // cria tela de atalho
		mCadastros.add(miPeca);

		miPeca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPeca telaPeca = new TelaCadastroPeca("Cadastro de Pe�as");
				telaPeca.setClosable(true);// true - habilita o X (fechar)
				telaPeca.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaPeca.setVisible(true);

				jDesktopPrincipal.add(telaPeca);
			}
		});
		
		JMenuItem miItemPedido = new JMenuItem("Item do Pedido");
		miItemPedido.setMnemonic(KeyEvent.VK_A); // cria tela de atalho
		mCadastros.add(miItemPedido);

		miItemPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroItemPedido telaItemPedido = new TelaCadastroItemPedido("Cadastro de itens do pedido");
				telaItemPedido.setClosable(true);// true - habilita o X (fechar)
				telaItemPedido.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaItemPedido.setVisible(true);

				jDesktopPrincipal.add(telaItemPedido);
			}
		});

		JMenuItem miSair = new JMenuItem("Sair");
		miSair.setMnemonic(KeyEvent.VK_S); // cria tela de atalho
		mCadastros.add(miSair);

		miSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenuItem miConsultaFuncionario = new JMenuItem("Funcion�rio");
		miConsultaFuncionario.setMnemonic(KeyEvent.VK_F); // cria tela de atalho
		mConsultas.add(miConsultaFuncionario);

		miConsultaFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaConsultaFuncionario telaConsultaFuncionario = new TelaConsultaFuncionario("Consultar Funcion�rio");

				telaConsultaFuncionario.setClosable(true);// true - habilita o X (fechar)
				telaConsultaFuncionario.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaConsultaFuncionario.setVisible(true);

				jDesktopPrincipal.add(telaConsultaFuncionario);

			}
		});

		JMenuItem miConsultaCliente = new JMenuItem("Cliente");
		miConsultaCliente.setMnemonic(KeyEvent.VK_C); // cria tela de atalho
		mConsultas.add(miConsultaCliente);

		miConsultaCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		JMenuItem miRemoveFuncionario = new JMenuItem("Funcion�rio");
		miRemoveFuncionario.setMnemonic(KeyEvent.VK_F); // cria tela de atalho
		mRemover.add(miRemoveFuncionario);

		miRemoveFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaRemoveFuncionario telaRemoveFuncionario = new TelaRemoveFuncionario("Consultar Funcion�rio");

				telaRemoveFuncionario.setClosable(true);// true - habilita o X (fechar)
				telaRemoveFuncionario.setResizable(false); // verifica se poder� editar o tamanho da internalframe
				telaRemoveFuncionario.setVisible(true);

				jDesktopPrincipal.add(telaRemoveFuncionario);

			}
		});

		setVisible(true);
	}
}
