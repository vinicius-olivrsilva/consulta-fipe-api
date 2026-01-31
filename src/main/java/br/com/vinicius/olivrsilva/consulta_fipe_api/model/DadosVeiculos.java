package br.com.vinicius.olivrsilva.consulta_fipe_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculos (@JsonAlias("code") String codigo,
                             @JsonAlias("name") String descricao) {

}
