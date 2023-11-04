package smartproject.teste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import smartproject.entity.Bairro;
import smartproject.entity.Medicamento;

public class TesteRemocao {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartproject");
		EntityManager em = fabrica.createEntityManager();
		
		Medicamento medicamento = em.find(Medicamento.class, 5);
		Bairro bairro = em.find(Bairro.class, 2);
		em.remove(medicamento);
		em.remove(bairro);
		
		try {
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
