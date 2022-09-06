package teste;

import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import dao.ClienteDAO;
import dao.HospedagemDAO;
import dao.ReservaDAO;
import dao.TransporteDAO;
import modelo.Cliente;
import modelo.Hospedagem;
import modelo.Reserva;
import modelo.Transporte;

public class Teste {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Conexão
		ConnectionMySQL conexao = new ConnectionMySQL();
		//conexao.createConnectionMySQL();
		
		ReservaDAO reserva = new ReservaDAO();
		List<Reserva> reservaList = new ArrayList<Reserva>();
		reservaList = reserva.getReserva();
		System.out.println(reservaList.get(0));
		
		HospedagemDAO hospedagem = new HospedagemDAO();
		List<Hospedagem> hospedagemList = new ArrayList<Hospedagem>();
		hospedagemList = hospedagem.getHospedagem();
		System.out.println(hospedagemList.get(0));
		
		TransporteDAO transporte = new TransporteDAO();
		List<Transporte> transporteList = new ArrayList<Transporte>();
		transporteList = transporte.getTransporte();
		System.out.println(transporteList.get(0));
		
		ClienteDAO cliente = new ClienteDAO();
		List<Cliente> clienteList = new ArrayList<Cliente>();
		clienteList = cliente.getCliente();
		System.out.println(clienteList.get(0));
		
	}

}
