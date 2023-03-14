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

				funcionariosa.add(new JavaBeans(idcad, nome, cpf, cargo, narcimento, endereco, email, tel));
			}
			con.close();
			return funcionariosa;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selectFuncionario(JavaBeans funcionarios) {
		String read2 = "select * from cadastra where idcad = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, funcionarios.getIdcad());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				funcionarios.setIdcad(rs.getString(1));
				funcionarios.setNome(rs.getString(2));
				funcionarios.setCpf(rs.getString(3));
				funcionarios.setCargo(rs.getString(4));
				funcionarios.setNarcimento(rs.getString(5));
				funcionarios.setEndereco(rs.getString(6));
				funcionarios.setEmail(rs.getString(7));
				funcionarios.setTel(rs.getString(8));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void alterarFunCadastrado (JavaBeans funcionarios) {
		String creat = "update cadastra set nome=?,cpf=?,cargo=?,narcimento=?,endereco=?,email=?,tel=? where idcad=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(creat);
			pst.setString(1, funcionarios.getNome());
			pst.setString(2, funcionarios.getCpf());
			pst.setString(3, funcionarios.getCargo());
			pst.setString(4, funcionarios.getNarcimento());
			pst.setString(5, funcionarios.getEndereco());
			pst.setString(6, funcionarios.getEmail());
			pst.setString(7, funcionarios.getTel());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	}