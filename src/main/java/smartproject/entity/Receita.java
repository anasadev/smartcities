package smartproject.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_receita")
public class Receita {
	
	@Id
	@SequenceGenerator(name="receita",sequenceName="sq_tb_receita",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="receita")
	@Column(name="codigo_receita")
	private int codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade", nullable=false)
	private Date dataValidade;
	
	@ManyToOne
	@JoinColumn(name="codigo_usuario")
	private Usuario paciente;
	
	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn(name="codigo_receita"),inverseJoinColumns=@JoinColumn(name="codigo_medicamento"), name="tb_medicamento_receita" )
	private List<Medicamento> medicamentos;

	public Receita() {
		super();
	}

	public Receita(int codigo, Date dataValidade, Usuario paciente, List<Medicamento> medicamentos) {
		super();
		this.codigo = codigo;
		this.dataValidade = dataValidade;
		this.paciente = paciente;
		this.medicamentos = medicamentos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Usuario getPaciente() {
		return paciente;
	}

	public void setPaciente(Usuario paciente) {
		this.paciente = paciente;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
}
