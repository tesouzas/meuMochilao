package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViagemDAO;
import model.Viagem;

@WebServlet(urlPatterns = { "/viagem", "/viagem-create", "/viagem-edit", "/viagem-update", "/viagem-delet" })
public class ViagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ViagemDAO viagemDAO = new ViagemDAO();
	Viagem viagem = new Viagem();

	public ViagemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/viagem":
			read(request, response);
			break;
		case "/viagem-create":
			create(request, response);
			break;
		case "/viagem-edit":
			edit(request, response);
			break;
		case "/viagem-update":
			update(request, response);
			break;
		case "/viagem-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Viagem> lista = viagemDAO.getViagem();

		request.setAttribute("viagem", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/viagem/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		viagem.setDestino(request.getParameter("destino"));
		viagem.setPacote(request.getParameter("pacote"));
		viagem.setValor_pacote(Double.parseDouble(request.getParameter("valor")));

		viagemDAO.save(viagem);
		response.sendRedirect("viagem");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		viagem = viagemDAO.getViagemById(id);

		request.setAttribute("id", viagem.getId());
		request.setAttribute("destino", viagem.getDestino());
		request.setAttribute("pacote", viagem.getPacote());
		request.setAttribute("valor_pacote", viagem.getValor_pacote());

		RequestDispatcher rd = request.getRequestDispatcher("./views/viagem/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viagem.setId(Integer.parseInt(request.getParameter("id")));
		viagem.setDestino(request.getParameter("destino"));
		viagem.setPacote(request.getParameter("pacote"));
		viagem.setValor_pacote(Double.parseDouble(request.getParameter("valor_pacote")));

		viagemDAO.update(viagem);
		response.sendRedirect("viagem");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		viagemDAO.deleteById(id);
		response.sendRedirect("viagem");
	}

}