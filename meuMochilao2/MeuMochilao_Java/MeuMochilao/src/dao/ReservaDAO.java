package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Reserva;


public class ReservaDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Método pra salvar
	public void save(Reserva reservas) {
		String sql = "INSERT INTO reserva (origem_reserva, destino_reserva, ida_reserva, volta_reserva, acompanhantes_reserva, valor_reserva, id_cliente) "
				+ "values(?, ?, ?, ?, ?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, reservas.getOrigem());
			
			pstm.setString(2, reservas.getDestino());
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(3, new Date(formatter.parse(reservas.getIda()).getTime()));

			pstm.setDate(4, new Date(formatter.parse(reservas.getVolta()).getTime()));
			
			pstm.setInt(5, reservas.getAcompanhantes());
			
			pstm.setDouble(6, reservas.getValor());
			
			
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
	public List<Reserva> getReserva() {
		String sql = "select * from reserva;";

		List<Reserva> listaDeReserva = new ArrayList<Reserva>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reservas = new Reserva();
				
				reservas.setId(rset.getInt("id_reserva"));
				
				reservas.setOrigem(rset.getString("origem_reserva"));

				reservas.setDestino(rset.getString("destino_reserva"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				reservas.setIda(dateFormat.format(rset.getDate("ida_reserva")));

				reservas.setVolta(dateFormat.format(rset.getDate("volta_reserva")));

				reservas.setAcompanhantes(rset.getInt("acompanhantes_reserva"));
				
				reservas.setValor(rset.getDouble("valor_reserva"));
				
				reservas.toString();
				listaDeReserva.add(reservas);

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

		return listaDeReserva;
	}
	
	public List<Reserva> getReservaById(int id) {
		String sql = "select * from reserva WHERE id_reserva= ?;";

		List<Reserva> listaDeReserva = new ArrayList<Reserva>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reservas = new Reserva();
				
				reservas.setId(rset.getInt("id_reserva"));
				
				reservas.setOrigem(rset.getString("origem_reserva"));

				reservas.setDestino(rset.getString("destino_reserva"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				reservas.setIda(dateFormat.format(rset.getDate("ida_reserva")));

				reservas.setVolta(dateFormat.format(rset.getDate("volta_reserva")));

				reservas.setAcompanhantes(rset.getInt("acompanhantes_reserva"));
				
				reservas.setValor(rset.getDouble("valor_reserva"));
				
				reservas.toString();
				listaDeReserva.add(reservas);

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

		return listaDeReserva;
	}
	// Metodo pra atualizar

	public void update(Reserva reservas1) {
		String sql = "UPDATE reserva SET origem_reserva = ?, destino_reserva = ?, ida_reserva = ?, volta_reserva = ?, acompanhantes_reserva = ?, valor_ reserva = ?, id_cliente = ?, id_transporte = ?, id_hospedagem = ? where id_reserva = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, reservas1.getOrigem());
			
			pstm.setString(1, reservas1.getDestino());

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(3, new Date(formatter.parse(reservas1.getIda()).getTime()));
			

			pstm.setDate(3, new Date(formatter.parse(reservas1.getVolta()).getTime()));

			pstm.setDouble(2, reservas1.getValor());
			
			pstm.setInt(4, reservas1.getAcompanhantes());
			

			pstm.setInt(6, reservas1.getId());

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
		String sql = "DELETE FROM reserva WHERE id_reserva = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			
			HospedagemDAO hospedagem = new HospedagemDAO();
			hospedagem.deleteByIdReserva(id);
			
			TransporteDAO transporteDAO = new TransporteDAO();
			transporteDAO.deleteByIdReserva(id);
			
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

}
