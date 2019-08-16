package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Role;

public interface IRoleService {
	
	/**
	 * @param pUser = client à ajouter
	 * @return id du User ajouté
	 */
	public int addRoleService(Role pRole);

	public void updateRoleService(Role pRole);

	public void deleteRoleService(int pIdRole);

	public Role getRoleService(int pIdRole);

	public List<Role> getAllRoleService();

}
