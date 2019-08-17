package fr.adaming.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

@Repository
public class CategorieDaoImpl implements ICategorieDao {

	
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
	public int addCategorie(Categorie pCategorie) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(pCategorie);
	}

	@Transactional
	@Override
	public void updateCategorie(Categorie pCatogorie) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pCatogorie);
	}

	@Transactional
	@Override
	public void deleteCategorie(int pIdCategorie) {
		Session session = sessionFactory.getCurrentSession();
		Categorie catOut = session.get(Categorie.class, pIdCategorie);
		session.delete(catOut);
	}

	@Transactional
	@Override
	public Categorie getCategorie(int pIdCategorie) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Categorie.class, pIdCategorie);
	}

	@Transactional
	@Override
	public List<Categorie> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM categorie c").list();
	}

}
