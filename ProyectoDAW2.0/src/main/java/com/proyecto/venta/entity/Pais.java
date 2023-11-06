package com.proyecto.venta.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name= "tb_pais")
public class Pais {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cod_pais")
	private Integer codigo;
	@Column (name = "nom_pais")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pais")
	private List<Proveedor> listapais;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Proveedor> getListapais() {
		return listapais;
	}

	public void setListapais(List<Proveedor> listapais) {
		this.listapais = listapais;
	}
	
	

}
