package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao{
	
	
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
	public int addClientDao(Client pClient) {
		Session session = sessionFactory.getCurrentSession();	
		return (int) session.save(pClient);
	}
	
	@Transactional
	@Override
	public void updateClientDao(Client pClient) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pClient);
	}

	@Transactional
	@Override
	public void deleteClientDao(int pIdClient) {
		Session session = sessionFactory.getCurrentSession();
		Client employe = session.get(Client.class, pIdClient);
		session.delete(employe);	
	}

	@Transactional (readOnly = true)
	@Override
	public Client getClientDao(int pIdClient) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Client.class, pIdClient);
	}

	@Transactional (readOnly = true)
	@Override
	public List<Client> getAllClientDao() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM client c").list();
	}

}
