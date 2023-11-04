package smartproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bairro")
public class Bairro {

	@Id
	@SequenceGenerator(name="bairro",sequenceName="sq_tb_bairro",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bairro")
	@Column(name="codigo_bairro")
	private int codigo;
	
	@Column(name="nm_nome",length = 20,nullable=false)
	private String nome;

	public Bairro() {
		super();
	}

	public Bairro(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
