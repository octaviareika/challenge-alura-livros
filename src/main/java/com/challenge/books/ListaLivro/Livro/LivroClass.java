package com.challenge.books.ListaLivro.Livro;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "livro")
public class LivroClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int idLivro;
    private String titulo;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<AutorClass> autores = new ArrayList<>();
    private List<String> idiomas = new ArrayList<>();

    public LivroClass() {

    }

    public LivroClass(Livro livro) {
        this.idLivro = livro.id();
        this.titulo = livro.titulo();
        for (Autor autor : livro.autores()) {
            this.autores.add(new AutorClass(autor.name(), autor.birth_year(), autor.death_year()));
        }
        this.idiomas = livro.idiomas();
    }

    public LivroClass(Long id, int idLivro, String titulo, List<AutorClass> autores, List<String> assuntos, List<String> idiomas) {
        this.id = id;
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autores = autores;
        this.idiomas = idiomas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutorClass> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorClass> autores) {
        this.autores = autores;
    }


    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public String toString() {
        return "LivroClass [autores=" + autores + ", idiomas=" + idiomas + ", titulo=" + titulo
                + "]";
    }
}
