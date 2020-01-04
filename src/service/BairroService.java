package service;

import java.util.Collection;

import domain.exception.BairroException;
import domain.model.Bairro;
import domain.model.Municipio;
import domain.model.UFVO;

public interface BairroService extends Service<Bairro, BairroException> {

	Collection<Bairro> listar(Municipio municipio, UFVO uf) throws BairroException;
	
}
