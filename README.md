# **Desafio**



## Objetivos do projeto

- O objetivo do projeto é ter um fluxo similar ao que é feito no site https://veiculos.fipe.org.br/
- Criei um projeto Spring com linha de comando, utilizando a classe Scanner para fazer interações com o usuário via terminal.
- Solicitei que o usuário digitace o tipo de veículo desejado (carro, caminhão ou moto).
- Feito isso, foi listado todas as marcas daquele tipo de veículo, solicitando que o usuário escolha uma marca pelo código.
- Após essa escolha, foi listado todos os modelos de veículos daquela marca.
- Solicitamos que o usuário digite um trecho do modelo que ele quer visualizar, por exemplo **CAMARO**.
- É exibido uma lista apenas com os modelos que tiverem a palavra **CAMARO** no nome.
- O Usuário escolherá um modelo específico pelo código e, diferente do site, já lista os dados para **TODOS** os anos disponíveis daquele modelo.



## Observações:

- Para realização do desafio foi feito o consumo de uma API, documentada nesse link: https://deividfortuna.github.io/fipe/v2/

- De acordo com o escolhido (carro, moto, ou caminhão) vamos fazer uma chamada a um dos endpoints abaixo para buscar as marcas:
  https://fipe.parallelum.com.br/api/v2/cars/brands

  https://fipe.parallelum.com.br/api/v2/motorcycles/brands

  https://fipe.parallelum.com.br/api/v2/trucks/brands

- O retorno dessa requisição será uma lista com código e marca desejada. Caso o usuário queira por exemplo fazer uma consulta a modelos de carros da Chevrolet, que possui o código 23, terá que fazer uma nova requisição para o endpoint:
  https://fipe.parallelum.com.br/api/v2/cars/brands/23/models

- Feito isso, irá escolher um código de modelo, por exemplo esse **Camaro SS Collection 6.2 V8 16V**, representado pelo código 10946. Então deverá fazer uma terceira requisição para o endpoint: 
  https://fipe.parallelum.com.br/api/v2/cars/brands/23/models/10946/years/

- Para saber o valor para cada ano disponível, temos que fazer requisições pelo código por ano, onde obteremos um retorno similar ao que é mostrado abaixo:

  ```bash
  Veiculo{Valor: R$ 555.000,00, Marca: GM - Chevrolet, Modelo:Camaro SS Collection 6.2 V8 16V, Ano: 32000, combustível: Gasolina
  Veiculo{Valor: R$ 490.716,00, Marca: GM - Chevrolet, Modelo:Camaro SS Collection 6.2 V8 16V, Ano: 2024, combustível: Gasolina
  ```



## Tecnologias e Conceitos Utilizados

###  Linguagem e Framework
- **Java 21**
- **Spring Boot**
- **CommandLineRunner** (aplicação executada via terminal)

### Consumo de API
- **Java HttpClient (`java.net.http`)**
- Requisições HTTP GET
- API pública: **FIPE – Parallelum**

### Serialização / Desserialização
- **Jackson**
- Uso de:
  - `ObjectMapper`
  - `@JsonAlias`
  - `@JsonIgnoreProperties`
  - `TypeReference<T>`

### Modelagem
- Uso de **records** para modelos imutáveis
- Uso de **enum** para controle de tipo de veículo
- Separação clara entre:
  - `model`
  - `service`
  - `principal`

### Java Moderno
- **Streams**
- **Lambdas**
- **Imutabilidade**
- **Programação funcional básica**



## Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

- Aprender consumo de APIs REST em Java
- Praticar organização de código backend
- Aplicar conceitos modernos do Java
- Evoluir para projetos maiores com banco de dados futuramente



## Autor

**Vinícius Oliveira Silva**
 Estudante de Java | Backend Developer