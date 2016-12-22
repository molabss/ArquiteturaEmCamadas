package persistencia;


/**
 *Fabrica de cria��o de estrat�gias de persist�ncias. Padr�o de projeto Strategy do livro Padr�es de Projeto
 *@author Mois�s Santana
 *@version 1.0 - 10/11/2016
 *@since 10/11/2016
 * */
public class FabricaPersistencia {

	/**N�o pode ser criada.**/
	private FabricaPersistencia(){
		throw new IllegalStateException();
	}
	
	/**
	 *Fabria a estrat�gia de persist�ncia para clientes. 
	 * @return persist�ncia de clientes.
	 */
	public static ClienteRepositorio fabricarCliente(){
		//return new ClienteJDBCimp();
		return new ClienteXMLimp();
	}
}
