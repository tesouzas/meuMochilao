package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Reserva;
import model.Viagem;
import model.Cliente;

public class ReservaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	// Metodo pra salvar
	public void save(Reserva reserva) {
		
		String sql = "insert into reserva "
				+ "(data_ida, data_volta, valor_reserva, dias_reserva, id_cliente, id_viagem) values "
				+ "(?, ?, ?, ?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			
			pstm.setDate(1, new Date(formatter.parse(reserva.getIda()).getTime()));

			pstm.setDate(2, new Date(formatter.parse(reserva.getVolta()).getTime()));
			
			pstm.setDouble(3, reserva.getValor_total());
			
			pstm.setLong(4, reserva.getDias());
			
			pstm.setInt(5, reserva.getCliente().getId());
			
			pstm.setInt(6, reserva.getViagem().getId());
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
		String sql = "select * from reserva_cliente_viagem;";

		List<Reserva> reservas = new ArrayList<Reserva>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				Viagem viagem = new Viagem();

				reserva.setId(rset.getInt("id_reserva"));
				reserva.setIda(formatter.format(rset.getDate("data_ida")));
				reserva.setVolta(formatter.format(rset.getDate("data_volta")));
				reserva.setValor_total(rset.getDouble("valor_reserva"));
				reserva.setDias(rset.getInt("dias_reserva"));
				
				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome_cliente"));
				cliente.setCidade(rset.getString("cidade_cliente"));
				cliente.setCpf(rset.getString("cpf_cliente"));
				reserva.setCliente(cliente);
				
				viagem.setId(rset.getInt("id_viagem"));
				viagem.setDestino(rset.getString("destino_viagem"));
				viagem.setPacote(rset.getString("pacote_viagem"));
				viagem.setValor_pacote(rset.getDouble("valor_pacote_viagem"));
				reserva.setViagem(viagem);

				reservas.add(reserva);

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

		return reservas;
	}
	// Metodo pra atualizar

	public void update(Reserva reserva) {
		String sql = "UPDATE reserva set data_ida = ?, data_volta = ?, "
				+ "valor_reserva = ?, dias_reserva = ?, id_cliente = ?, id_viagem = ? "
				+ "where id_reserva = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date(formatter.parse(reserva.getIda()).getTime()));
			pstm.setDate(2, new Date(formatter.parse(reserva.getVolta()).getTime()));
			pstm.setDouble(3, reserva.getValor_total());
			pstm.setLong(4, reserva.getDias());
			pstm.setInt(5, reserva.getCliente().getId());
			pstm.setInt(6, reserva.getViagem().getId());
			
			pstm.setInt(7, reserva.getId());

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

	public Reserva getReservaById(int id) {
		String sql = "SELECT * FROM reserva WHERE id_reserva = ?;";

		Reserva reserva = new Reserva();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			Cliente cliente = new Cliente();
			Viagem viagem = new Viagem();

			reserva.setId(rset.getInt("id_reserva"));
			reserva.setIda(formatter.format(rset.getDate("data_ida")));
			reserva.setVolta(formatter.format(rset.getDate("data_volta")));
			reserva.setValor_total(rset.getDouble("valor_reserva"));
			reserva.setDias(rset.getInt("dias_reserva"));
			
			cliente.setId(rset.getInt("id_cliente"));
			cliente.setNome(rset.getString("nome_cliente"));
			cliente.setNome(rset.getString("cidade_cliente"));
			cliente.setNome(rset.getString("cpf_cliente"));
			reserva.setCliente(cliente);
			
			viagem.setId(rset.getInt("id_viagem"));
			viagem.setId(rset.getInt("destino_viagem"));
			viagem.setId(rset.getInt("pacote_viagem"));
			viagem.setId(rset.getInt("valor_pacote_viagem"));
			reserva.setViagem(viagem);

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

		return reserva;
	}

}
