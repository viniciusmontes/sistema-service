package service;

public interface Service<M, E extends Exception> {

	void validar(M model) throws E;

	void salvar(M model) throws E;

	void apagar(M model) throws E;

}
