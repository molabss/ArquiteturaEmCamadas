package negocio;

/**
 * Representa a ocorrência de erros de negócio, utilizada para 
 * encapsular as tecnologias usadas dentro da camada de negócio
 * @author Moisés Santana
 * @version 22/09/2016
 * @since 22/09/2016
 */
public class NegocioException extends Exception {
	/**
	 * Cria um novo objeto com a mensagem padrão.
	 * @param mensagem descricao da mensagem.
	 */
	public NegocioException(String mensagem){
		super(mensagem);
	}
	
	
}
