package com.proyecto.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.venta.entity.Pais;
import com.proyecto.venta.entity.Proveedor;
import com.proyecto.venta.services.PaisServices;
import com.proyecto.venta.services.ProveedorServices;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorServices servicioPro;
	
	@Autowired
	private PaisServices servicioPais;
	
	@RequestMapping("/lista")
	public String index (Model model) { //model interface{
		model.addAttribute("proveedores", servicioPro.listarProveedor());
		model.addAttribute("paises", servicioPais.listarPais());
		return "proveedor";
	}
	
	@RequestMapping("/grabar")
	public String grabar (@RequestParam("codigo") Integer cod,
						  @RequestParam("nombre") String nom,
						  @RequestParam("pais") int codPais,
						  @RequestParam("ruc") String ruc,
						  @RequestParam("fono") String fono,
						  @RequestParam("email") String email,
						  RedirectAttributes redirect) {
		try {
			Proveedor pro= new Proveedor();
			
			pro.setNombre(nom);
			
			Pais pais= new Pais();
			
			pais.setCodigo(codPais);
			pro.setPais(pais);
			pro.setRuc(ruc);
			pro.setFono(fono);
			pro.setEmail(email);
			
			if (cod==0) {
				//Invocar metodo registrar 
				servicioPro.registrar(pro);
				//Crear atirbuto de tipo flash
				redirect.addFlashAttribute("MENSAJE","Proveedor Registrado");
			}
			else {
				//setear atributo "codigo"
				pro.setCodigo(cod);
				servicioPro.actualizar(pro);
				redirect.addFlashAttribute("MENSAJE","Proveedor Actualizado");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/proveedor/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Proveedor buscar(@RequestParam("codigo") Integer cod) {
			return servicioPro.buscarPorId(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod, RedirectAttributes redirect) {
			servicioPro.eliminarPorId(cod);
			redirect.addFlashAttribute("MENSAJE","Proveedor eliminado");
			
			return "redirect:/proveedor/lista";
	}
}
