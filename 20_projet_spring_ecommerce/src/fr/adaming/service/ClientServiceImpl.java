package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IRoleDao;
import fr.adaming.model.Client;
import fr.adaming.model.Role;

@Service
public class ClientServiceImpl implements IClientService {

	/* _______________ Déclaration de la classe Dao ________________ */
	@Autowired
	IClientDao clientDao;
	
	@Autowired
	IRoleDao roleDao;

	// Setters de la dao pour injection Spring
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}
	
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/* ____________________ Méthodes du crude ________________________ */
	@Override
	public int addClientService(Client pClient) {
		int pIdClient = clientDao.addClientDao(pClient);
		
		// Créer un role (avec le roleName 'ROLE_CLIENT') et l'attribuer au client
		Role role = new Role();
		role.setUser(clientDao.getClientDao(pIdClient));
		role.setRoleName("ROLE_CLIENT");
		roleDao.addRoleDao(role);
		return pIdClient;
	}

	@Override
	public void updateClientService(Client pClient) {
		clientDao.updateClientDao(pClient);
	}

	@Override
	public void deleteClientService(int pIdClient) {
		clientDao.deleteClientDao(pIdClient);
	}

	@Override
	public Client getClientService(int pIdClient) {
		return clientDao.getClientDao(pIdClient);
	}

	@Override
	public List<Client> getAllClientService() {
		return clientDao.getAllClientDao();
	}

}
