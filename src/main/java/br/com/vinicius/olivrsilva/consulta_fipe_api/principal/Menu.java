package br.com.vinicius.olivrsilva.consulta_fipe_api.principal;

import br.com.vinicius.olivrsilva.consulta_fipe_api.model.*;
import br.com.vinicius.olivrsilva.consulta_fipe_api.service.ConsomeApiService;
import br.com.vinicius.olivrsilva.consulta_fipe_api.service.ConversorDados;
import tools.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    //    private final String ENDERECO = "https://fipe.parallelum.com.br/api/v2/cars/brands/21/models/545/years";
    private final String URL_ENDERECO = "https://fipe.parallelum.com.br/api/v2/";
    private final String URL_MODELO = "/models/";   // vai até /models/
    private final String URL_ANO = "/years/";
    private ConsomeApiService consomeApi = new ConsomeApiService();
    private ConversorDados conversorDados = new ConversorDados();

    public void menuInicial() {
        // Consulta Marcas
        System.out.println("""
                Consulta Fipe API
                Qual o tipo de veículo você deseja pesquisar: (Carro, Moto ou Caminhão)? """);
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
        String enderecoMarcas = URL_ENDERECO + tipoVeiculo;

        String json = consomeApi.consomeApiFipe(enderecoMarcas);
        List<DadosMarcas> marcas = conversorDados.serializador(json, new TypeReference<List<DadosMarcas>>() {
        });
        marcas.forEach(System.out::println);

        // Consulta Modelo
        System.out.print("Qual marca você deseja pesquisar? Busque pelo código. \nCódigo: ");
        String codigoMarca = scanner.nextLine().trim();
        json = consomeApi.consomeApiFipe(URL_ENDERECO + tipoVeiculo + codigoMarca + URL_MODELO);
        List<DadosModelos> dadosModelos = conversorDados.serializador(json, new TypeReference<List<DadosModelos>>() {
        });
        dadosModelos.forEach(System.out::println);

        // Consultando por trecho do modelo
        System.out.println("Digite um trecho do nome do veículo para consulta: ");
        String buscaTrecho = scanner.nextLine().toLowerCase();
        List<DadosModelos> modelosList = dadosModelos.stream()
                .filter(d -> d.modelo().toLowerCase().contains(buscaTrecho))
                .toList();
        modelosList.forEach(System.out::println);

        // Exibir todos os veículos por ano daquele modelo
        System.out.println("Digite o código do modelo para consultar valores: ");
        String codigoModelo = scanner.nextLine();
        json = consomeApi.consomeApiFipe(URL_ENDERECO + tipoVeiculo + codigoMarca + URL_MODELO + codigoModelo + URL_ANO);
        List<DadosVeiculos> dadosVeiculos = conversorDados.serializador(json, new TypeReference<List<DadosVeiculos>>() {
        });

        List<String> anosList = dadosVeiculos.stream()
                .map(DadosVeiculos::codigo)
                .toList();

        List<Veiculo> listaVeiculos = new ArrayList<>();
        String enderecoAnos = URL_ENDERECO + tipoVeiculo + codigoMarca + URL_MODELO + codigoModelo + URL_ANO;
        for (int i = 0; i < dadosVeiculos.size(); i++) {
            json = consomeApi.consomeApiFipe(enderecoAnos + anosList.get(i));
            Veiculo veiculo = conversorDados.serializador(json, Veiculo.class);
            listaVeiculos.add(veiculo);
        }

        listaVeiculos.forEach(System.out::println);
    }
}
