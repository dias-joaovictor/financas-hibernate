package br.com.hibernando.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.hibernando.financas.modelo.Conta;
import br.com.hibernando.financas.modelo.Movimentacao;
import br.com.hibernando.financas.modelo.TipoMovimentacao;
import br.com.hibernando.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		
		
		Movimentacao mov = new Movimentacao();
		Conta conta = new Conta();
		//conta.setId(6);
		conta.setAgencia("0949");
		conta.setBanco("237 - BRADESCO");
		conta.setNumero("227547-0");
		conta.setTitular("João Victor Leal Dias");
		
		mov.setData(Calendar.getInstance());
		mov.setDescricao("Churrasquinho do jorge".toUpperCase());
		mov.setTipo(TipoMovimentacao.SAIDA);
		mov.setValor(new BigDecimal("200.00"));
		mov.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
	
		manager.persist(conta);
		manager.persist(mov);
		
		
		manager.getTransaction().commit();
		manager.close();
		
	}

}
