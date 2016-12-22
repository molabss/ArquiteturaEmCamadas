package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import negocio.Cliente;
import sistema.Parametros;


/**
 * Implementa��o do contrato de persist�ncia de clientes utilizando o framework JSE XML. Padr�o de projeto 
 * Strategy do livro Padr�es de Projeto em Java. A classe n�o � p�blica para n�o expor o servi�o para fora
 * da camada.
 * @author Mois�s Santana
 * @version 1.0 - 10/11/2016
 * @since 17/06/2016
 */
public class ClienteXMLimp implements ClienteRepositorio{

	/**{@inheritDoc}}*/
	@Override
	public void inserir(Cliente cliente) throws PersistenciaException {
		try {
			XMLEncoder xe = 
					new XMLEncoder(new FileOutputStream(Parametros.BASE_XML+cliente.getNome()+".xml"));
			xe.writeObject(cliente);
			xe.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new PersistenciaException("Erro de persist�ncia");
		}
	}

	/**{@inheritDoc}}*/
	@Override
	public List<Cliente> getClientes() throws PersistenciaException {
		List<Cliente>temp=new ArrayList<>();
		File dir = new File(Parametros.BASE_XML);
		File[] files = dir.listFiles();
		try {
			if(files.length >0){
				for(File xml:files){
					FileInputStream fis = new FileInputStream(xml);
					BufferedInputStream bis = new BufferedInputStream(fis);
					XMLDecoder xmlDecoder = new XMLDecoder(bis);
					Cliente cliente = (Cliente)xmlDecoder.readObject();
					xmlDecoder.close();
					temp.add(cliente);
				}				
			}
			return temp;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new PersistenciaException("Erro de persist�ncia");
		}
	}
}
