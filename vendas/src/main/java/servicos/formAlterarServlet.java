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
 * Servlet implementation class alterar
 */
@WebServlet("/alterarForm")
public class formAlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idRecebido = request.getParameter("id");
		
		int id = Integer.parseInt(idRecebido);
		
		VendasDAO vendaDAO = new VendasDAO();
		Venda v = VendasDAO.consultarPorId(id);
		
		
		response.setContentType("text/html");
		PrintWriter htmlSaida = response.getWriter();
		
		
		htmlSaida.print("<form action='alterarBD' method='post'>");
		htmlSaida.print("item:");
		htmlSaida.print("<br />");
		htmlSaida.print("<input type='text' name='nome' value='"+v.getItem()+"'>");
		htmlSaida.print("<br />");
		htmlSaida.print("<br />");
		htmlSaida.print("Valor:");
		htmlSaida.print("<br />");
		htmlSaida.print("<input type='text' name='valor' value='"+v.getValor()+"''>");
		htmlSaida.print("<br />");
		htmlSaida.print("<br />");
		htmlSaida.print("<input type='hidden' name='id' value='"+v.getId()+"''>");
		htmlSaida.print("<br />");
		htmlSaida.print("<input type='submit' name='enviar' value='Inserir'>");
		htmlSaida.print("</form>");
		
		htmlSaida.close();
	}

}
