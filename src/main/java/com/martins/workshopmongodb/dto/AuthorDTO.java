package com.martins.workshopmongodb.dto;

import java.io.Serializable;

import com.martins.workshopmongodb.domain.User;

public class AuthorDTO implements Serializable {

	/*
	 * DTO (DATA TRANSFER OBJECT): É UM OBJETO QUE TEM O PAPEL DE CARREGAR DADOS DAS
	 * ENTIDADES DE FORMA SIMPLES,PODENDO INCLUSIVE "PROJETAR" APENAS ALGUNS DADOS
	 * DA ENTIDADE ORIGINAL.
	 */

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public AuthorDTO() {

	}

	/*
	 * CRIAÇAO DE CONSTRUTOR PARA ATRIBUIR O USUÁRIO AO AUTOR
	 */

	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * NÃO SE CRIA HASHCODE E EQUALS PARA OBJETOS DO TIPO DTO
	 */

}
