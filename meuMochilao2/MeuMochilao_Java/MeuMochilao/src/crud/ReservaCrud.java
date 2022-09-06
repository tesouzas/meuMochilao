package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ReservaDAO;
import modelo.Reserva;


public class ReservaCrud {
	
	public static void main(String[] args) {
		ReservaDAO reservaDAO = new ReservaDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String origem = "";
		String destino = "";
		String ida = "";
		String volta = "";
		double valor = 0;
		int acompanhantes = 0;
		String origem1 = "";
		String destino1 = "";
		String ida1 = "";
		String volta1 = "";
		double valor1 = 0;
		int acompanhantes1 = 0;
		
		

		do {
			System.out.println("=== CRUD Reservas ===");
			System.out.println("1 - Cadastrar Reserva");
			System.out.println("2 - Consultar Reserva");
			System.out.println("3 - Atualizar Reserva");
			System.out.println("4 - Deletar Reserva");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite a cidade de origem: ");
				origem = s.nextLine();
				System.out.println("Digite a cidade destino: ");
				destino = s.nextLine();
				System.out.println("Digite a data de IDA: ");
				ida = s.nextLine();
				s.nextLine();
				System.out.println("Digite a data de VOLTA: ");
				volta = s.nextLine();
				s.nextLine();
				System.out.println("Digite o número de acompanhantes: ");
				acompanhantes = s.nextInt();
				s.nextLine();
				System.out.println("Digite o valor da reserva: R$");
				valor = s.nextDouble();
				s.nextLine();
				
				
				Reserva r1 = new Reserva(origem, destino, ida, volta, valor, acompanhantes);

				reservaDAO.save(r1);

				System.out.println("\n***  Cadastro realizado com sucesso!  ***\n");

				break;
			case 2:
				// READ
				List<Reserva> reservaList = new ArrayList<Reserva>();
				reservaList = reservaDAO.getReserva();
				
				for (Reserva item : reservaList) {
					System.out.println(item);
				}
				
				System.out.println("Consulta realizada com sucesso!");
				break;
			
			case 3:
				// UPDATE
				System.out.println("Digite a cidade de origem: ");
				origem = s.nextLine();
				System.out.println("Digite a cidade destino: ");
				destino = s.nextLine();
				System.out.println("Digite a data de IDA: ");
				ida = s.nextLine();
				s.nextLine();
				System.out.println("Digite a data de VOLTA: ");
				volta = s.nextLine();
				s.nextLine();
				System.out.println("Digite o número de acompanhantes: ");
				acompanhantes = s.nextInt();
				s.nextLine();
				System.out.println("Digite o valor da reserva: R$");
				valor = s.nextDouble();
				s.nextLine();
				
				Reserva r2 = new Reserva(posicao, origem1, ida1, volta1, acompanhantes1, valor1);

				reservaDAO.update(r2);

				System.out.println("Atualizado com sucesso!");
				break;
				
			case 4:
				// DELETE
				System.out.println("Digite o id da Reserva: ");
				posicao = s.nextInt();

				reservaDAO.deleteById(posicao);
				
				System.out.println("Reserva deletada com sucesso!");
				
				break;
				
			case 5:
				// buscar por id
				System.out.println("Digite o id da Reserva: ");
				posicao = s.nextInt();

				List<Reserva> r3 = reservaDAO.getReservaById(posicao);
				if(r3.isEmpty()) {
					System.out.println("Nenhuma reserva encontrada com este ID. Favor digitar ID válido.");
				}else {
					for (Reserva item : r3) 
					{
						System.out.println(item);
					}
				}
		
				break;
				
			default:
				System.out.println(opcao != 0 ? "Opção inválida, digite novamente." : "");
				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();
	}

}
