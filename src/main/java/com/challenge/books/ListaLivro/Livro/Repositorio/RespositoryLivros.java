package com.challenge.books.ListaLivro.Livro.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.books.ListaLivro.Livro.AutorClass;
import com.challenge.books.ListaLivro.Livro.LivroClass;

public interface RespositoryLivros extends JpaRepository<LivroClass, Long>{


    // procurar autor por meio do livro
   //c void procurarAutorPorLivro();

   

}
