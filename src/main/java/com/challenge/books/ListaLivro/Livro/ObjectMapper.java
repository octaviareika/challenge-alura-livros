package com.challenge.books.ListaLivro.Livro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class ObjectMapper {
    
    private com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();


    public <T> T converteDeJsonParaObjeto(String json, TypeReference<T> tipo) throws JsonProcessingException, JsonProcessingException {
        return mapper.readValue(json, tipo);

    }

    public <T> T converteDeJsonParaClasse(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json, classe);
    }
}
