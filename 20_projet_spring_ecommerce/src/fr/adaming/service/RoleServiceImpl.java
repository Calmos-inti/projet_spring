package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IRoleDao;
import fr.adaming.model.Role;

@Service
public class RoleServiceImpl implements IRoleService {

	/* _______________ Déclaration de la classe Dao ________________ */
	@Autowired
	IRoleDao roleDao;

	// Setters de la dao pour injection Spring
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/* ____________________ Méthodes du crude ________________________ */
	@Override
	public int addRoleService(Role pRole) {
		return roleDao.addRoleDao(pRole);
	}

	@Override
	public void updateRoleService(Role pRole) {
		roleDao.updateRoleDao(pRole);
	}

	@Override
	public void deleteRoleService(int pIdRole) {
		roleDao.deleteRoleDao(pIdRole);
	}

	@Override
	public Role getRoleService(int pIdRole) {
		return roleDao.getRoleDao(pIdRole);
	}

	@Override
	public List<Role> getAllRoleService() {
		return roleDao.getAllRoleDao();
	}

}
