package com.challenge.books.ListaLivro.Principal;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.challenge.books.ListaLivro.Livro.Autor;
import com.challenge.books.ListaLivro.Livro.AutorClass;
import com.challenge.books.ListaLivro.Livro.ConversaoDados;
import com.challenge.books.ListaLivro.Livro.InformacaoTotal;
import com.challenge.books.ListaLivro.Livro.LivroClass;
import com.challenge.books.ListaLivro.Livro.ObjectMapper;
import com.challenge.books.ListaLivro.Livro.Repositorio.RespositoryLivros;

public class Principal {

    public boolean tentativa = true;
    RespositoryLivros respositoryLivros;
    public int opcao;
    public Scanner scanner = new Scanner(System.in);
    public ConversaoDados conversaoDados = new ConversaoDados();
    public ObjectMapper objectMapper = new ObjectMapper();
    public Principal(RespositoryLivros respositoryLivros) {
        this.respositoryLivros = respositoryLivros;
        while (tentativa){
            System.out.println("Olá, seja bem-vindo ao sistema de listagem de livros!");
            System.out.println("1 - Buscar livro pelo título");
            System.out.println("2 - Listar livros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos em um determinado período");
            System.out.println("5 - Listar livros em um determinado idioma");
            System.out.println("6 - Sair");

            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao){
                case 1:
                    System.out.println("Digite o título do livro: ");
                    String nomeLivro = scanner.nextLine();
                    try {
                        String json = conversaoDados.obterDados(nomeLivro); // ok
                        // converter o json para objeto
                        InformacaoTotal informacaoTotal = objectMapper.converteDeJsonParaClasse(json, InformacaoTotal.class);
                        //System.out.println(informacaoTotal);
                        
                        informacaoTotal.livros().forEach(livro -> {
                            LivroClass livroClass = new LivroClass(livro);
                            System.out.println(livroClass.toString());
                            respositoryLivros.save(livroClass);
                        
                        });
                    } catch (Exception e) {
                        System.out.println("Erro ao buscar livro: " + e.getMessage());
                    }

                    
                    
                    break;
                case 2:
                    buscarListarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    System.out.println("Listar autores vivos em um determinado período");
                    System.out.println("Digite o ano de início: ");
                    int anoInicio = scanner.nextInt();
                    System.out.println("Digite o ano de fim: ");
                    int anoFim = scanner.nextInt();
                    listarAutoresVivosEmDeterminadoPeriodo(anoInicio, anoFim);
                    break;
                case 5:
                    System.out.println("Listar livros em um determinado idioma");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    tentativa = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }


    public void buscarListarLivrosRegistrados(){
        System.out.println("Listar livros registrados");
        System.out.println(respositoryLivros.findAll().toString());
    }


    public void listarAutoresRegistrados(){
        System.out.println("Listar autores registrados");
        List<AutorClass> autores = respositoryLivros.findAll().stream()
                .flatMap(livro -> livro.getAutores().stream()).toList();
        System.out.println(autores.toString());        
    }

    public void listarAutoresVivosEmDeterminadoPeriodo(int anoInicio, int anoFim){
        System.out.println("Listar autores vivos em um determinado período");

        List<AutorClass> autores = respositoryLivros.findAll().stream()
                .flatMap(livro -> livro.getAutores().stream().
                        filter(autor -> autor.getBirth_year() >= anoInicio && autor.getDeath_year() <= anoFim)).toList();

        if (autores.isEmpty()){
            System.out.println("Nenhum autor encontrado!");
        }
        else{
            autores.forEach(autor -> System.out.println(autor.toString()));
        }
        
    }
    

    public void listarLivrosEmUmIdioma(String idioma){
        System.out.println("Listar livros em um determinado idioma");
        List<LivroClass> livros = respositoryLivros.findAll().stream()
                .filter(livro -> livro.getIdiomas().contains(idioma)).toList();
        System.out.println(livros.toString());
    }
}
