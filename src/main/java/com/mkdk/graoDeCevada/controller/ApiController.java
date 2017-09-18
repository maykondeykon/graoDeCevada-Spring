package com.mkdk.graoDeCevada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mkdk.graoDeCevada.model.Cerveja;
import com.mkdk.graoDeCevada.repository.CervejaRepository;
import com.mkdk.graoDeCevada.service.AvaliacaoService;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private CervejaRepository repoCerveja;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/cervejas")
    public List<Cerveja> cervejas() {
	return repoCerveja.findAll();
    }

    @GetMapping("/ranking")
    public List<Cerveja> ranking() {
	return avaliacaoService.getRanking();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	ObjectMapper mapper = new ObjectMapper();
	mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
	return converter;
    }

}
