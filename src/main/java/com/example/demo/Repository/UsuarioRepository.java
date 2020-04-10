package com.example.demo.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UsuarioEntity;



@Repository("repositorio")
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Serializable> {
	
	public abstract UsuarioEntity findByUsuarioAndPassword(String usuario,String password);
	public abstract UsuarioEntity findByUsuario(String usuario);

}
