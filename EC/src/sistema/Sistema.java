package sistema;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *Respons�vel por executar os processos de inicializa��o do sistema.
 *Padr�o de Projetos Utility. Class do livro Java Efetivo [Item4].
 *@author Mois�s Santana
 *@version 1.0 - 29/09/2016
 *@since 29/09/2016
 **/
public class Sistema {
	
	/**
	 *Armazenma o gerenciador de conex�o 
	 *com o banco de dados. 
	 *Padr�o de projeto Singleton do livro 
	 *Padr�o de projetos em Java. 
	*/
	private static Connection conexao;
	
	/**N�o pode ser criada.**/
	private Sistema(){
		throw new IllegalStateException();
	}
	
	/**Executa as inicializa��es necess�rios para iniciar o sistema.**/
	public static void iniciarSistema(){
		if(conexao==null){
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				conexao=DriverManager.getConnection(Parametros.BASE_SGBD,Parametros.USUARIO,Parametros.SENHA);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Erro na comunica��o com banco de dados.");
			}
		}
	}
	
	/**Retorna a conex�o ativa.**/
	public static Connection getConexao(){
		if(conexao==null){
			iniciarSistema();
		}
		return conexao;
	}
	
	/**Executa os fechamentos necess�rios para desligar o sistema.**/
	public static void desligarSistema(){
		if(conexao!=null){
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
