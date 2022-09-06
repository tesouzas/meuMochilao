package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioCrud {
	
	public static void main(String[] args) {
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	Scanner s = new Scanner(System.in);
	int opcao = 0;
	int posicao = 0;

	int rg = 0;
	int id = 0;
	String nome = "";
	int fone = 0;
	String login = "";
	String senha = "";
	
	do {
		System.out.println("=== CRUD usuarios ===");
		System.out.println("1 - Cadastrar usuario");
		System.out.println("2 - Consultar usuario");
		System.out.println("3 - Atualizar usuario");
		System.out.println("4 - Deletar usuario");
		System.out.println("5 - Buscar por id");
		System.out.println("0 - Sair");
		opcao = s.nextInt();
		s.nextLine();

		switch (opcao) {
		case 1:
			// CREATE
			System.out.println("Digite seu nome: ");
			nome = s.nextLine();
			System.out.println("Digite o fone: ");
			rg = s.nextInt();
			System.out.println("Digite o login: ");
			login = s.nextLine();
			s.nextLine();
			System.out.println("Digite a senha: ");
			senha = s.nextLine();
			
			
			
			
			Usuario u1 = new Usuario(id, nome, fone, login, senha);

			usuarioDAO.save(u1);

			System.out.println("\n***  Cadastro realizado com sucesso!  ***\n");

			break;
		case 2:
			// READ
			List<Usuario> usuarioList = new ArrayList<Usuario>();
			usuarioList = usuarioDAO.getUsuario();
			
			for (Usuario item : usuarioList) {
				System.out.println(item);
			}
			
			System.out.println("Consulta realizada com sucesso!");
			break;
		
		case 3:
			// UPDATE
			System.out.println("Digite seu nome: ");
			nome = s.nextLine();
			System.out.println("Digite o fone: ");
			rg = s.nextInt();
			System.out.println("Digite o login: ");
			login = s.nextLine();
			s.nextLine();
			System.out.println("Digite a senha: ");
			senha = s.nextLine();
			
			
			Usuario u2 = new Usuario(id, nome, fone, login, senha);

			usuarioDAO.update(u2);

			System.out.println("Atualizado com sucesso!");
			break;
			
		case 4:
			// DELETE
			System.out.println("Digite o id da usuario: ");
			posicao = s.nextInt();

			usuarioDAO.deleteById(posicao);
			
			System.out.println("Usuário deletado com sucesso!");
			
			break;
			
		case 5:
			// buscar por id
			System.out.println("Digite o id da usuario: ");
			posicao = s.nextInt();

			List<Usuario> u3 = usuarioDAO.getUsuarioById(posicao);
			if(u3.isEmpty()) {
				System.out.println("Nenhum usuario encontrada com este ID. Favor digitar ID válido.");
			}else {
				for (Usuario item : u3) 
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
