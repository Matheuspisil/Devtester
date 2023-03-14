package model;

public class JavaBeans {
	
	private String idcad;  
	private String nome;
	private String cpf ;
	private String cargo;
	private String narcimento ;
	private String endereco ;
	private String email ;
	private String tel ;
	
	
	
	public JavaBeans() {
		super();
		
	}
	
	public JavaBeans(String idcad, String nome, String cpf, String cargo,  String narcimento, String endereco, 
			String email, String tel) {
		super();
		this.idcad = idcad;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.narcimento = narcimento;
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
	public String getNarcimento() {
		return narcimento;
	}
	public void setNarcimento(String narcimento) {
		this.narcimento = narcimento;
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
