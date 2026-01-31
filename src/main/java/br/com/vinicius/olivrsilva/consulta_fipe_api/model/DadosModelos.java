package br.com.vinicius.olivrsilva.consulta_fipe_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(@JsonAlias("code") String codigo,
                           @JsonAlias("name") String modelo) {

    @Override
    public String toString() {
        return "Código:" + codigo +
                "    Modelo: " + modelo;
    }
}
