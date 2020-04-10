package com.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UsuarioEntity;
import com.example.demo.Repository.UsuarioRepository;

@Service("servicioApi")
public class Servicio {
	
	@Autowired
	@Qualifier("repositorio")
	private UsuarioRepository usuarioRepository;
	
	public boolean registrarUsuario(UsuarioEntity usuarioEntity) {
		boolean retornar=false;
		if(this.usuarioRepository.findByUsuario(usuarioEntity.getUsuario()) !=null) {
			retornar=false;
		}else {
			
			try {
				this.usuarioRepository.save(usuarioEntity);
				retornar= true;
			} catch (Exception e) {
				retornar= false;
			}			
			
		}
		return retornar;		
	}
	
	public boolean login(String usuario, String password) {
		boolean retorno=false;			
			if(this.usuarioRepository.findByUsuarioAndPassword(usuario, password) != null) {
				retorno= true;
			}		
		return retorno;
	}

}
