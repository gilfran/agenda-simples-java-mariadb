

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarContato", urlPatterns = { "/CadastrarContato" })
public class CadastrarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cadastro de Contato</title>");
		out.println("<style type='text/css'>");
		out.println("p.erro { color: #F00 }");
		out.println("p.confirmado { color: #0F0 }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Cadastro</h1>");
		out.println("<p>Nome:</p>");
		out.println("<form method='POST'>");
		out.println("<input type='text' name='txtNome' placeholder='Didige o nome'>");
		out.println("<br/>");
		out.println("<p>E-mail:</p>");
		out.println("<input type='mail' name='txtEmail' placeholder='Didige o e-mail'>");
		out.println("<br/>");
		out.println("<p>Endereço:</p>");
		out.println("<textarea name='txtEndereco' rows='5' cols='25'></textarea>");
		out.println("<br/>");
		out.println("<input type='submit' value='Cadastrar'/>");
		out.println("</form>");
		out.println("<br/>");
		out.println("<a href='/Agenda/CadastrarContato'>Cadastrar Contato</a>");
		out.println("<br/>");
		out.println("<a href='/Agenda/ListarContatos'>Listar Contatos</a>");
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cadastro de Contato</title>");
		out.println("<style type='text/css'>");
		out.println("p.erro { color: #F00 }");
		out.println("p.confirmado { color: #0F0 }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Cadastro</h1>");
		
		
		
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String endereco = request.getParameter("txtEndereco");
		
		
		// Testa campos obrigatórios (Nome e e-mail)
		if (nome.trim() == "") {
			out.println("<p class='erro'>Preencha o campo obrigatório Nome!</p>");
		} else if (email.trim() == "") {
			out.println("<p class='erro'>Preencha o campo Obrigatório E-mail!</p>");
		} else {
			try {
				
				// Chamar Driver do Banco
				Class.forName("com.mysql.jdbc.Driver");
				String sql = "INSERT INTO agenda (nome, email, endereco) VALUES (?, ?, ?)";
				
				// Abrir Conexão
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "agenda", "");
					PreparedStatement pstm = conn.prepareStatement(sql);
					pstm.setString(1, nome);
					//pstm.setInt(2, telefone);
					pstm.setString(2, email);
					pstm.setString(3, endereco);
					pstm.execute();
					pstm.close();
					conn.close();
				} catch (SQLException e) {
					out.println("<p class='erro'>Houve uma falha ao tentar acessar o banco: </p>" +e);
				} finally {
					out.println("<p class='confirmado'>Cadastrado com Sucesso!</p>");
				}
				
			} catch (ClassNotFoundException e) {
				out.println("<p class='erro'>O contato não foi cadastrado: </p>" +e);
			}
			
		}
			out.println("<p>Nome:</p>");
			out.println("<form method='POST'>");
			out.println("<input type='text' name='txtNome' placeholder='Didige o nome'>");
			out.println("<br/>");
			out.println("<p>E-mail:</p>");
			out.println("<input type='mail' name='txtEmail' placeholder='Didige o e-mail'>");
			out.println("<br/>");
			out.println("<p>Endereço:</p>");
			out.println("<textarea name='txtEndereco' rows='5' cols='25'></textarea>");
			out.println("<br/>");
			out.println("<input type='submit' value='Cadastrar'/>");
			out.println("</form>");
			out.println("<br/>");
			out.println("<a href='/Agenda/Index'>Página Inicial</a>");
			out.println("<br/>");
			out.println("<a href='/Agenda/ListarContatos'>Listar Contatos</a>");
			out.println("</body>");
			out.println("</html>");
		
		
		
	}

}
