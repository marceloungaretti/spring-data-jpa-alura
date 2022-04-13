package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CargoService;
import br.com.alura.spring.data.service.FuncionarioService;
import br.com.alura.spring.data.service.RelatoriosService;
import br.com.alura.spring.data.service.UnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	private Boolean system = true;

	private final CargoService cargoService;
	private final FuncionarioService funcionarioService;
	private final UnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;

	public SpringDataApplication(CargoService cargoService,
								 FuncionarioService funcionarioService,
								 UnidadeTrabalhoService unidadeTrabalhoService,
								 RelatoriosService relatoriosService){
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system) {
			System.out.println("Qual ação você deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionário");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatórios");

			int action = scanner.nextInt();
			switch (action) {
				case 1:
					cargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}
