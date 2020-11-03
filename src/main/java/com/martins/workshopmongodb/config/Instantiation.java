package com.martins.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.martins.workshopmongodb.domain.Post;
import com.martins.workshopmongodb.domain.User;
import com.martins.workshopmongodb.dto.AuthorDTO;
import com.martins.workshopmongodb.repository.PostRepository;
import com.martins.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		/*
		 * PARA QUE SEJA POSSIVEL ATRIBUIR UM AUTOR AO POST, É PRECISO PRIMEIRO QUE O
		 * USUARIO (USER), QUE É UM AUTOR SEJA SALVO, PARA ENTÃO INSTANCIAR OS POST,
		 * CASO CONTRÁRIO O ID DO AUTOR FICARÁ COMO NULL.
		 */

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acorde feliz, abraços !",
				new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
