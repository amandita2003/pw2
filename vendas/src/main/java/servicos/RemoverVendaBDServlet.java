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
 * Servlet implementation class RemoverVendaBDServlet
 */
@WebServlet("/RemoverVendaBDServlet")
public class RemoverVendaBDServlet extends HttpServlet {
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
		int status = vendaDAO.remover(id);
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		saida.print("status: "+status);
		if(status>0){
			saida.print("<p style='color: red'>Venda removida com sucesso!</p>");
			//request.getRequestDispatcher("/ListarVendasBDServlet").include(request, response);
			response.sendRedirect("ListarVendasBDServlet");
			}else{
			saida.println("Desculpe! Não foi possível remover a venda.");
			}
		saida.close();
		}
	}


