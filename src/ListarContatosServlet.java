

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarContatos", urlPatterns = { "/ListarContatos" })
public class ListarContatosServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "agenda", "");
				
				String sql = "SELECT * FROM agenda";
				
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Lista de Contatos</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<table width='100%'>");
				
				out.println("<tr>");
				out.println("<td>Cadastro</td>");
				out.println("<td>Nome</td>");
				out.println("<td>E-Mail</td>");
				out.println("<td>Endereço</td>");
				out.println("</tr>");

				while (rs.next()) {
					out.println("<tr>");
					out.println("<td>"+rs.getString("id")+"</td>");
					out.println("<td>"+rs.getString("nome")+"</td>");
					out.println("<td>"+rs.getString("email")+"</td>");
					out.println("<td>"+rs.getString("endereco")+"</td>");
					out.println("</tr>");
				}
				

				out.println("</table>");
				out.println("<br/>");
				out.println("<a href='/Agenda/Index'>Página Inicial</a>");
				out.println("<br/>");
				out.println("<a href='/Agenda/CadastrarContato'>Cadastrar Contato</a>");
				out.println("</body>");
				out.println("</html>");
				
			} catch (SQLException e) {
				
				
			}
			
		} catch (ClassNotFoundException e) {
		
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
