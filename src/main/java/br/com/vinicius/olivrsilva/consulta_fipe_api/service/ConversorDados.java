package br.com.vinicius.olivrsilva.consulta_fipe_api.service;

import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class ConversorDados {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T serializador (String json, TypeReference<T> tipo) {
        try {
            return mapper.readValue(json, tipo);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T serializador (String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }
}
