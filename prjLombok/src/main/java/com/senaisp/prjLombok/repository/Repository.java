package com.senaisp.prjLombok.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaisp.prjLombok.entities.Usuario;

public interface Repository extends JpaRepository<Usuario, Long>{

}