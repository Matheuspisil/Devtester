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

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select" })
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
		}
		 else if (action.equals("/select")) {
				listarFuncionario(request, response);
			}
		
		else {
			response.sendRedirect("index.html");
		}
	}

	protected void cadastros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dados javabens
		ArrayList<JavaBeans> lista = dao.listarFuncionarios();
		
		request.setAttribute("funcionarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("funcionarios.jsp");
		rd.forward(request, response);
		/**for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getIdcad());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getCpf());
			System.out.println(lista.get(i).getCargo());
			System.out.println(lista.get(i).getNarcimento());
			System.out.println(lista.get(i).getEndereco());
			System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getTel());
		}**/
	}

	protected void novoFuncionario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("cpf"));
		System.out.println(request.getParameter("cargo"));
		System.out.println(request.getParameter("narcimento"));
		System.out.println(request.getParameter("endereço"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("tel"));
		

		funcionarios.setNome(request.getParameter("nome"));
		funcionarios.setCpf(request.getParameter("cpf"));
		funcionarios.setCargo(request.getParameter("cargo"));
		funcionarios.setNarcimento(request.getParameter("narcimento"));
		funcionarios.setEndereco(request.getParameter("endereco"));
		funcionarios.setEmail(request.getParameter("email"));
		funcionarios.setTel(request.getParameter("tel"));
		

		// insert funcionario

		dao.inserirFuncionario(funcionarios);

		response.sendRedirect("main");
	}
	protected void listarFuncionario(HttpServletRequest request, HttpServletResponse Response) {
		String idcad = request.getParameter("idcad");
		funcionarios.setIdcad(idcad);
		dao.inserirFuncionario(funcionarios);
		System.out.println(funcionarios.getIdcad());
		System.out.println(funcionarios.getNome());
		System.out.println(funcionarios.getCpf());
		System.out.println(funcionarios.getCargo());
		System.out.println(funcionarios.getNarcimento());
		System.out.println(funcionarios.getEndereco());
		System.out.println(funcionarios.getEmail());
		System.out.println(funcionarios.getTel());
		
	}
}
