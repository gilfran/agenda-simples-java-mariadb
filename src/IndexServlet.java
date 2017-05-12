

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Index", urlPatterns = { "/Index" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Exemplo simples de CRUD de agenda usando Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Escolha suas opções abaixo</h1>");
		out.println("<a href='/Agenda/CadastrarContato'>Cadastrar Contato</a>");
		out.println("<br/>");
		out.println("<a href='/Agenda/ListarContatos'>Listar Contatos</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

}
