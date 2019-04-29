package dougsneri.algaworks.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import dougsneri.algaworks.cobranca.model.StatusTitulo;
import dougsneri.algaworks.cobranca.model.Titulo;
import dougsneri.algaworks.cobranca.repository.Titulos;
import dougsneri.algaworks.cobranca.repository.filter.TituloFilter;

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

	public String receber(Long codigo) {
		Titulo titulo = titulos.getOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo);
		
		return StatusTitulo.RECEBIDO.getDescricao();
	}
	
	public List<Titulo> filtrar(TituloFilter filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return titulos.findByDescricaoContaining(descricao);
	}
}
