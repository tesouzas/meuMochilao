package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.TransporteDAO;
import modelo.Transporte;

public class TransporteCrud {
	
	public static void main(String[] args) {
		TransporteDAO transporteDAO = new TransporteDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id_cia = 0;
		String nome = "";
		double valor = 0;
		

		do {
			System.out.println("=== CRUD Transportes ===");
			System.out.println("1 - Cadastrar transporte");
			System.out.println("2 - Consultar transporte");
			System.out.println("3 - Atualizar transporte");
			System.out.println("4 - Deletar transporte");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome da Cia de transporte: ");
				nome = s.nextLine();
				System.out.println("Digite o Valor total: ");
				valor = s.nextDouble();
				
				
				Transporte t1 = new Transporte(id_cia, nome, valor);

				transporteDAO.save(t1);

				System.out.println("\n***  Cadastro realizado com sucesso!  ***\n");

				break;
			case 2:
				// READ
				List<Transporte> transporteList = new ArrayList<Transporte>();
				transporteList = transporteDAO.getTransporte();
				
				for (Transporte item : transporteList) {
					System.out.println(item);
				}
				
				System.out.println("Consulta realizada com sucesso!");
				break;
			
			case 3:
				// UPDATE
				System.out.println("Digite o nome da Cia de transporte: ");
				nome = s.nextLine();
				System.out.println("Digite o Valor total: ");
				valor = s.nextDouble();
				
				
				Transporte t2 = new Transporte(id_cia, nome, valor);

				transporteDAO.update(t2);

				System.out.println("Atualizado com sucesso!");
				break;
				
			case 4:
				// DELETE
				System.out.println("Digite o id do transporte: ");
				posicao = s.nextInt();

				transporteDAO.deleteById(posicao);
				
				System.out.println("Transporte deletado com sucesso!");
				
				break;
				
			case 5:
				// buscar por id
				System.out.println("Digite o id do transporte: ");
				posicao = s.nextInt();

				List<Transporte> t3 = transporteDAO.getTransporteById(posicao);
				if(t3.isEmpty()) {
					System.out.println("Nenhum transporte encontrado com este ID. Favor digitar ID válido.");
				}else {
					for (Transporte item : t3) 
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
