package com.mkdk.graoDeCevada.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mkdk.graoDeCevada.model.Avaliacao;
import com.mkdk.graoDeCevada.model.Cerveja;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
	
	public List<Avaliacao> findByCerveja(Cerveja cerveja);
	
}
