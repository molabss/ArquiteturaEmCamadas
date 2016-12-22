package persistencia;

import java.util.List;

import negocio.Cliente;

/**
 *Contrato de servi�o utilizado para definir as opera��es de persist�ncia de clientes. � a aplica��o
 *do conceito de DbC. Padr�o de projeto Repository do livro Domain Driven Design [DDD].
 *@author Mois�s Santana
 *@version 1.0 - 29/09/2016
 *@since 29/09/2016
 * */
public interface ClienteRepositorio {

	/**
	 * Inserir um novo cliente na base.
	 * @param c informa��es do cliente a serem inseridas.
	 * @throws PersistenciaException caso ocorrer erros de persist�ncia.
	 **/
	void inserir (Cliente c) throws PersistenciaException;
	
	/**
	 * Pesquisa e retorna todos os clientes existentes ordenado pelo nome.
	 * @return clientes existentes ordenado pelo nome.
	 * @throws PersistenciaException caso ocorrer erros de persist�ncia.
	 **/
	List<Cliente>getClientes() throws PersistenciaException;
}
