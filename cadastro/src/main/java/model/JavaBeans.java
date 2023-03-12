package model;

public class JavaBeans {
	
	private String idcad;  
	private String nome;
	private String cpf ;
	private String cargo;
	private String Nascimento ;
	private String endereço ;
	private String email ;
	private String tel ;
	
	
	
	public JavaBeans() {
		super();
		
	}
	
	public JavaBeans(String nome, String salario, String idcad, String nascimento, String endereço, String cpf,
			String email, String tel, String cargo, String id) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.idcad = idcad;
		this.Nascimento = nascimento;
		this.endereço = endereço;
		this.email = email;
		this.tel = tel;
		
		
	}
	
	public String getIdcad() {
		return idcad;
	}
	public void setIdcad(String idcad) {
		this.idcad = idcad;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNascimento() {
		return Nascimento;
	}
	public void setNascimento(String nascimento) {
		Nascimento = nascimento;
	}
	public String getEndereco() {
		return endereço;
	}
	public void setEndereco(String endereço) {
		this.endereço = endereço;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	

	
	
}
