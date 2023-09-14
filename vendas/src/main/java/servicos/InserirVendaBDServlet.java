package servicos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.VendasDAO;
import modelo.Venda;

/**
 * Servlet implementation class InserirVendaBDServlet
 */
@WebServlet("/InserirVendaBDServlet")
public class InserirVendaBDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("nome");
		String valorTxt = request.getParameter("valor");
		double valor = Double.parseDouble(valorTxt);
		Venda v = new Venda();
		v.setItem(item);
		v.setValor(valor);
		VendasDAO vendaDAO = new VendasDAO();
		int status = vendaDAO.inserir(v);
		response.setContentType("text/html");
		PrintWriter htmlSaida = response.getWriter();
		htmlSaida.print("resultado: " + status);
		htmlSaida.close();
		}
		}


