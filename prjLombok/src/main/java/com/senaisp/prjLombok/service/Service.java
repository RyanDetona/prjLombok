package com.senaisp.prjLombok.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.senaisp.prjLombok.entities.Usuario;
import com.senaisp.prjLombok.repository.Repository;

public class Service {

	private Repository usuarioRepository;

	@Autowired
	public void UsuarioService (Repository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	// preparando as buscas por id
	public Usuario findUsuarioById(Long id) {
		Optional<Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.orElse(null);
	}

	// preparando a busca geral
	public List<Usuario> findAllUsuario() {
		return usuarioRepository.findAll();
	}

	// salvando o Jogo
	public Usuario insertUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// fazendo o update do jogo com o optional
	public Usuario updateUsuario(Long id, Usuario novoUsuario) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			Usuario usuarioExistente = usuarioOptional.get();
			usuarioExistente.setNome(novoUsuario.getNome());
			usuarioExistente.setEmail(novoUsuario.getEmail());
			return usuarioRepository.save(usuarioExistente);
		} else {
			return null;
		}
	}

	// deletando o update do usuario com o optional
	public boolean deleteUsuario(Long id) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
		if (usuarioExistente.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}



}
