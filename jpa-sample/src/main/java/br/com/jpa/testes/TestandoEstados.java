package br.com.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		
		//Transient
		Conta conta = new Conta();
		conta.setTitular("Francisco");
		conta.setAgencia(3333);
		conta.setNumero(10526);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Transient para Managed
		em.persist(conta);
		
		
		//Managed para Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		
		
		

	}

}
