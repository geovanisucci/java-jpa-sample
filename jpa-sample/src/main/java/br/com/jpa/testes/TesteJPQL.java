package br.com.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager();
		
		String jpql = "select m from Movimentacoes m where m.conta.id = 1";
		
		Query query = createEntityManager.createQuery(jpql);
		List<Movimentacao> rs = query.getResultList();
		
		for (Movimentacao movimentacao : rs) {
			System.out.println(movimentacao.getDescricao());
		}
	}

}
