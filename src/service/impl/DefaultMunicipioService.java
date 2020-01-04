package service.impl;

import java.util.Collection;

import domain.exception.MunicipioException;
import domain.model.Municipio;
import domain.model.UFVO;
import repository.MunicipioDAO;
import repository.jdbc.JdbcMunicipioDAO;
import service.MunicipioService;

public class DefaultMunicipioService implements MunicipioService {

	private MunicipioDAO dao = new JdbcMunicipioDAO();

	@Override
	public void validar(Municipio model) throws MunicipioException {
		model.validarUf();
		model.validarNome();
	}

	@Override
	public void salvar(Municipio model) throws MunicipioException {
		if (model.isNullId()) {
			dao.inserir(model);
		} else {
			dao.alterar(model);
		}
	}

	@Override
	public void apagar(Municipio model) throws MunicipioException {
		dao.apagar(model);
	}

	@Override
	public Collection<Municipio> listar(UFVO uf) throws MunicipioException {
		return dao.selecionar(uf);
	
	}
}
