package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcadastros?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "lalaxinha20?DEDO";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	 public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** crud **/
	public void inserirFuncionario(JavaBeans funcionario) {
		String createf = "insert into cadastro (nome,cpf,cargo) values (?,?,?,?,?,?,?)";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(createf);

			pst.setString(1, funcionario.getNome());
			pst.setString(2, funcionario.getCpf());
			pst.setString(3, funcionario.getCargo());
			pst.setString(4, funcionario.getNascimento());
			pst.setString(5, funcionario.getEndereco());
			pst.setString(6, funcionario.getEmail());
			pst.setString(7, funcionario.getTel());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
