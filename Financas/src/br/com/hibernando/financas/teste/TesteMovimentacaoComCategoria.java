package br.com.hibernando.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.hibernando.financas.modelo.Categoria;
import br.com.hibernando.financas.modelo.Conta;
import br.com.hibernando.financas.modelo.Movimentacao;
import br.com.hibernando.financas.modelo.TipoMovimentacao;
import br.com.hibernando.financas.util.JPAUtil;

public class TesteMovimentacaoComCategoria {

	public static void main(String[] args) {
		
		
		Categoria categoria1 = new Categoria("Viagem".toUpperCase());
		Categoria categoria2 = new Categoria("Trabalho".toUpperCase());
		
		Movimentacao m1 = new Movimentacao();
		Movimentacao m2 = new Movimentacao();
		
		Conta conta = new Conta();
		
		conta.setId(1);


		m1.setData(Calendar.getInstance());
		m1.setDescricao("Viagem à SP");
		m1.setCategoria(Arrays.asList(categoria1, categoria2));
		m1.setTipo(TipoMovimentacao.SAIDA);
		m1.setValor(new BigDecimal("300.00"));
		m1.setConta(conta);
		
		m2.setData(Calendar.getInstance());
		m2.setDescricao("Viagem ao RJ");
		m2.setCategoria(Arrays.asList(categoria1, categoria2));
		m2.setTipo(TipoMovimentacao.SAIDA);
		m2.setValor(new BigDecimal("1552.30"));
		m2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria2);
		em.persist(categoria1);
		em.persist(m2);
		em.persist(m1);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
