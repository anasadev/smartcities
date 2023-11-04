package smartproject.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_medicamento")
public class Medicamento {
	
	@Id
	@SequenceGenerator(name="medicamento",sequenceName="sq_tb_medicamento",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="medicamento")
	@Column(name="codigo_medicamento")
	private int codigo;
	
	@Column(name="nm_nome",length = 20,nullable=false)
	private String nome;
	
	@Column(name="nm_marca",length = 20,nullable=false)
	private String marca;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade", nullable=false)
	private Date dataValidade;
	
	@Column(name="ds_via_admin", length = 20, nullable=false)
	private String viaAdministracao;
	
	@Column(name="ds_forma_apresentacao", length = 20, nullable=false)
	private String formaApresentacao;
	
	@Column(name="nm_quantidade", nullable=false)
	private int quantidadeEmbalagem;
	
	@ManyToMany(mappedBy="medicamentos")
	private List<Receita> receitas;
	
	@ManyToMany(mappedBy="medicamentos")
	private List<Posto> postos;
	
	public Medicamento() {
		super();
	}

	public Medicamento(int codigo, String nome, String marca, Date dataValidade, String viaAdministracao,
			String formaApresentacao, int quantidadeEmbalagem, List<Receita> receitas, List<Posto> postos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.marca = marca;
		this.dataValidade = dataValidade;
		this.viaAdministracao = viaAdministracao;
		this.formaApresentacao = formaApresentacao;
		this.quantidadeEmbalagem = quantidadeEmbalagem;
		this.receitas = receitas;
		this.postos = postos;
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


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Date getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}


	public String getViaAdministracao() {
		return viaAdministracao;
	}


	public void setViaAdministracao(String viaAdministracao) {
		this.viaAdministracao = viaAdministracao;
	}


	public String getFormaApresentacao() {
		return formaApresentacao;
	}


	public void setFormaApresentacao(String formaApresentacao) {
		this.formaApresentacao = formaApresentacao;
	}


	public int getQuantidadeEmbalagem() {
		return quantidadeEmbalagem;
	}


	public void setQuantidadeEmbalagem(int quantidadeEmbalagem) {
		this.quantidadeEmbalagem = quantidadeEmbalagem;
	}


	public List<Receita> getReceitas() {
		return receitas;
	}


	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public List<Posto> getPostos() {
		return postos;
	}

	public void setPostos(List<Posto> postos) {
		this.postos = postos;
	}

}
