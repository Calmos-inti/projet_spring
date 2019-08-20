package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IRoleDao;
import fr.adaming.dao.IUserDao;
import fr.adaming.model.Role;
import fr.adaming.model.User;

@Service
public class UserServiceImpl implements IUserService {

	/* _______________ Déclaration de la classe Dao ________________ */
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IRoleDao roleDao;

	// Setters de la dao pour injection Spring
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}


	/* ____________________ Méthodes du crude ________________________ */
	@Override
	public int addUserService(User pUser) {
		int pIdUser = userDao.addUserDao(pUser);
		Role role = new Role();
		role.setRoleName("ROLE_PRODUIT");
		role.setUser(userDao.getUserDao(pIdUser));
		roleDao.addRoleDao(role);

		return pIdUser;
	}

	@Override
	public void updateUserService(User pUser) {
		userDao.updateUserDao(pUser);
	}
	
	@Override
	public void deleteUserService(int pIdUser) {
		User user = userDao.getUserDao(pIdUser);
		
		List<Role> listRole = user.getListeRoles();
		
		for(Role role : listRole) {
			roleDao.deleteRoleDao(role.getId());
		}
		
		userDao.deleteUserDao(pIdUser);
	}

	@Override
	public User getUserService(int pIdUser) {
		return userDao.getUserDao(pIdUser);
	}

	@Override
	public List<User> getAllUserService() {
		return userDao.getAllUserDao();
	}

}
