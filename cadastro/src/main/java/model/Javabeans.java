package model;

public class Javabeans {
	
	private String nome;
	private String salario;
	private String idcad;  
	private String Nascimento ;
	private String endereço ;
	private String CPF ;
	private String email ;
	private String tel ;
	private String cargo;
	private String id;
	
	
	
	public Javabeans() {
		super();
		
	}
	
	
	public Javabeans(String nome, String salario, String idcad, String nascimento, String endereço, String cPF,
			String email, String tel, String cargo, String id) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.idcad = idcad;
		Nascimento = nascimento;
		this.endereço = endereço;
		CPF = cPF;
		this.email = email;
		this.tel = tel;
		this.cargo = cargo;
		this.id = id;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getIdcad() {
		return idcad;
	}
	public void setIdcad(String idcad) {
		this.idcad = idcad;
	}
	public String getNascimento() {
		return Nascimento;
	}
	public void setNascimento(String nascimento) {
		Nascimento = nascimento;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
