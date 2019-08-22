package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Caroussel;

@Repository
public class CarousselDaoImpl implements ICarousselDao {

	@Autowired
	private SessionFactory sessionFactory;

	// Setter de la session factory d'hibernate pour injection de spring
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public int addImageDao(Caroussel caroussel) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(caroussel);
	}

	@Transactional
	@Override
	public void deleteImageDao(int pIdCaroussel) {
		Session session = sessionFactory.getCurrentSession();
		Caroussel caroussel = session.get(Caroussel.class, pIdCaroussel);
		session.delete(caroussel);
	}

	@Transactional  (readOnly = true)
	@Override
	public List<Caroussel> getAllCaroussel() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM caroussel c").list();
	}

	@Transactional  (readOnly = true)
	@Override
	public Caroussel getCarousselDao(int pIdCaroussel) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Caroussel.class, pIdCaroussel);
	}

}
