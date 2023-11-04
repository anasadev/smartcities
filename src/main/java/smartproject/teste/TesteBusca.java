package smartproject.teste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import smartproject.entity.Bairro;
import smartproject.entity.Medicamento;

public class TesteBusca {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartproject");
		EntityManager em = fabrica.createEntityManager();
		
		Medicamento medicamento = em.find(Medicamento.class, 2);
		Bairro bairro = em.find(Bairro.class, 1);
		
		System.out.println("O código número " + medicamento.getCodigo() + " corresponde ao medicamento " + medicamento.getNome() + " que se apresenta sob a forma de " + medicamento.getFormaApresentacao());
		System.out.println("Bairro " + bairro.getCodigo() + ":" + bairro.getNome());
				
		em.close();
		fabrica.close();
	}
}
