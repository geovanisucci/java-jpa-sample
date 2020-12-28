package br.com.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Geovani Succi");
		conta.setAgencia(421);
		conta.setNumero(1234);
		
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(conta);
		createEntityManager.getTransaction().commit();
		
		


	}

}
