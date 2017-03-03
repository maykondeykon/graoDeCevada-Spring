package com.mkdk.graoDeCevada.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkdk.graoDeCevada.model.Cerveja;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

	public List<Cerveja> findByMarcaContainingIgnoreCase(String marca);

}
