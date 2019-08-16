package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	/**
	 * @param pUser = user � ajouter
	 * @return id du User ajout�
	 */
	public int addClientService(Client pClient);

	public void updateClientService(Client pClient);

	public void deleteClientService(int pIdClient);

	public Client getClientService(int pIdClient);

	public List<Client> getAllClientService();

}
