package fr.adaming.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.LignePanier;

public class LignePanierDaoImpl implements ILignePanierDao {
	
	
	/*___________ Déclaration de la session factory d'Hibernate ____________*/
	
	@Autowired
	private SessionFactory sessionFactory;

	// Setter de la session factory d'hibernate pour injection de spring
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	
	/*___________ Les méthodes ____________*/
	
	@Transactional
	@Override
	public int addLignePanierDao(LignePanier pLignePanier) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(pLignePanier);
	}

	
	@Transactional
	@Override
	public void updateLignePanierDao(LignePanier pLignePanier) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pLignePanier);
		
	}

	
	@Transactional
	@Override
	public void deleteLignePanierDao(int pIdLignePanier) {
		Session session = sessionFactory.getCurrentSession();
		LignePanier nLignePanier = session.get(LignePanier.class, pIdLignePanier);
		session.delete(nLignePanier);
		
	}

	
	@Transactional
	@Override
	public LignePanier getLignePanierDao(int pIdLignePanier) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(LignePanier.class, pIdLignePanier);
	}

	
	@Transactional
	@Override
	public List<LignePanier> getAllLignePanierDao() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM ligne_panier l").list();
	}

}
