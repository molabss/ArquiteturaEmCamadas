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
 * Implementação do contrato de persistência de clientes utilizando o framework JSE XML. Padrão de projeto 
 * Strategy do livro Padrões de Projeto em Java. A classe não é pública para não expor o serviço para fora
 * da camada.
 * @author Moisés Santana
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
			throw new PersistenciaException("Erro de persistência");
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
			throw new PersistenciaException("Erro de persistência");
		}
	}
}
