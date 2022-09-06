package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import dao.HospedagemDAO;
import modelo.Hospedagem;

public class HospedagemCrud {
	public static void main(String[] args) {
		HospedagemDAO hospedagemDAO = new HospedagemDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		
		int id = 0;
		String nome = "";
		int qtddias = 0;
		double valor = 0;
		

		do {
			System.out.println("=== CRUD Hospedagem ===");
			System.out.println("1 - Cadastrar Hospedagem");
			System.out.println("2 - Consultar Hospedagem");
			System.out.println("3 - Atualizar Hospedagem");
			System.out.println("4 - Deletar Hospedagem");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite seu nome: ");
				nome = s.nextLine();
				System.out.println("Digite o valor: ");
				valor = s.nextInt();
				System.out.println("Digite a quantidade de diárias: ");
				qtddias = s.nextInt();
				
				
				Hospedagem h1 = new Hospedagem(id, nome, valor, qtddias);

				hospedagemDAO.save(h1);

				System.out.println("\n***  Cadastro realizado com sucesso!  ***\n");

				break;
			case 2:
				// READ
				List<Hospedagem> hospedagemList = new ArrayList<Hospedagem>();
				hospedagemList = hospedagemDAO.getHospedagem();
				
				for (Hospedagem item : hospedagemList) {
					System.out.println(item);
				}
				
				System.out.println("Consulta realizada com sucesso!");
				break;
			
			case 3:
				// UPDATE
				System.out.println("Digite seu nome: ");
				nome = s.nextLine();
				System.out.println("Digite o valor: ");
				valor = s.nextInt();
				System.out.println("Digite a quantidade de diárias: ");
				qtddias = s.nextInt();
				
				Hospedagem r2 = new Hospedagem(id, nome, valor, qtddias);

				hospedagemDAO.update(r2);

				System.out.println("Atualizado com sucesso!");
				break;
				
			case 4:
				// DELETE
				System.out.println("Digite o id da hospedagem: ");
				posicao = s.nextInt();

				hospedagemDAO.deleteById(posicao);
				
				System.out.println("Hospedagem deletada com sucesso!");
				
				break;
				
			case 5:
				// buscar por id
				System.out.println("Digite o id da hospedagem: ");
				posicao = s.nextInt();

				List<Hospedagem> h3 = hospedagemDAO.getHospedagemById(posicao);
				if(h3.isEmpty()) {
					System.out.println("Nenhuma hospedagem encontrada com este ID. Favor digitar ID válido.");
				}else {
					for (Hospedagem item : h3) 
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
