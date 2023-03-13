package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcadastro?useTimezone=true&serverTimezone=UTC";
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
		String createf = "insert into cadastra (nome,cpf,cargo,narcimento,endereco,email,tel) values (?,?,?,?,?,?,?)";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(createf);

			pst.setString(1, funcionario.getNome());
			pst.setString(2, funcionario.getCpf());
			pst.setString(3, funcionario.getCargo());
			pst.setString(4, funcionario.getNarcimento());
			pst.setString(5, funcionario.getEndereco());
			pst.setString(6, funcionario.getEmail());
			pst.setString(7, funcionario.getTel());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** crud read **/
	public ArrayList<JavaBeans> listarFuncionarios() {

		ArrayList<JavaBeans> funcionariosa = new ArrayList<>();

		String read = "select * from cadastra order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String idcad = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String cargo = rs.getString(4);
				String narcimento = rs.getString(5);
				String endereco = rs.getString(6);
				String email = rs.getString(7);
				String tel = rs.getString(8);

				funcionariosa.add(new JavaBeans(idcad, nome, cpf, cargo, narcimento, endereco, email, tel, tel));
			}
			con.close();
			return funcionariosa;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selectFuncionario(JavaBeans funcionario) {
		String read2 = "select * from cadastra where idcad = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, funcionario.getIdcad());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				funcionario.setIdcad(rs.getString(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setCpf(rs.getString(3));
				funcionario.setCargo(rs.getString(4));
				funcionario.setNarcimento(rs.getString(5));
				funcionario.setEndereco(rs.getString(6));
				funcionario.setEmail(rs.getString(7));
				funcionario.setTel(rs.getString(8));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
