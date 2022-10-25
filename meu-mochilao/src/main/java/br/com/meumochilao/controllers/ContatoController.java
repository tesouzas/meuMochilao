package br.com.meumochilao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.meumochilao.model.Contato;
import br.com.meumochilao.repository.ContatoRepository;

/**
 * 
 * @author Stephanie
 *
 */
@Controller
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;

	@GetMapping
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("contato/listar");

		List<Contato> contatos = contatoRepository.findAll();
		modelAndView.addObject("contatos", contatos);

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		
		ModelAndView modelAndView = new ModelAndView("contato/cadastrar.html");

		modelAndView.addObject("contato", new Contato());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Contato contato) {

		ModelAndView modelAndView = new ModelAndView("redirect:/contato");

		contatoRepository.save(contato);

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id) {

		ModelAndView modelAndView = new ModelAndView("redirect:/contato");

		contatoRepository.deleteById(id);

		return modelAndView;

	}

	/*
	 * @GetMapping("/{id}/editar") public ModelAndView editar(@PathVariable Long id)
	 * { ModelAndView modelAndView = new ModelAndView("contato/edicao");
	 * 
	 * Contato contato = contatoRepository.getById(id);
	 * modelAndView.addObject("contato", contato);
	 * 
	 * return modelAndView; }
	 * 
	 * @PostMapping("/{id}/editar") public ModelAndView editar(Contato contato) {
	 * ModelAndView modelAndView = new ModelAndView("redirect:/contato");
	 * contatoRepository.save(contato);
	 * 
	 * return modelAndView; }
	 */

}
