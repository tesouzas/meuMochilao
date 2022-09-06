package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import modelo.Cliente;

public class ClienteCrud {
	
	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int rg = 0;
		int cpf = 0;
		int id = 0;
		String nome = "";
		String email = "";
		String rua = "";
		String cidade = "";
		String estado = "";
		String complemento = "";
		

		do {
			System.out.println("=== CRUD clientes ===");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Consultar cliente");
			System.out.println("3 - Atualizar cliente");
			System.out.println("4 - Deletar cliente");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite seu nome: ");
				nome = s.nextLine();
				System.out.println("Digite o RG: ");
				rg = s.nextInt();
				System.out.println("Digite o CPF: ");
				cpf = s.nextInt();
				System.out.println("Digite o email: ");
				email = s.nextLine();
				s.nextLine();
				System.out.println("Digite a rua: ");
				rua = s.nextLine();
				s.nextLine();
				System.out.println("Digite a cidade: ");
				cidade = s.nextLine();
				s.nextLine();
				System.out.println("Digite o Estado: ");
				estado = s.nextLine();
				s.nextLine();
				System.out.println("Digite o complemento: ");
				complemento = s.nextLine();
				s.nextLine();
				
				
				Cliente r1 = new Cliente(id, nome, rg, cpf, email, rua, cidade, estado, complemento);

				clienteDAO.save(r1);

				System.out.println("\n***  Cadastro realizado com sucesso!  ***\n");

				break;
			case 2:
				// READ
				List<Cliente> clienteList = new ArrayList<Cliente>();
				clienteList = clienteDAO.getCliente();
				
				for (Cliente item : clienteList) {
					System.out.println(item);
				}
				
				System.out.println("Consulta realizada com sucesso!");
				break;
			
			case 3:
				// UPDATE
				System.out.println("Digite seu nome: ");
				nome = s.nextLine();
				System.out.println("Digite o RG: ");
				rg = s.nextInt();
				System.out.println("Digite o CPF: ");
				cpf = s.nextInt();
				System.out.println("Digite o email: ");
				email = s.nextLine();
				s.nextLine();
				System.out.println("Digite a rua: ");
				rua = s.nextLine();
				s.nextLine();
				System.out.println("Digite a cidade: ");
				cidade = s.nextLine();
				s.nextLine();
				System.out.println("Digite o Estado: ");
				estado = s.nextLine();
				s.nextLine();
				System.out.println("Digite o complemento: ");
				complemento = s.nextLine();
				s.nextLine();
				
				
				Cliente r2 = new Cliente(id, nome, rg, cpf, email, rua, cidade, estado, complemento);

				clienteDAO.update(r2);

				System.out.println("Atualizado com sucesso!");
				break;
				
			case 4:
				// DELETE
				System.out.println("Digite o id da cliente: ");
				posicao = s.nextInt();

				clienteDAO.deleteById(posicao);
				
				System.out.println("cliente deletada com sucesso!");
				
				break;
				
			case 5:
				// buscar por id
				System.out.println("Digite o id da cliente: ");
				posicao = s.nextInt();

				List<Cliente> r3 = clienteDAO.getClienteById(posicao);
				if(r3.isEmpty()) {
					System.out.println("Nenhuma cliente encontrada com este ID. Favor digitar ID válido.");
				}else {
					for (Cliente item : r3) 
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
