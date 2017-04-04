package com.mkdk.graoDeCevada.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.mkdk.graoDeCevada.model.Avaliacao;
import com.mkdk.graoDeCevada.model.Cerveja;
import com.mkdk.graoDeCevada.repository.AvaliacaoRepository;
import com.mkdk.graoDeCevada.repository.CategoriaRepository;
import com.mkdk.graoDeCevada.repository.CervejaRepository;
import com.mkdk.graoDeCevada.repository.EmbalagemRepository;
import com.mkdk.graoDeCevada.repository.FaixaPrecoRepository;
import com.mkdk.graoDeCevada.repository.FermentacaoRepository;
import com.mkdk.graoDeCevada.repository.LitragemRepository;
import com.mkdk.graoDeCevada.repository.NacionalidadeRepository;
import com.mkdk.graoDeCevada.repository.PaisRepository;
import com.mkdk.graoDeCevada.repository.PerfilRepository;
import com.mkdk.graoDeCevada.repository.SaborRepository;
import com.mkdk.graoDeCevada.repository.TipoCervejaRepository;
import com.mkdk.graoDeCevada.repository.UsuarioReposistory;
import com.mkdk.graoDeCevada.repository.filter.CervejaFilter;
import com.mkdk.graoDeCevada.service.AvaliacaoService;

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
	
	@Autowired
	private AvaliacaoRepository repoAvaliacao;
	
	@Autowired
	private UsuarioReposistory repoUsuario;
	
	@Autowired
	private PerfilRepository repoPerfil;
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	/**
	 * TODO adicionar foto da cerveja
	 * @param cerveja
	 * @return
	 */
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

		String msg = "";
		if(cerveja.getId() == null){
			msg = "Cerveja inserida com sucesso!";
		}else{
			msg = "Cerveja atualizada com sucesso!";
		}
		
		repoCerveja.save(cerveja);
		
		attributes.addFlashAttribute("mensagem", msg);
		return new ModelAndView("redirect:/cerveja/pesquisa");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Cerveja cerveja = repoCerveja.findOne(id);
		return novo(cerveja);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		repoCerveja.delete(id);
		attributes.addFlashAttribute("mensagem", "Cerveja removida com sucesso");
		return "redirect:/cerveja/pesquisa";
	}

	/**
	 * @param cervejaFilter
	 * @return
	 */
	@GetMapping("/pesquisa")
	public ModelAndView pesquisa(CervejaFilter cervejaFilter) {
		ModelAndView mv = new ModelAndView("/cerveja/pesquisa");
		mv.addObject("avaliacaoService", avaliacaoService);
		mv.addObject("cervejaList",
				repoCerveja.findByMarcaContainingIgnoreCase(Optional.ofNullable(cervejaFilter.getMarca()).orElse("%")));
		return mv;
	}
	
	@PostMapping("/avalia")
	@ResponseBody
	public void contatoLido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long idCerveja = Long.parseLong(request.getParameter("idCerveja"));
		double aromaAval = Double.parseDouble(request.getParameter("aromaAval"));
		double aparenciaAval = Double.parseDouble(request.getParameter("aparenciaAval"));
		double saborAval = Double.parseDouble(request.getParameter("saborAval"));
		double sensacaoAval = Double.parseDouble(request.getParameter("sensacaoAval"));
		double conjuntoAval = Double.parseDouble(request.getParameter("conjuntoAval"));
		String msgAval = request.getParameter("msgAval");
		
		Cerveja cerveja = repoCerveja.findOne(idCerveja);
		if(cerveja != null){
			Avaliacao avaliacao = new Avaliacao();
			avaliacao.setCerveja(cerveja);
			avaliacao.setAparencia(aparenciaAval);
			avaliacao.setAroma(aromaAval);
			avaliacao.setConjunto(conjuntoAval);
			avaliacao.setSabor(saborAval);
			avaliacao.setSensacao(sensacaoAval);
			avaliacao.setComentario(msgAval);
			avaliacao.setUsuario(repoUsuario.findOne((long) 1));//TODO Pegar da sessão
			
			repoAvaliacao.save(avaliacao);
		}else{
			throw new Exception("Cerveja não encontrada");
		}
		
	}

}
