package apresentacao;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import negocio.Cliente;
import persistencia.ClienteRepositorio;
import persistencia.FabricaPersistencia;
import persistencia.PersistenciaException;

/**
 * Interface gráfica desktop de listagem de clientes usando o framework Java Swing.
 * @author Moisés Santana
 * @version 1.0 - 10/11/2016
 * @since 10/11/2016
 */
public class ListaCliente extends JFrame{

	/**
	 * Constroi e inicializa os componentes visuais.
	 */
	public ListaCliente(){
		ClienteRepositorio dao = FabricaPersistencia.fabricarCliente();
		List<Cliente>clientes = null;
		try {
			clientes = dao.getClientes();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			clientes = new ArrayList<Cliente>();
		}
		Object[][]grid=new Object[clientes.size()][3];
		for(int ct=0; ct < clientes.size(); ct++){
			grid[ct]=new Object[]{clientes.get(ct).getNome(),clientes.get(ct).getEmail()};
		}
		JTable table = new JTable(grid,new String[]{"NOME","EMAIL"});
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll,BorderLayout.CENTER);
		setTitle("Clientes Cadastrados");
		setSize(600,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
