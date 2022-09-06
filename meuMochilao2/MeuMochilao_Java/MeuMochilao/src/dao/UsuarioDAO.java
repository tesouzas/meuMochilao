package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Usuario;

public class UsuarioDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Usuario usuarios) {
		String sql = "INSERT INTO usuario (nome_usuario, fone_usuario, login_usuario, senha_usuario) values(?, ?, ?, ?)";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, usuarios.getNome());
			
			pstm.setInt(2, usuarios.getFone());
			
			pstm.setString(3, usuarios.getLogin());
			
			pstm.setString(4, usuarios.getSenha());

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
	public List<Usuario> getUsuario() {
		String sql = "select * from usuario;";

		List<Usuario> listaDeUsuario = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuarios = new Usuario();

				usuarios.setId(rset.getInt("id_usuario"));

				usuarios.setNome(rset.getString("nome_usuario"));
				
				usuarios.setFone(rset.getInt("fone_usuario"));
				
				usuarios.setLogin(rset.getString("login_usuario"));
				
				usuarios.setSenha(rset.getString("senha_usuario"));
				
				listaDeUsuario.add(usuarios);

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

		return listaDeUsuario;
	}
	// Metodo pra atualizar

	public void update(Usuario usuarios) {
		String sql = "UPDATE usuario set nome_usuario = ?, fone_usuario = ?, login_usuario = ?, senha_usuario = ?  where id_usuario = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, usuarios.getId());
			
			pstm.setString(2, usuarios.getNome());
			
			pstm.setDouble(3, usuarios.getFone());
			
			pstm.setString(4, usuarios.getLogin());
			
			pstm.setString(5, usuarios.getSenha());
			

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
		String sql = "DELETE FROM usuario WHERE id_usuario = ?;";

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

	public void deleteByIdUsuario(int id) {
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";

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
	public Usuario getUsuariosById(int id) {
		String sql = "SELECT * FROM usuario WHERE id_usuario = ?;";

		Usuario usuarios = new Usuario();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			usuarios.setId(rset.getInt("id_usuarios"));

			usuarios.setNome(rset.getString("nome_usuarios"));
			
			usuarios.setFone(rset.getInt("fone_usuarios"));
			
			usuarios.setLogin(rset.getString("login_usuarios"));
			
			usuarios.setSenha(rset.getString("senha_usuarios"));

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

		return usuarios;
	
	}

	public List<Usuario> getUsuarioById(int posicao) {
		// TODO Auto-generated method stub
		return null;
	}
}
