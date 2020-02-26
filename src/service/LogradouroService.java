package service;

import java.util.Collection;

import domain.exception.LogradouroException;
import domain.model.Bairro;
import domain.model.Logradouro;
import domain.model.Municipio;
import domain.model.UFVO;

public interface LogradouroService extends Service<Logradouro, LogradouroException>{
	
	
	Collection<Logradouro> listar(Bairro bairro, Municipio municipio, UFVO uf) throws LogradouroException;
}
