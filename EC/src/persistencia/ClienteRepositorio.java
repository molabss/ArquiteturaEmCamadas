package persistencia;

import java.util.List;

import negocio.Cliente;

/**
 *Contrato de serviço utilizado para definir as operações de persistência de clientes. É a aplicação
 *do conceito de DbC. Padrão de projeto Repository do livro Domain Driven Design [DDD].
 *@author Moisés Santana
 *@version 1.0 - 29/09/2016
 *@since 29/09/2016
 * */
public interface ClienteRepositorio {

	/**
	 * Inserir um novo cliente na base.
	 * @param c informações do cliente a serem inseridas.
	 * @throws PersistenciaException caso ocorrer erros de persistência.
	 **/
	void inserir (Cliente c) throws PersistenciaException;
	
	/**
	 * Pesquisa e retorna todos os clientes existentes ordenado pelo nome.
	 * @return clientes existentes ordenado pelo nome.
	 * @throws PersistenciaException caso ocorrer erros de persistência.
	 **/
	List<Cliente>getClientes() throws PersistenciaException;
}
