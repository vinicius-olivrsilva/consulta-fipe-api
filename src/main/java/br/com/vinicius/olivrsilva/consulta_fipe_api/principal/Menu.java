package br.com.vinicius.olivrsilva.consulta_fipe_api.principal;

import br.com.vinicius.olivrsilva.consulta_fipe_api.model.DadosMarcas;
import br.com.vinicius.olivrsilva.consulta_fipe_api.model.DadosModelos;
import br.com.vinicius.olivrsilva.consulta_fipe_api.model.TipoVeiculo;
import br.com.vinicius.olivrsilva.consulta_fipe_api.service.ConsomeApiService;
import br.com.vinicius.olivrsilva.consulta_fipe_api.service.ConversorDados;
import tools.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    //    private final String ENDERECO = "https://fipe.parallelum.com.br/api/v2/cars/brands/21/models/545/years";
    private final String ENDERECO = "https://fipe.parallelum.com.br/api/v2/";
    private ConsomeApiService consomeApi = new ConsomeApiService();
    private ConversorDados conversorDados = new ConversorDados();

    public void menuInicial() {
//        String MODELO = "/models/545";    // vai até models/
//        String ANO = "/years";

        // Consulta Marcas
        System.out.println("""
                Consulta Fipe API
                Qual o tipo de veículo você deseja pesquisar: (Carro, Moto ou Caminhão)?
                """);
        String tipo = scanner.nextLine().toLowerCase().trim();

        TipoVeiculo tipoSelecionado;

        if (tipo.contains("car")) {
            tipoSelecionado = TipoVeiculo.CARROS;
        } else if (tipo.contains("mot")) {
            tipoSelecionado = TipoVeiculo.MOTOS;
        } else {
            tipoSelecionado = TipoVeiculo.CAMINHOES;
        }
        String tipoVeiculo = tipoSelecionado.getUrl() + "/brands/"; // vai até brands (marcas)
        String enderecoMarcas = ENDERECO + tipoVeiculo; // vai até brands (marcas)

        String json = consomeApi.consomeApiFipe(enderecoMarcas);
        List<DadosMarcas> marcas = conversorDados.serializador(json, new TypeReference<List<DadosMarcas>>() {});
        marcas.forEach(System.out::println);

        // Consulta Modelo
        System.out.print("""
                Qual marca você deseja pesquisar? Busque pelo código.
                Código: """);
        String codigo = scanner.nextLine().trim();
        json = consomeApi.consomeApiFipe(ENDERECO + tipoVeiculo + codigo + "/models/"); // vai até /models/
        List<DadosModelos> dadosModelos = conversorDados.serializador(json, new TypeReference<List<DadosModelos>>() {});
        dadosModelos.forEach(System.out::println);

        // Consultando por trecho do modelo
        // Acredito que seja criar uma lista a partir da requisição anterior
    }
}
