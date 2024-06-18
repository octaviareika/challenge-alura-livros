package com.challenge.books.ListaLivro.Livro;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record InformacaoTotal(@JsonAlias("results") List<Livro> livros) {
    
}
