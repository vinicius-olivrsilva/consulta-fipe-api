package br.com.vinicius.olivrsilva.consulta_fipe_api.model;

public enum TipoVeiculo {
    CARROS("cars"),
    MOTOS("motorcycles"),
    CAMINHOES("trucks");

    private String url;

    TipoVeiculo(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
