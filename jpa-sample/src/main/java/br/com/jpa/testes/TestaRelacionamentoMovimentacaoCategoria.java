package br.com.jpa.testes;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;

import br.com.jpa.modelo.Categoria;
import br.com.jpa.modelo.Conta;
import br.com.jpa.modelo.Movimentacao;
import br.com.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager();
		
		Conta conta = createEntityManager.find(Conta.class, 1L);
		
		Categoria categoria =  new Categoria();
		categoria.setNome("Viagem");
		
		Movimentacao mov = new Movimentacao();
		mov.setDescricao("Viagem à SP");
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov.setData(LocalDateTime.now());
		mov.setValor(new BigDecimal(300.0));
		mov.setCategorias(Arrays.asList(categoria));
		mov.setConta(conta);
		
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(categoria);
		createEntityManager.persist(mov);
		createEntityManager.getTransaction().commit();
		
		createEntityManager.close();	
		

	}

}
