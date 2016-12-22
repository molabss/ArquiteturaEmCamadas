package apresentacao;

import sistema.Sistema;

/**
 * Inicializador de sistema desktop jse.
 * @author Moisés Santana
 * @version 1.0 - 10/11/2016
 * @since 10/11/2016
 */
public class Inicio {

	/**
	 * Inicializador padrão desktop jse
	 * @param args argumentos jvm.
	 * */
	public static void main(String[] args) {
		Sistema.iniciarSistema();
		Runtime.getRuntime().addShutdownHook(new Thread(new Sair()));
		CadastroCliente cad = new CadastroCliente();
		cad.setVisible(true);
	}
}
