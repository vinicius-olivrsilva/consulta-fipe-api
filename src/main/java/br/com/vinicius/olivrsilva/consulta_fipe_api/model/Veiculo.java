package br.com.vinicius.olivrsilva.consulta_fipe_api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(@JsonAlias("price") String valor,
                      @JsonAlias("brand") String marca,
                      @JsonAlias("model") String modelo,
                      @JsonAlias("modelYear") int ano,
                      @JsonAlias("fuel") String combustivel) {

    @Override
    public String toString() {
        return "Veiculo{" +
                "Valor: " + valor +
                ", Marca: " + marca +
                ", Modelo:" + modelo +
                ", Ano: " + ano +
                ", combustível: " + combustivel;
    }
}
