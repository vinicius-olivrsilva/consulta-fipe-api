package br.com.vinicius.olivrsilva.consulta_fipe_api.service;

import br.com.vinicius.olivrsilva.consulta_fipe_api.model.DadosMarcas;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

public class ConversorDados {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T serializador (String json, TypeReference<T> classe) {
        return mapper.readValue(json, classe);
    }
}
