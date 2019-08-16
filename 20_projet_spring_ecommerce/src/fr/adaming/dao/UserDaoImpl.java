package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	/* ___________ Déclaration de la session factory d'Hibernate ____________ */
	@Autowired
	private SessionFactory sessionFactory;

	// Setter de la session factory d'hibernate pour injection de spring
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* ______________________ Méthodes du crude _____________________________ */
	@Transactional
	@Override
	public int addUserDao(User pUser) {
		Session session = sessionFactory.getCurrentSession();	
		return (int) session.save(pUser);
	}

	@Transactional
	@Override
	public void updateUserDao(User pUser) {
		Session session = sessionFactory.getCurrentSession();	
		session.update(pUser);
	}

	@Transactional
	@Override
	public void deleteUserDao(int pIdUser) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, pIdUser);
		session.delete(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User getUserDao(int pIdUser) {
		Session session = sessionFactory.getCurrentSession();	
		return session.get(User.class, pIdUser);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> getAllUserDao() {
		Session session = sessionFactory.getCurrentSession();	
		return session.createQuery("FROM user u").list();
	}

}
