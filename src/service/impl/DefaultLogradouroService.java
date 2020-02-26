package service.impl;

import java.util.Collection;

import domain.exception.LogradouroException;
import domain.model.Bairro;
import domain.model.Logradouro;
import domain.model.Municipio;
import domain.model.UFVO;
import repository.LogradouroDAO;
import repository.jdbc.JdbcLogradouroDAO;
import service.LogradouroService;

public class DefaultLogradouroService implements LogradouroService {
	
	private LogradouroDAO dao = new JdbcLogradouroDAO(); 
	
	@Override
	public void validar(Logradouro model) throws LogradouroException {
		// TODO Auto-generated method stub
		
		model.validarMunicipio();
		model.validarBairro();
		model.validarNome();
	}

	@Override
	public void salvar(Logradouro model) throws LogradouroException {
		// TODO Auto-generated method stub
		if (model.isNullId()) {
			dao.inserir(model);
		} else {
			dao.alterar(model);
		}
	}

	@Override
	public void apagar(Logradouro model) throws LogradouroException {
		// TODO Auto-generated method stub
		dao.apagar(model);
	}


	@Override
	public Collection<Logradouro> listar(Bairro bairro, Municipio municipio, UFVO uf) throws LogradouroException {
		// TODO Auto-generated method stub
		return dao.selecionar(uf, municipio, bairro);
	}

}
