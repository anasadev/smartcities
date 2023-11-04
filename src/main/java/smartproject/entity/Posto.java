package smartproject.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "tb_posto")
public class Posto {

	@Id
	@SequenceGenerator(name="posto",sequenceName="sq_tb_posto",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="posto")
	@Column(name="codigo_posto")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="codigo_bairro")
	private Bairro bairro;
	
	@Temporal(TemporalType.TIME)
	@Column(name="hr_abertura", nullable=false)
	private Date horaAbertura;
	
	@Temporal(TemporalType.TIME)
	@Column(name="hr_fechamento", nullable=false)
	private Date horaFechamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_funcionamento")
	private List<DiaSemana> diasFuncionamento;
	
	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn(name="codigo_posto"),inverseJoinColumns=@JoinColumn(name="codigo_medicamento"), name="tb_medicamento_posto" )
	private List<Medicamento> medicamentos;

	public Posto() {
		super();
	}

	public Posto(int codigo, Bairro bairro, Date horaAbertura, Date horaFechamento, List<DiaSemana> diasFuncionamento,
			List<Medicamento> medicamentos) {
		super();
		this.codigo = codigo;
		this.bairro = bairro;
		this.horaAbertura = horaAbertura;
		this.horaFechamento = horaFechamento;
		this.diasFuncionamento = diasFuncionamento;
		this.medicamentos = medicamentos;
	}




	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Date getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(Date horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public Date getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(Date horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	public List<DiaSemana> getDiasFuncionamento() {
		return diasFuncionamento;
	}

	public void setDiasFuncionamento(List<DiaSemana> diasFuncionamento) {
		this.diasFuncionamento = diasFuncionamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

}
