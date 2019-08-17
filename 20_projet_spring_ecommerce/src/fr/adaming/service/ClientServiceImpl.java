package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		Role role = new Role();
		role.setRoleName("ROLE_CLIENT");
		role.setUser(clientDao.getClientDao(pIdClient));
		roleDao.addRoleDao(role);

		return pIdClient;
	}

	@Override
	public void updateClientService(Client pClient) {
		clientDao.updateClientDao(pClient);
	}
	
	@Transactional
	@Override
	public void deleteClientService(int pIdClient) {
		
		Client client = clientDao.getClientDao(pIdClient);
		
		List<Role> listRole = client.getListeRoles();
		
		for(Role role : listRole) {
			roleDao.deleteRoleDao(role.getId());
		}
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
