package negocio;

/**
 *Representa a entidae de neg�cio cliente. Padr�o de Projeto Domain Model do livro Padr�es de Arquitetura
 *de Aplica��es Corporativas.
 *@author Mois�s Santana
 *@version 29/09/2016 
 **/
public class Cliente {

	private Long id;
	private String nome;
	private String email;
	
	/**
	 * Cria um novo cliente como conte�do vazio.
	 */
	public Cliente(){
		nome="";
		email="";
	}
	
	/**
	 * Cria um novo objeto recebendo informa��es.
	 * @param id identificador �nico a ser informado.
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
			throw new NegocioException("Nome obrigat�rio.");
		}else if(nome.trim().equals("")){
			throw new NegocioException("Nome obrigat�rio.");
		}
		//email
		if("".equals(nome)){
			throw new NegocioException("E-mail obrigat�rio.");
		}else if(nome.trim().equals("")){
			throw new NegocioException("E-mail obrigat�rio.");
		}
		if(!email.contains("@")){
			throw new NegocioException("E-mail inv�lido.");
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
