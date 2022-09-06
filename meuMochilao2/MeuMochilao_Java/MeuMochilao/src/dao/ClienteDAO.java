package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Cliente;


public class ClienteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Método pra salvar
	public void save(Cliente clientes) {
		String sql = "INSERT INTO cliente (rg_cliente, cpf_cliente, email_cliente, rua, cidade, estado, complemento) "
				+ "values(?, ?, ?, ?, ?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setInt(1, clientes.getRg());
			
			pstm.setInt(2, clientes.getCpf());
			
			pstm.setString(3, clientes.getEmail());
			
			pstm.setString(4, clientes.getRua());

			pstm.setString(5, clientes.getCidade());
			
			pstm.setString(6, clientes.getEstado());
			
			pstm.setString(7, clientes.getComplemento());
			
			
			
			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo para Ler
	public List<Cliente> getCliente() {
		String sql = "select * from cliente;";

		List<Cliente> listaDeCliente = new ArrayList<Cliente>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Cliente clientes = new Cliente();
				
				clientes.setId(rset.getInt("id_cliente"));
				
				clientes.setRg(rset.getInt("rg_cliente"));
				
				clientes.setCpf(rset.getInt("cpf_cliente"));
				
				clientes.setEmail(rset.getString("email_cliente"));

				clientes.setRua(rset.getString("rua"));
				
				clientes.setCidade(rset.getString("cidade"));
				
				clientes.setEstado(rset.getString("estado"));
				
				clientes.setComplemento(rset.getString("complemento"));
				
				
				clientes.toString();
				listaDeCliente.add(clientes);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listaDeCliente;
	}
	
	public List<Cliente> getClienteById(int id) {
		String sql = "select * from cliente WHERE id_cliente= ?;";

		List<Cliente> listaDeCliente = new ArrayList<Cliente>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
		
			while (rset.next()) {
				Cliente clientes = new Cliente();
				
				clientes.setId(rset.getInt("id_cliente"));
				
				clientes.setRg(rset.getInt("rg_cliente"));
				
				clientes.setCpf(rset.getInt("cpf_cliente"));
				
				clientes.setRua(rset.getString("email_cliente"));
				
				clientes.setRua(rset.getString("rua"));

				clientes.setCidade(rset.getString("cidade"));
				
				clientes.setEstado(rset.getString("estado"));
				
				clientes.setComplemento(rset.getString("complemento"));
				
				
				clientes.toString();
				listaDeCliente.add(clientes);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listaDeCliente;
	}
	// Metodo pra atualizar

	public void update(Cliente clientes1) {
		String sql = "UPDATE Cliente SET rg_cliente = ?, cpf_cliente = ?, email_cliente = ?, rua = ?, cidade = ?, estado = ?, complemento = ?, id_usuario = ?, where id_cliente = ?;";

		try { 
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, clientes1.getRg());
			
			pstm.setInt(1, clientes1.getCpf());

			pstm.setString(1, clientes1.getEmail());
			
			pstm.setString(1, clientes1.getRua());
			
			pstm.setString(1, clientes1.getCidade());
			
			pstm.setString(1, clientes1.getComplemento());
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Cliente getClientesById(int id) {
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";

		Cliente clientes = new Cliente();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			clientes.setId(rset.getInt("id_clientes"));
			
			clientes.setRg(rset.getInt("rg_clientes"));
			
			clientes.setCpf(rset.getInt("cpf_clientes"));
			
			clientes.setRua(rset.getString("email_clientes"));

			clientes.setRua(rset.getString("rua"));
			
			clientes.setCidade(rset.getString("cidade"));
			
			clientes.setEstado(rset.getString("estado"));
			
			clientes.setComplemento(rset.getString("complemento"));
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return clientes;
	
	}

}
