package smartproject.teste;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import smartproject.entity.Bairro;
import smartproject.entity.Medicamento;

public class TesteAlteracao {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartproject");
		EntityManager em = null;
		LocalDate dataValidade = LocalDate.parse("2025-12-31");
		
		try {
			em = fabrica.createEntityManager();
			
			Medicamento medicamento = new Medicamento();
			
			medicamento.setCodigo(4);
			medicamento.setNome("Ibuprofeno"); 
			medicamento.setMarca("genérico");
			medicamento.setViaAdministracao("oral");
			medicamento.setFormaApresentacao("efervescente");
			medicamento.setQuantidadeEmbalagem(6);
			medicamento.setDataValidade(Date.valueOf(dataValidade));
			
			Bairro bairro = new Bairro();
			
			bairro.setCodigo(3);
			bairro.setNome("Pampulha"); 
			
			em.merge(medicamento);
			em.merge(bairro);
			
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
				fabrica.close();
			}
		}
		
	}	
}
