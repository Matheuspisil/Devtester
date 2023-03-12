package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans funcionarios = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			cadastros(request, response);
			dao.testeConexao();
		} else if (action.equals("/insert")) {
			novoFuncionario(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	protected void cadastros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("funcionarios.jsp");
	}
	protected void novoFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("nascimento"));
		System.out.println(request.getParameter("endereço"));
		System.out.println(request.getParameter("cpf"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("tel"));
		System.out.println(request.getParameter("cargo"));
		
		funcionarios.setNome(request.getParameter("nome"));
		funcionarios.setNome(request.getParameter("nascimento"));
		funcionarios.setNome(request.getParameter("endereço"));
		funcionarios.setNome(request.getParameter("cpf"));
		funcionarios.setNome(request.getParameter("email"));
		funcionarios.setNome(request.getParameter("tel"));
		funcionarios.setNome(request.getParameter("cargo"));
		
		// insert funcionario
		
		dao.inserirFuncionario(funcionarios);
		
		response.sendRedirect("main");
	}
	
}
