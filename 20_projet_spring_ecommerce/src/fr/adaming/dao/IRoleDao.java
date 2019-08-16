package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Role;

public interface IRoleDao {
	
	/**
	 * @param pUser = client à ajouter
	 * @return id du User ajouté
	 */
	public int addRoleDao(Role pRole);

	public void updateRoleDao(Role pRole);

	public void deleteRoleDao(int pIdRole);

	public Role getRoleDao(int pIdRole);

	public List<Role> getAllRoleDao();

}
