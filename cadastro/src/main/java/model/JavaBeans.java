package model;

public class JavaBeans {
	
	private String idcad;  
	private String nome;
	private String cpf ;
	private String cargo;
	private String nascimento ;
	private String endereco ;
	private String email ;
	private String tel ;
	
	
	
	public JavaBeans() {
		super();
		
	}
	
	public JavaBeans(String idcad, String nome, String cpf, String cargo,  String nascimento, String endereco, 
			String email, String tel) {
		super();
		this.idcad = idcad;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.nascimento = nascimento;
		this.endereco = endereco;
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
		return nascimento;
	}
	public void setNascimento(String narcimento) {
		this.nascimento = narcimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
