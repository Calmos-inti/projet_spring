package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.User;

public interface IUserDao {
	
	/**
	 * @param pUser = client � ajouter
	 * @return id du User ajout�
	 */
	public int addUserDao(User pUser);

	public void updateUserDao(User pUser);

	public void deleteUserDao(int pIdUser);

	public User getUserDao(int pIdUser);

	public List<User> getAllUserDao();

}
