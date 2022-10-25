package br.com.meumochilao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.meumochilao.model.Cadastro;
import br.com.meumochilao.repository.CadastroRepository;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cadastro/listar");

		List<Cadastro> cadastros = cadastroRepository.findAll();
		modelAndView.addObject("cadastros", cadastros);

		return modelAndView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro");

		modelAndView.addObject("cadastro", new Cadastro());

		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Cadastro cadastro) {

		ModelAndView modelAndView = new ModelAndView("redirect:/cadastro");

		cadastroRepository.save(cadastro);

		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id) {

		ModelAndView modelAndView = new ModelAndView("redirect:/cadastro");

		cadastroRepository.deleteById(id);

		return modelAndView;

	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cadastro/edicao");
		
		Cadastro cadastro = cadastroRepository.getReferenceById(id);
		modelAndView.addObject("cadastro", cadastro);
		
		return modelAndView;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Cadastro cadastro) {
		ModelAndView modelAndView = new ModelAndView("redirect:/cadastro");
		cadastroRepository.save(cadastro);
		
		return modelAndView;
	}

}
