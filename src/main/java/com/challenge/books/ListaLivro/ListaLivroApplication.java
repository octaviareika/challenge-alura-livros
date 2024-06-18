package com.challenge.books.ListaLivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.challenge.books.ListaLivro.Livro.Repositorio.RespositoryLivros;
import com.challenge.books.ListaLivro.Principal.Principal;

@SpringBootApplication
public class ListaLivroApplication implements CommandLineRunner{

	@Autowired
	RespositoryLivros respositoryLivros;
	public static void main(String[] args) {
		SpringApplication.run(ListaLivroApplication.class, args);
	}

	@Override	
	public void run(String... args) throws Exception {
		Principal principal = new Principal(respositoryLivros);
	}

}
