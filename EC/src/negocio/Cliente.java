package negocio;

/**
 *Representa a entidae de negócio cliente. Padrão de Projeto Domain Model do livro Padrões de Arquitetura
 *de Aplicações Corporativas.
 *@author Moisés Santana
 *@version 29/09/2016 
 **/
public class Cliente {

	private Long id;
	private String nome;
	private String email;
	
	/**
	 * Cria um novo cliente como conteúdo vazio.
	 */
	public Cliente(){
		nome="";
		email="";
	}
	
	/**
	 * Cria um novo objeto recebendo informações.
	 * @param id identificador único a ser informado.
	 * @param nome nome a ser informado.
	 * @param email email a ser informado.
	 **/
	public Cliente(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public void validarInserir() throws NegocioException{
		//nome
		if("".equals(nome)){
			throw new NegocioException("Nome obrigatório.");
		}else if(nome.trim().equals("")){
			throw new NegocioException("Nome obrigatório.");
		}
		//email
		if("".equals(nome)){
			throw new NegocioException("E-mail obrigatório.");
		}else if(nome.trim().equals("")){
			throw new NegocioException("E-mail obrigatório.");
		}
		if(!email.contains("@")){
			throw new NegocioException("E-mail inválido.");
		}
		//bloqueio de e-mail da bol
		if(email.contains("bol")){
			throw new NegocioException("E-mail da BOL rejeitado.");
		}		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
