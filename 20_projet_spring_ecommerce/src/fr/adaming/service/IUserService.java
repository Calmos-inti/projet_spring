package fr.adaming.service;

import java.util.List;

import fr.adaming.model.User;

public interface IUserService {
	
	/**
	 * @param pUser = client à ajouter
	 * @return id du User ajouté
	 */
	public int addUserService(User pUser);

	public void updateUserService(User pUser);

	public void deleteUserService(int pIdUser);

	public User getUserService(int pIdUser);

	public List<User> getAllUserService();

}
