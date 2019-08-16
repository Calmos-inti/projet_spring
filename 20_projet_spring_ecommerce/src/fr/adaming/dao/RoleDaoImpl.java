package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Role;

@Repository
public class RoleDaoImpl implements IRoleDao {
	

	/* ___________ Déclaration de la session factory d'Hibernate ____________ */
	@Autowired
	private SessionFactory sessionFactory;

	// Setter de la session factory d'hibernate pour injection de spring
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* ____________________ Méthodes du crude ________________________ */
	@Transactional
	@Override
	public int addRoleDao(Role pRole) {
		Session session = sessionFactory.getCurrentSession();	
		return (int) session.save(pRole);
	}
	
	@Transactional
	@Override
	public void updateRoleDao(Role pRole) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pRole);
	}

	@Transactional
	@Override
	public void deleteRoleDao(int pIdRole) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.get(Role.class, pIdRole);
		session.delete(role);	
	}

	@Transactional (readOnly = true)
	@Override
	public Role getRoleDao(int pIdRole) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Role.class, pIdRole);
	}

	@Transactional (readOnly = true)
	@Override
	public List<Role> getAllRoleDao() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM role r").list();
	}


}
