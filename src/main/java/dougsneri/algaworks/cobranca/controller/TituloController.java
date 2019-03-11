package dougsneri.algaworks.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dougsneri.algaworks.cobranca.model.Titulo;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(Titulo titulo) {
		// TODO: Salvar no banco de dados
	}
}
