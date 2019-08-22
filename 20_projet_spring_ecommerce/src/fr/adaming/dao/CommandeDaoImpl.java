package fr.adaming.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Commande;

@Repository
public class CommandeDaoImpl implements ICommandeDao{
	
	
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
	public int addCommandeDao(Commande pCommande) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(pCommande);
	}

	
	@Transactional
	@Override
	public void updateCommandeDao(Commande pCommande) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pCommande);
		
	}

	
	@Transactional
	@Override
	public void deleteCommandeDao(int pIdCommande) {
		Session session = sessionFactory.getCurrentSession();
		Commande nCommande = session.get(Commande.class, pIdCommande);
		session.delete(nCommande);
		
	}

	
	@Transactional
	@Override
	public Commande getCommandeDao(int pIdCommande) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Commande.class, pIdCommande);
	}

	
	@Transactional
	@Override
	public List<Commande> getAllCommandeDao() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM commande co").list();
	}

}
