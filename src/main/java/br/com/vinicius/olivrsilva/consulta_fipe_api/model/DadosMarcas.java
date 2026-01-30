package br.com.vinicius.olivrsilva.consulta_fipe_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarcas(@JsonAlias("code") String codigo,
                          @JsonAlias("name") String marca) {

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Marca:" + marca;
    }
}
