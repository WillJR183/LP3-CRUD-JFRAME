package br.com.william.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.service.spi.ServiceException;

import br.com.william.model.Peca;

public class PecaController {
	
	private Peca peca;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PecaController(Peca peca) {
		this.peca = peca;
	}
	
	public String EntidadeGerenciadora() {
		try {
			emf = Persistence.createEntityManagerFactory("empresa");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(peca);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			return "Pe�a cadastrada!";
		}catch(ServiceException se) {
			return "Pe�a n�o foi cadastrada. \n ERRO:" + se.getMessage();
		}
	}
}
