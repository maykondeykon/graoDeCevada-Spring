package com.mkdk.graoDeCevada.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkdk.graoDeCevada.model.Cerveja;
import com.mkdk.graoDeCevada.model.Contato;
import com.mkdk.graoDeCevada.repository.CervejaRepository;
import com.mkdk.graoDeCevada.repository.ContatoRepository;
import com.mkdk.graoDeCevada.repository.FaixaPrecoRepository;
import com.mkdk.graoDeCevada.repository.filter.CervejaFilter;

@Controller
@RequestMapping("/")
public class SiteController {

	@Autowired
	private ContatoRepository repoContato;
	
	@Autowired
	private CervejaRepository repoCerveja;

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

	@GetMapping("/contato/entrada")
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/site/contatoEntrada");
		mv.addObject("contatoList", repoContato.findAll());
		return mv;
	}

	@GetMapping("/contato/lido/{id}")
	@ResponseBody
	public void contatoLido(@PathVariable Long id, RedirectAttributes attributes) {
		Contato contato = repoContato.findOne(id);
		boolean lido = (contato.getLido()) ? false : true;
		contato.setLido(lido);
		repoContato.save(contato);
	}
	
	@DeleteMapping("/contato/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		repoContato.delete(id);
		attributes.addFlashAttribute("mensagem", "Mensagem removida com sucesso");
		return "redirect:/contato/entrada";
	}

	@GetMapping("/ranking")
	public ModelAndView ranking() {
		ModelAndView mv = new ModelAndView("site/ranking");

		return mv;
	}
}
