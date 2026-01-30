package br.com.vinicius.olivrsilva.consulta_fipe_api;

import br.com.vinicius.olivrsilva.consulta_fipe_api.principal.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaFipeApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaFipeApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu();
		menu.menuInicial();
	}
}
