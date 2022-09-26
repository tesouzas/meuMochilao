package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Viagem;

public class ViagemDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Viagem viagem) {
		
		String sql = "insert into viagem (destino_viagem, pacote_viagem, valor_pacote_viagem) values "
				+ "(?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, viagem.getDestino());

			pstm.setString(2, viagem.getPacote());
			
			pstm.setDouble(3, viagem.getValor_pacote());
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
	public List<Viagem> getViagem() {
		String sql = "select * from Viagem;";

		List<Viagem> viagems = new ArrayList<Viagem>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Viagem viagem = new Viagem();

				viagem.setId(rset.getInt("id_viagem"));

				viagem.setDestino(rset.getString("destino_viagem"));
				
				viagem.setPacote(rset.getString("pacote_viagem"));
				
				viagem.setValor_pacote(rset.getDouble("valor_pacote_viagem"));

				viagems.add(viagem);

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

		return viagems;
	}
	// Metodo pra atualizar

	public void update(Viagem viagem) {
		String sql = "UPDATE viagem set destino_viagem = ?, pacote_viagem = ?, valor_pacote_viagem = ? where id_viagem = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viagem.getDestino());

			pstm.setString(2, viagem.getPacote());
			
			pstm.setDouble(3, viagem.getValor_pacote());
			
			pstm.setInt(4, viagem.getId());

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
		String sql = "DELETE FROM viagem WHERE id_viagem = ?";

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

	public Viagem getViagemById(int id) {
		String sql = "SELECT * FROM viagem WHERE id_viagem = ?;";

		Viagem viagem = new Viagem();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			viagem.setId(rset.getInt("id_viagem"));

			viagem.setDestino(rset.getString("destino_viagem"));
			
			viagem.setPacote(rset.getString("pacote_viagem"));
			
			viagem.setValor_pacote(rset.getDouble("valor_pacote_viagem"));	

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

		return viagem;
	}

}
