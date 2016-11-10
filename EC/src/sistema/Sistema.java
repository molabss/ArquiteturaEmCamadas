package sistema;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *Responsável por executar os processos de inicialização do sistema.
 *Padrão de Projetos Utility. Class do livro Java Efetivo [Item4].
 *@author Moisés Santana
 *@version 1.0 - 29/09/2016
 *@since 29/09/2016
 **/
public class Sistema {
	
	/**
	 *Armazenma o gerenciador de conexão 
	 *com o banco de dados. 
	 *Padrão de projeto Singleton do livro 
	 *Padrão de projetos em Java. 
	*/
	private static Connection conexao;
	
	/**Não pode ser criada.**/
	private Sistema(){
		throw new IllegalStateException();
	}
	
	/**Executa as inicializações necessários para iniciar o sistema.**/
	public static void iniciarSistema(){
		if(conexao==null){
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				conexao=DriverManager.getConnection(Parametros.BASE_SGBD,Parametros.USUARIO,Parametros.SENHA);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Erro na comunicação com banco de dados.");
			}
		}
	}
	
	/**Retorna a conexão ativa.**/
	public static Connection getConexao(){
		if(conexao==null){
			iniciarSistema();
		}
		return conexao;
	}
	
	/**Executa os fechamentos necessários para desligar o sistema.**/
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
