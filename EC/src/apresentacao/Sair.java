package apresentacao;

import sistema.Sistema;


/**
 * Processador de deslimanto da solu��o.
 * @author Mois�s Santana
 * @version 1.0 - 13/11/2016
 * @since 13/11/2016
 */
public class Sair implements Runnable{

	/**Processo que executa as opera��es de desligamento*/
	@Override
	public void run() {
		Sistema.desligarSistema();
	}
}
