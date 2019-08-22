package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	/**
	 * @param pUser = user à ajouter
	 * @return id du User ajouté
	 */
	public int addClientService(Client pClient);

	public void updateClientService(Client pClient);

	public void deleteClientService(int pIdClient);

	public Client getClientService(int pIdClient);

	public List<Client> getAllClientService();
	
	/**
	 * Recheche de client par son adresse mail.
	 * @param pMail : mail du client
	 * @return Client : le premier client trouvé dans la BDD avec mail = pMail
	 */
	public Client getClientbyMailService(String pMail);

}
