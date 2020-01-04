package service;

import java.util.Collection;

import domain.exception.ClienteException;
import domain.model.Cliente;
import domain.model.Municipio;



public interface ClienteService extends Service<Cliente, ClienteException> {

	Collection<Cliente> listar(Municipio m) throws ClienteException;
	
}
