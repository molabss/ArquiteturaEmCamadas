package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.Cliente;
import sistema.Sistema;


/**
 * Implementação do contrato de persistência de clientes utilizando o framework jdbc. Padrão de projeto 
 * Strategy do livro Padrões de Projeto em Java. A classe não é pública para não expor o serviço para fora
 * da camada.
 * @author Moisés Santana
 * @version 1.0 - 10/11/2016
 * @since 17/06/2016
 */
class ClienteJDBCimp implements ClienteRepositorio{

	/**
	 *Armazena o sql utilizado para inserir um cliente
	 */
	private static final String INSERT = "insert into cliente(nome,email)values(?,?)";
	
	/**
	 *Armazena o sql utilizado para carregar os clientes
	 */
	private static final String SELECT = "select * from cliente order by nome asc";
	
	/**{@inheritDoc} */
	@Override
	public void inserir(Cliente c) throws PersistenciaException {
		PreparedStatement insert = null;
		try{
			insert = Sistema.getConexao().prepareStatement(INSERT);
			insert.setObject(1, c.getNome());
			insert.setObject(2, c.getEmail());
			insert.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Erro ao inserir cliente.");
		}finally {
			try {
				insert.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**{@inheritDoc} */
	@Override
	public List<Cliente> getClientes() throws PersistenciaException {
		Statement select = null;
		try{
			select=Sistema.getConexao().createStatement();
			ResultSet rs=select.executeQuery(SELECT);
			List<Cliente>lista = new ArrayList<Cliente>();
			while(rs.next()){
				lista.add(new Cliente(rs.getLong(1),rs.getString(2),rs.getString(3)));
			}
			rs.close();
			return lista;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Erro ao carregar clientes.");
		}finally {
			try {
				select.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
