package com.proyecto.venta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.venta.entity.Proveedor;
import com.proyecto.venta.repository.ProveedorRepository;

@Service
public class ProveedorServices {
	@Autowired
	private ProveedorRepository repoProveedor;
	
	public void registrar (Proveedor pro) {
		repoProveedor.save(pro);
	}
	public void actualizar (Proveedor pro) {
		repoProveedor.save(pro);
	}
	public void eliminarPorId (Integer cod) {
		repoProveedor.deleteById(cod);
	}
	public Proveedor buscarPorId(Integer cod) {
		return repoProveedor.findById(cod).orElse(null);
	}
	public List<Proveedor> listarProveedor(){
		return repoProveedor.findAll();
	}

}
