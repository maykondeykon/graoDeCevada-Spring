package com.mkdk.graoDeCevada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdk.graoDeCevada.model.Avaliacao;
import com.mkdk.graoDeCevada.model.Cerveja;
import com.mkdk.graoDeCevada.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repoAvaliacao;

	public double getAvaliacaoGeral(Cerveja cerveja) {
		double avaliacaoGeral = 0.0;
		
		List<Avaliacao> avaliacao = repoAvaliacao.findByCerveja(cerveja);
		double aparencia = 0.0;
		double aroma = 0.0;
		double conjunto = 0.0;
		double sabor = 0.0;
		double sensacao = 0.0;

		for (Avaliacao aval : avaliacao) {
			aparencia += aval.getAparencia();
			aroma += aval.getAroma();
			conjunto += aval.getConjunto();
			sabor += aval.getSabor();
			sensacao += aval.getSensacao();
		}

		avaliacaoGeral = (aparencia + aroma + conjunto + sabor + sensacao) / 5;

		return avaliacaoGeral;

	}

}
