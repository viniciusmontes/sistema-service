package service.impl;

import java.util.Collection;

import domain.exception.ClienteException;
import domain.model.Cliente;
import domain.model.Municipio;
import repository.ClienteDAO;
import repository.jdbc.JdbcClienteDAO;
import service.ClienteService;

public class DefaultClienteService implements ClienteService {

	private ClienteDAO dao = new JdbcClienteDAO();

	@Override
	public void validar(Cliente model) throws ClienteException {
		// TODO Auto-generated method stub
		model.validarNome();
		model.validarSobrenome();
		model.validarEstadoCivil();
		model.validarSexo();
		model.validarDataNascimento();
	}

	@Override
	public void salvar(Cliente model) throws ClienteException {
		// TODO Auto-generated method stub
		if (model.isNullId()) {
			dao.inserir(model);
		} else {
			dao.alterar(model);
		}
	}

	@Override
	public void apagar(Cliente model) throws ClienteException {
		// TODO Auto-generated method stub
		dao.apagar(model);
	}

	@Override
	public Collection<Cliente> listar(Municipio municipio) throws ClienteException {
		return dao.selecionar(municipio);
	}

}
