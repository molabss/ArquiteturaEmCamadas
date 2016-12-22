package apresentacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Cliente;
import persistencia.ClienteRepositorio;
import persistencia.FabricaPersistencia;

/**
 * Interface gráfica desktop de cadastro de clientes usando o framework Java Swing.
 * @author Moisés Santana
 * @version 1.0 - 12/11/2016
 * @since 12/11/2016
 */
public class CadastroCliente extends JFrame{

	
	/**Armazena o repositorio de clientes.*/
	private ClienteRepositorio repositorio;
	
	/**Armazena o botão que entra na listagem de clientes.*/
	private JButton btListar;
	
	/**Armazena o botão que grava os clientes.*/
	private JButton btOk;
	
	/**Armazena o campo que recebe o nome de um cliente.*/
	private JTextField tfNome;
	
	/**Armazena o campo que recebe o email de um cliente.*/
	private JTextField tfEmail;
	
	public CadastroCliente(){
		repositorio = FabricaPersistencia.fabricarCliente();
		btListar = new JButton("Listar");
		JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pn1.add(btListar);
		getContentPane().add(pn1,BorderLayout.NORTH);
		
		tfNome = new JTextField(30);
		tfEmail = new JTextField(30);
		JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pn2.add(new JLabel("Nome"));
		pn2.add(tfNome);
		pn2.add(new JLabel("E-mail"));
		pn2.add(tfEmail);
		getContentPane().add(pn2,BorderLayout.CENTER);
		
		btOk = new JButton("Ok");
		JPanel pn3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pn3.add(btOk);
		getContentPane().add(pn3,BorderLayout.SOUTH);
		
		eventos();
		
		setTitle("Estudo de Caso");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(360,210);
		setLocationRelativeTo(null);
	}
	
	/**Limpa os campos visuais após o cadastro*/
	public void limparCampos(){
		tfNome.setText("");
		tfEmail.setText("");
	}
	
	/**Configura os eventos visuais*/
	public void eventos(){
		btOk.addActionListener(e -> {
			if(inserir()){
				limparCampos();
			}
		});
		btListar.addActionListener(e -> {
			ListaCliente lista = new ListaCliente();
			lista.setVisible(true);
		});
	}
	
	/**Grava um novo cliente no repositório*/
	private boolean inserir(){
		Cliente cliente = new Cliente();
		cliente.setNome(tfNome.getText());
		cliente.setEmail(tfEmail.getText());
		try {
			cliente.validarInserir();
			repositorio.inserir(cliente);
			JOptionPane.showMessageDialog(this, "Cliente gravado com sucesso!");
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),"Erro de gravação",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
