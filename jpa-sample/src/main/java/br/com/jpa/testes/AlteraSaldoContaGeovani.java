package br.com.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class AlteraSaldoContaGeovani {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager();
		
		Conta conta = createEntityManager.find(Conta.class, 1L);
		
		System.out.println(conta.getTitular());
		
		
		createEntityManager.getTransaction().begin();
		conta.setSaldo(56.30);
		createEntityManager.getTransaction().commit();

	}

}
