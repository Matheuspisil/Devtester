package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
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
		} else if (action.equals("/select")) {
			listarFuncionario(request, response);
		} else if (action.equals("/update")) {
			editarFuncionario(request, response);
		} else if (action.equals("/delete")) {
			removerFuncionario(request, response);
		}

		else {
			response.sendRedirect("index.html");
		}
	}

	protected void cadastros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> lista = dao.listarFuncionarios();

		request.setAttribute("funcionarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("funcionarios.jsp");
		rd.forward(request, response);

	}

	protected void novoFuncionario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		funcionarios.setNome(request.getParameter("nome"));
		funcionarios.setCpf(request.getParameter("cpf"));
		funcionarios.setCargo(request.getParameter("cargo"));
		funcionarios.setNascimento(request.getParameter("nascimento"));
		funcionarios.setEndereco(request.getParameter("endereco"));
		funcionarios.setEmail(request.getParameter("email"));
		funcionarios.setTel(request.getParameter("tel"));
		dao.inserirFuncionario(funcionarios);

		response.sendRedirect("main");
	}

	protected void listarFuncionario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcad = request.getParameter("idcad");
		funcionarios.setIdcad(idcad);
		dao.selectFuncionario(funcionarios);

		request.setAttribute("idcad", funcionarios.getIdcad());
		request.setAttribute("nome", funcionarios.getNome());
		request.setAttribute("cpf", funcionarios.getCpf());
		request.setAttribute("cargo", funcionarios.getCargo());
		request.setAttribute("nascimento", funcionarios.getNascimento());
		request.setAttribute("endereco", funcionarios.getEndereco());
		request.setAttribute("email", funcionarios.getEmail());
		request.setAttribute("tel", funcionarios.getTel());

		RequestDispatcher rd = request.getRequestDispatcher("editorfuncionario.jsp");
		rd.forward(request, response);

	}

	protected void editarFuncionario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("idcon"));

		funcionarios.setIdcad(request.getParameter("idcad"));
		funcionarios.setNome(request.getParameter("nome"));
		funcionarios.setCpf(request.getParameter("cpf"));
		funcionarios.setCargo(request.getParameter("cargo"));
		funcionarios.setNascimento(request.getParameter("nascimento"));
		funcionarios.setEndereco(request.getParameter("endereco"));
		funcionarios.setEmail(request.getParameter("email"));
		funcionarios.setTel(request.getParameter("tel"));
		dao.alterarFunCadastrado(funcionarios);
		response.sendRedirect("main");

	}

	protected void removerFuncionario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcad = request.getParameter("idcad");
		funcionarios.setIdcad(idcad);
		dao.deletarFuncionario(funcionarios);
		response.sendRedirect("main");
	}
}
