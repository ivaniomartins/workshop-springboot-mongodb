package com.martins.workshopmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martins.workshopmongodb.domain.Post;
import com.martins.workshopmongodb.domain.User;
import com.martins.workshopmongodb.dto.UserDTO;
import com.martins.workshopmongodb.repository.PostRepository;
import com.martins.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;

	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}



public User fromDTO(UserDTO objDto) {
	  return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
  }
}