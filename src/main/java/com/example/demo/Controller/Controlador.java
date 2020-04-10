package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.UsuarioEntity;
import com.example.demo.Service.Servicio;

@RestController
@RequestMapping("apiLogin")
@CrossOrigin("*")
public class Controlador {
	
	@Autowired
	@Qualifier("servicioApi")
	private Servicio servicio;
	
	@PostMapping("/login/{usuario}/{password}")
	public boolean iniciarSesion(@PathVariable("usuario") String usuario,@PathVariable("password") String password) {
		return this.servicio.login(usuario,password);		
	}
	
	@PostMapping("/registrar")
	public boolean registrarUsuario (@RequestBody @Valid UsuarioEntity usuarioEntity) {
		return this.servicio.registrarUsuario(usuarioEntity);
	}

}
