package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Panier;

public class PanierDaoImpl implements IPanierDao {
	
	
	/*___________ Déclaration de la session factory d'Hibernate ____________*/
	
	@Autowired
	private SessionFactory sessionFactory;

	// Setter de la session factory d'hibernate pour injection de spring
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	/*______________________ Méthodes du crude _____________________________*/
	
	@Transactional
	@Override
	public int addPanierDao(Panier pPanier) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(pPanier);
	}
	
	
	@Transactional
	@Override
	public void updatePanierDao(Panier pPanier) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pPanier);
		
		
	}
	
	
	@Transactional
	@Override
	public void deletePanierDao(int pIdPanier) {
		Session session = sessionFactory.getCurrentSession();
		Panier nPanier = session.get(Panier.class, pIdPanier);
		session.delete(nPanier);
		
		
	}
	
	
	@Transactional
	@Override
	public Panier getPanierDao(int pIdPanier) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Panier.class, pIdPanier);
		
	}
	
	
	@Transactional
	@Override
	public List<Panier> getAllPanierDao() {
		Session session = sessionFactory.getCurrentSession();
		
		
		return session.createQuery("FROM panier p").list();
	}
	
	

}
