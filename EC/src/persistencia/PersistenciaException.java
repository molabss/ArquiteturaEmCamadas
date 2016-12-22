package persistencia;

/**
 * Representa a ocorr�ncia de erros de persist�ncia, utilizada para encapsular as teconologias internas
 * utilizada dentro da camada de persist�ncia.
 * @author Mois�s Santana
 * @version 1.0 - 29/09/2016
 * @since 29/09/2016
 */
public class PersistenciaException extends Exception{

	/**Cria um novo objeto com a mensagem padr�o.
	 *@param mensagem descri��o da mensagem.
	 */
	public PersistenciaException(String mensagem) {
		super(mensagem);
	}
	
	
}
