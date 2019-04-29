package dougsneri.algaworks.cobranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import dougsneri.algaworks.cobranca.model.Titulo;
import dougsneri.algaworks.cobranca.repository.Titulos;

@Service
public class CadastroTituloService {

	@Autowired
	private Titulos titulos;
	
	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formtado de data inválido");
		}
	}

	public void excluir(Long codigo) {
		titulos.deleteById(codigo);
	}
}
