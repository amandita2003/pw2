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
 * Servlet implementation class ConsultarVendaBDServlet
 */
@WebServlet("/ConsultarVendaBDServlet")
public class ConsultarVendaBDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String idTxt = request.getParameter("id");
		int id = Integer.parseInt(idTxt);
		VendasDAO vendaDAO = new VendasDAO();
		Venda v = vendaDAO.consultarPorId(id);
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		saida.print("<h2>Consultar Venda</h2>");
		saida.print("<br /><b>id</b>: " + v.getId());
		saida.print("<br /><b>item</b>: " + v.getItem());
		saida.print("<br /><b>quantidade</b>: " + v.getValor());
		saida.close();
	}

}
