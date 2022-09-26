package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservaDAO;
import dao.ViagemDAO;
import dao.ClienteDAO;
import model.Reserva;
import model.Viagem;
import model.Cliente;

@WebServlet(urlPatterns = { "/reserva", "/reserva-create", "/pag-create", "/reserva-edit", "/reserva-update", "/reserva-delet" })
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ReservaDAO reservaDAO = new ReservaDAO();
	ClienteDAO clienteDAO = new ClienteDAO();
	ViagemDAO viagemDAO = new ViagemDAO();
	Reserva reserva = new Reserva();

	public ReservaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/reserva":
			read(request, response);
			break;
		case "/reserva-create":
			create(request, response);
			break;
		case "/pag-create":
			pagCreate(request, response);
			break;
		case "/reserva-edit":
			edit(request, response);
			break;
		case "/reserva-update":
			update(request, response);
			break;
		case "/reserva-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Reserva> lista = reservaDAO.getReserva();

		request.setAttribute("reservas", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/reserva/index.jsp");
		rd.forward(request, response);
	}
	
	protected void pagCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> clientes = clienteDAO.getCliente();
		request.setAttribute("clientes", clientes);
		
		List<Viagem> viagens = viagemDAO.getViagem();
		request.setAttribute("viagens", viagens);

		RequestDispatcher rd = request.getRequestDispatcher("./views/reserva/create.jsp");
		rd.forward(request, response);
	}
	
	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente cliente = clienteDAO.getClienteById(Integer.parseInt(request.getParameter("cliente")));
		Viagem viagem = viagemDAO.getViagemById(Integer.parseInt(request.getParameter("viagem")));
		 
		String ida = request.getParameter("ida");
		String volta = request.getParameter("volta");
		
		reserva = new Reserva(ida, volta, cliente, viagem);
		
		reservaDAO.save(reserva);
		response.sendRedirect("reserva");
	}

	
	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		reserva = reservaDAO.getReservaById(id);
		request.setAttribute("id", reserva.getId());
		request.setAttribute("ida", reserva.getIda());
		request.setAttribute("volta", reserva.getVolta());
		request.setAttribute("valor_total", reserva.getValor_total());
		request.setAttribute("dias", reserva.getDias());
		RequestDispatcher rd = request.getRequestDispatcher("./views/reserva/update.jsp");
		rd.forward(request, response);
	}
	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reserva.setId(Integer.parseInt(request.getParameter("id")));
		reserva.setIda(request.getParameter("ida"));
		reserva.setVolta(request.getParameter("volta"));
		reserva.setValor_total(Double.parseDouble(request.getParameter("valor_total")));
		reserva.setDias(Integer.parseInt(request.getParameter("dias")));
		reservaDAO.update(reserva);
		response.sendRedirect("reserva");
	}
	
	 //DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		reservaDAO.deleteById(id);
		response.sendRedirect("reserva");
	}

}