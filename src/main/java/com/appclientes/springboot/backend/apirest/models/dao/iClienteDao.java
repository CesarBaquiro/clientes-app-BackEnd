package com.appclientes.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.appclientes.springboot.backend.apirest.models.entity.Cliente;

public interface iClienteDao extends CrudRepository<Cliente, Long>{

}
