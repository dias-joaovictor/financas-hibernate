package br.com.hibernando.financas.teste;

import javax.persistence.EntityManager;

import br.com.hibernando.financas.modelo.Conta;
import br.com.hibernando.financas.util.JPAUtil;

public class TesteBuscaEAlteracao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		conta.setTitular("Alexandre Duarte");
		
		manager.getTransaction().commit();
		System.out.println(conta);
		

	}

}
