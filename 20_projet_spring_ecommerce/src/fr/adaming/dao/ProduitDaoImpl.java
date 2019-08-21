package fr.adaming.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao{

	/*___________ Déclaration de la session factory d'Hibernate ____________*/
	@Autowired
	private SessionFactory sessionFactory;

	// Setter de la session factory d'hibernate pour injection de spring
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*___________ Les méthodes  ____________*/
	@Transactional
	@Override
	public int addProduit(Produit pProduit) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(pProduit);
	}
	
	@Transactional
	@Override
	public void updateProduit(Produit pProduit) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pProduit);	
	}
	
	@Transactional
	@Override
	public void deleteProduit(int pIdProduit) {
		Session session = sessionFactory.getCurrentSession();
		Produit pOut = session.get(Produit.class, pIdProduit);
		session.delete(pOut);
	}
	
	@Transactional
	@Override
	public Produit getProduit(int pIdProduit) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Produit.class, pIdProduit);
	}
	
	@Transactional
	@Override
	public List<Produit> getAllProduit() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM produit p").list();
	}

	@Transactional
	@Override
	public int associateProduit(Produit pProduit) {
		Session session = sessionFactory.getCurrentSession();
		Query req = session.createQuery("UPDATE produit p SET id_categorie=?1 WHERE id_produit=?2");
		req.setParameter(1, pProduit.getCategorie().getIdCategorie());
		req.setParameter(2, pProduit.getIdProduit());
		return (int) req.getSingleResult();
	}

}
