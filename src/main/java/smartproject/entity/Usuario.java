package smartproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@SequenceGenerator(name="usuario",sequenceName="sq_tb_usuario",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="usuario")
	@Column(name="codigo_usuario")
	private int codigo;
	
	@Column(name="nm_username",length = 20,nullable=false)
	private String username;
	
	@Column(name="ds_email", length = 320, nullable=false, unique=true)
	private String email;
	
	@Column(name="ds_senha", length = 100, nullable=false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="codigo_bairro")
	private Bairro bairro;
	
	public Usuario() {
		super();
	}
	

	public Usuario(int codigo, String username, String email, String senha, Bairro bairro) {
		super();
		this.codigo = codigo;
		this.username = username;
		this.email = email;
		this.senha = senha;
		this.bairro = bairro;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Bairro getBairro() {
		return bairro;
	}


	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	
}
