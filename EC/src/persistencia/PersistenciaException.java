package persistencia;

/**
 * Representa a ocorrência de erros de persistência, utilizada para encapsular as teconologias internas
 * utilizada dentro da camada de persistência.
 * @author Moisés Santana
 * @version 1.0 - 29/09/2016
 * @since 29/09/2016
 */
public class PersistenciaException extends Exception{

	/**Cria um novo objeto com a mensagem padrão.
	 *@param mensagem descrição da mensagem.
	 */
	public PersistenciaException(String mensagem) {
		super(mensagem);
	}
	
	
}
