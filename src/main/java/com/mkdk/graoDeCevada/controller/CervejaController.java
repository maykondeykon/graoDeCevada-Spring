package com.mkdk.graoDeCevada.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkdk.graoDeCevada.model.Cerveja;
import com.mkdk.graoDeCevada.repository.CategoriaRepository;
import com.mkdk.graoDeCevada.repository.CervejaRepository;
import com.mkdk.graoDeCevada.repository.EmbalagemRepository;
import com.mkdk.graoDeCevada.repository.FaixaPrecoRepository;
import com.mkdk.graoDeCevada.repository.FermentacaoRepository;
import com.mkdk.graoDeCevada.repository.LitragemRepository;
import com.mkdk.graoDeCevada.repository.NacionalidadeRepository;
import com.mkdk.graoDeCevada.repository.PaisRepository;
import com.mkdk.graoDeCevada.repository.SaborRepository;
import com.mkdk.graoDeCevada.repository.TipoCervejaRepository;
import com.mkdk.graoDeCevada.repository.filter.CervejaFilter;

@Controller
@RequestMapping("/cerveja")
public class CervejaController {

	@Autowired
	private CervejaRepository repoCerveja;

	@Autowired
	private FermentacaoRepository repoFermentacao;

	@Autowired
	private CategoriaRepository repoCategoria;

	@Autowired
	private EmbalagemRepository repoEmbalagem;

	@Autowired
	private LitragemRepository repoLitragem;

	@Autowired
	private NacionalidadeRepository repoNacionalidade;

	@Autowired
	private PaisRepository repoPais;

	@Autowired
	private SaborRepository repoSabor;

	@Autowired
	private TipoCervejaRepository repoTipoCerveja;

	@Autowired
	private FaixaPrecoRepository repoFaixaPreco;

	@GetMapping("/novo")
	public ModelAndView novo(Cerveja cerveja) {

		ModelAndView mv = new ModelAndView("cerveja/novo");
		mv.addObject(cerveja);
		mv.addObject("categoriaList", repoCategoria.findAll());
		mv.addObject("embalagemList", repoEmbalagem.findAll());
		mv.addObject("fermentacaoList", repoFermentacao.findAll());
		mv.addObject("litragemList", repoLitragem.findAll());
		mv.addObject("nacionalidadeList", repoNacionalidade.findAll());
		mv.addObject("paisList", repoPais.findAll());
		mv.addObject("saborList", repoSabor.findAll());
		mv.addObject("tipoCervejaList", repoTipoCerveja.findAll());
		mv.addObject("faixaPrecoList", repoFaixaPreco.findAll());

		return mv;

	}

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Cerveja cerveja, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}

		repoCerveja.save(cerveja);
		String msg = "";
		if(cerveja.getId() == null){
			msg = "Cerveja salva com sucesso!";
		}else{
			msg = "Cerveja atualizada com sucesso!";
		}
		attributes.addFlashAttribute("mensagem", msg);
		return new ModelAndView("redirect:/cerveja/pesquisa");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Cerveja cerveja = repoCerveja.findOne(id);
		return novo(cerveja);
	}

	@GetMapping("/pesquisa")
	public ModelAndView pesquisa(CervejaFilter cervejaFilter) {
		ModelAndView mv = new ModelAndView("/cerveja/pesquisa");
		mv.addObject("cervejaList",
				repoCerveja.findByMarcaContainingIgnoreCase(Optional.ofNullable(cervejaFilter.getMarca()).orElse("%")));
		return mv;
	}

}
