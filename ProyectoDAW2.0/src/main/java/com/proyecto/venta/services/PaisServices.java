package com.proyecto.venta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.entity.Pais;
import com.proyecto.venta.repository.PaisRepository;


@Service
public class PaisServices {

	@Autowired
	private PaisRepository repoPais;
	
	public List<Pais> listarPais(){
		return repoPais.findAll();
	}
}
