package negocio;

/**
 * Representa a ocorr�ncia de erros de neg�cio, utilizada para 
 * encapsular as tecnologias usadas dentro da camada de neg�cio
 * @author Mois�s Santana
 * @version 22/09/2016
 * @since 22/09/2016
 */
public class NegocioException extends Exception {
	/**
	 * Cria um novo objeto com a mensagem padr�o.
	 * @param mensagem descricao da mensagem.
	 */
	public NegocioException(String mensagem){
		super(mensagem);
	}
	
	
}
