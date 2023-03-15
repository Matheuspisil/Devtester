package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report", "/cargos" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans funcionarios = new JavaBeans();

	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

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
		} else if (action.equals("/report")) {
			relatorio(request, response);
		} else if (action.equals("/report")) {
			relatorio(request, response);
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

	protected void relatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("content-Disposition", "inline; filename=" + "funcionarios.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Funcionarios"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(8);
			PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Cargo"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Nascimento"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Endereço"));
			PdfPCell col7 = new PdfPCell(new Paragraph("E-mail"));
			PdfPCell col8 = new PdfPCell(new Paragraph("Telefone"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);
			tabela.addCell(col8);
			ArrayList<JavaBeans> lista = dao.listarFuncionarios();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getIdcad());
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getCpf());
				tabela.addCell(lista.get(i).getCargo());
				tabela.addCell(lista.get(i).getNascimento());
				tabela.addCell(lista.get(i).getEndereco());
				tabela.addCell(lista.get(i).getEmail());
				tabela.addCell(lista.get(i).getTel());
			}
			documento.add(tabela);

			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}

	protected void funcionarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("cargos.jsp");
	}
}
