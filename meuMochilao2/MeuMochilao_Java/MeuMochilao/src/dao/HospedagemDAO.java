package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Hospedagem;

public class HospedagemDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Hospedagem hospedagens) {
		String sql = "INSERT INTO hospedagem (nome_hospedagem, valor_hospedagem, qtddias_hospedados) values(?, ?, ?)";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, hospedagens.getNome());
			
			pstm.setDouble(2, hospedagens.getValor());
			
			pstm.setInt(3,hospedagens.getQtddias());

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
	public List<Hospedagem> getHospedagem() {
		String sql = "select * from hospedagem;";

		List<Hospedagem> hospedagem = new ArrayList<Hospedagem>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Hospedagem hospedagens = new Hospedagem();

				hospedagens.setId(rset.getInt("id_hospedagem"));

				hospedagens.setNome(rset.getString("nome_hospedagem"));
				
				hospedagens.setValor(rset.getDouble("valor_hospedagem"));

				hospedagem.add(hospedagens);

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

		return hospedagem;
	}
	// Metodo pra atualizar

	public void update(Hospedagem hospedagens) {
		String sql = "UPDATE hospedagem set nome_hospedagem = ?, qtddias_hospedados = ?, valor_hospedagem = ?  where id_hospedagem = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagens.getNome());
			
			pstm.setInt(2, hospedagens.getQtddias());
			
			pstm.setDouble(3, hospedagens.getValor());
			
			pstm.setInt(4, hospedagens.getId());
			

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
		String sql = "DELETE FROM hospedagem WHERE id_hospedagem = ?";

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

	public void deleteByIdReserva(int id) {
		String sql = "DELETE FROM hospedagem WHERE id_reserva = ?";

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

	public Hospedagem getHospedagensById(int id) {
		String sql = "SELECT * FROM hospedagem WHERE id_hospedagem = ?;";

		Hospedagem hospedagens = new Hospedagem();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			hospedagens.setId(rset.getInt("id_hospedagens"));

			hospedagens.setNome(rset.getString("nome_hospedagens"));

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

		return hospedagens;
	}

	public List<Hospedagem> getHospedagemById(int posicao) {
		// TODO Auto-generated method stub
		return null;
	}

}
