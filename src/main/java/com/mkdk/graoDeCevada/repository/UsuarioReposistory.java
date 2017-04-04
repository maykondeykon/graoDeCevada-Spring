package com.mkdk.graoDeCevada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkdk.graoDeCevada.model.Usuario;

public interface UsuarioReposistory extends JpaRepository<Usuario, Long> {

}
