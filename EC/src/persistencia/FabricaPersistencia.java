package persistencia;


/**
 *Fabrica de criação de estratégias de persistências. Padrão de projeto Strategy do livro Padrões de Projeto
 *@author Moisés Santana
 *@version 1.0 - 10/11/2016
 *@since 10/11/2016
 * */
public class FabricaPersistencia {

	/**Não pode ser criada.**/
	private FabricaPersistencia(){
		throw new IllegalStateException();
	}
	
	/**
	 *Fabria a estratégia de persistência para clientes. 
	 * @return persistência de clientes.
	 */
	public static ClienteRepositorio fabricarCliente(){
		//return new ClienteJDBCimp();
		return new ClienteXMLimp();
	}
}
