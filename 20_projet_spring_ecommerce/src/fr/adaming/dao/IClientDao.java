package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;



public interface IClientDao {
	
	/**
	 * @param pClient = client � ajouter
	 * @return id du Client ajout�
	 */
	public int addClientDao(Client pClient);

	public void updateClientDao(Client pClient);

	public void deleteClientDao(int pIdClient);

	public Client getClientDao(int pIdClient);

	public List<Client> getAllClientDao();

}
