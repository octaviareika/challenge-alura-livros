package com.challenge.books.ListaLivro.Livro;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversaoDados {

    public ConversaoDados(){}

    public String obterDados(String nomeLivro) throws IOException, InterruptedException{


        // se string possuir um espaço (como se fosse uma frase)
        if(nomeLivro.contains(" ")){
            // substitui o espaço por %20
            nomeLivro = nomeLivro.replace(" ", "+");
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://gutendex.com/books/?search=" + nomeLivro))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        return json;
    }
    
}
