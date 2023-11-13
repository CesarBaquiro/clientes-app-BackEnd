package com.appclientes.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appclientes.springboot.backend.apirest.models.entity.Cliente;
import com.appclientes.springboot.backend.apirest.models.entity.Region;

public interface IClienteDao extends JpaRepository<Cliente, Long>{
	
	//Utilizamos la notacion Query para personalizar las solicitudes desde JPA (Recordar que Region NO es la tabla, es el objeto en spring)
	@Query("from Region")
	public List<Region> findAllRegiones();
}
