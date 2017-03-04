package com.mkdk.graoDeCevada.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkdk.graoDeCevada.model.Cerveja;
import com.mkdk.graoDeCevada.model.Contato;
import com.mkdk.graoDeCevada.repository.ContatoRepository;
import com.mkdk.graoDeCevada.repository.FaixaPrecoRepository;

@Controller
@RequestMapping("/")
public class SiteController {
	
	@Autowired
	private ContatoRepository repoContato;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("site/index");

		return mv;
	}

	@GetMapping("/contato")
	public ModelAndView contato(Contato contato) {
		ModelAndView mv = new ModelAndView("site/contato");
		
		return mv;
	}
	
	@PostMapping("/contato")
	public ModelAndView salvar(@Valid Contato contato, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return contato(contato);
		}

		repoContato.save(contato);
		
		attributes.addFlashAttribute("mensagem", "Email enviado com sucesso!");
		return new ModelAndView("redirect:/contato");
	}
	
	@GetMapping("/ranking")
	public ModelAndView ranking() {
		ModelAndView mv = new ModelAndView("site/ranking");

		return mv;
	}
}
