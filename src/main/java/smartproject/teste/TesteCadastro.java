package smartproject.teste;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import smartproject.entity.Bairro;
import smartproject.entity.Medicamento;

public class TesteCadastro {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartproject");
		EntityManager em = fabrica.createEntityManager();
		
		LocalDate dataValidade = LocalDate.parse("2025-12-31");
		
		Medicamento medicamento = new Medicamento();
		medicamento.setNome("Paracetamol"); 
		medicamento.setMarca("genérico");
		medicamento.setViaAdministracao("oral");
		medicamento.setFormaApresentacao("comprimidos");
		medicamento.setQuantidadeEmbalagem(8);
		medicamento.setDataValidade(Date.valueOf(dataValidade));
		
		Bairro bairro = new Bairro();
		bairro.setNome("Liberdade");
		
		Bairro bairro2 = new Bairro();
		bairro2.setNome("Centro");
		
		try {
			em.persist(medicamento);
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		try {
			em.persist(bairro);
			em.persist(bairro2);
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		fabrica.close();
	}

}
