package connection;

import java.sql.Connection;
import java.sql.DriverManager;

	public class ConnectionMySQL {
		
		private static String URL = "jdbc:mysql://localhost:3306/meumochilao";
		private static String USUARIO = "root";
		private static String SENHA = "Ste9124#";
		
		public static Connection createConnectionMySQL() throws Exception {
			// Faz com que a classe seja carregada pela JVM
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Cria conexão com banco de dados 
			Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("\n\n ****  Conexão obtida com sucesso!  ****");
			return connection;
		}

//		public static void main(String[] args) throws Exception {
//			// Recupera uma conexão com o banco de dados
//			Connection con = createConnectionMySQL();
//			
//			// testar a conexão 
//			if (con != null) {
//				System.out.println(con + "\n\n ****  Conexão obtida com sucesso!  ****");
//				con.close();
//			}
//		}
	}
