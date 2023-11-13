package com.appclientes.springboot.backend.apirest.models.dao;

import com.appclientes.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	    Optional<Usuario> findByUsername(String username);

	    @Query("select u from Usuario u where u.username = ?1")
	    Optional<Usuario> getName(String username);

}


