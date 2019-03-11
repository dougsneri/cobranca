package dougsneri.algaworks.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dougsneri.algaworks.cobranca.model.StatusTitulo;
import dougsneri.algaworks.cobranca.model.Titulo;
import dougsneri.algaworks.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	public static final String CADASTRO_TITULO = "CadastroTitulo";

	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_TITULO);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		titulos.save(titulo);
		
		ModelAndView mv = new ModelAndView(CADASTRO_TITULO);
		mv.addObject("mensagem", "Título salvo com sucesso!!!");
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulos")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
