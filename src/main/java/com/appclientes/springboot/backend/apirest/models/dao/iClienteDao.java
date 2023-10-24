package com.appclientes.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appclientes.springboot.backend.apirest.models.entity.Cliente;

public interface iClienteDao extends JpaRepository<Cliente, Long>{

}
