package service.impl;

import java.util.Collection;

import domain.exception.BairroException;
import domain.model.Bairro;
import domain.model.Municipio;
import domain.model.UFVO;
import repository.BairroDAO;
import repository.jdbc.JdbcBairroDAO;
import service.BairroService;

public class DefaultBairroService implements BairroService {

	/** DAO do Bairro */
	private BairroDAO dao = new JdbcBairroDAO();

	/** {@inheritDoc} */
	@Override
	public void validar(Bairro model) throws BairroException {
		model.validarMunicipio();
		model.validarNome();
	}

	/** {@inheritDoc} */
	@Override
	public void salvar(Bairro model) throws BairroException {
		if (model.isNullId()) {
			dao.inserir(model);
		} else {
			dao.alterar(model);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void apagar(Bairro model) throws BairroException {
		dao.apagar(model);
	}

	/** {@inheritDoc} */
	@Override
	public Collection<Bairro> listar(Municipio municipio, UFVO uf) throws BairroException {
		return dao.selecionar(municipio, uf);
	}

}
