package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.model.Client;
import fr.adaming.model.Role;
import fr.adaming.model.User;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.IRoleService;
import fr.adaming.service.IUserService;
import fr.adaming.service.UserServiceImpl;

@Controller
public class ClientController {

	@Autowired
	private IClientService clServ;

	@Autowired
	private IUserService userServ;

	// Constructeur
	public ClientController() {
		super();
	}

	// setters
	public void setClServ(ClientServiceImpl clServ) {
		this.clServ = clServ;
	}

	public void setUserServ(UserServiceImpl userServ) {
		this.userServ = userServ;
	}

	@Autowired
	IRoleService roleService;

	public void setRoleDao(IRoleService roleService) {
		this.roleService = roleService;
	}

	/* _____________________ TESTS CLIENT ET USER________________________________ */

	@RequestMapping(value = "/client/test")
	public String tester() {

		// ================== TEST AJOUT CLIENT =================================
		Client client1 = new Client("client1@mail.com", "1111", true, "toto", "12 rue des pins", "0678596258");
		Client client2 = new Client("client2@mail.com", "2222", true, "titi", "12 rue des chênes", "0589751523");
		Client client3 = new Client("client3@mail.com", "3333", true, "fifi", "12 rue des sapins", "0656239048");
		Client client4 = new Client("client4@mail.com", "4444", true, "coco", "12 rue des peupliers", "0601892365");
		Client superAdmin = new Client("a@a", "a", true, "Super Admin", "48 rue des tomates", "0675624512");

		clServ.addClientService(client1);
		clServ.addClientService(client2);
		clServ.addClientService(client3);
		clServ.addClientService(client4);

		int idSuperAdmin = clServ.addClientService(superAdmin);

		Role role1 = new Role();
		role1.setRoleName("ROLE_PRODUIT");
		role1.setUser(clServ.getClientService(idSuperAdmin));
		roleService.addRoleService(role1);

		Role role2 = new Role();
		role2.setRoleName("ROLE_CATEGORIE");
		role2.setUser(clServ.getClientService(idSuperAdmin));
		roleService.addRoleService(role2);

		// ================== TEST GET CLIENT =================================

		Client clientFind = clServ.getClientService(1);

		System.out.println("---------------------get by id 1-------------------");
		System.out.println("> Client à l'id 1: " + clientFind);
		System.out.println("---------------------------------------------------");

		// ================== TEST GET CLIENT =================================

		Client clientFind2 = clServ.getClientbyMailService(superAdmin.getMail());

		System.out.println("---------------------get by mail ------------------");
		System.out.println("> Client avec le mail a@a: " + clientFind2);
		System.out.println("---------------------------------------------------");

		// ================== TEST GETALL CLIENT =================================

		List<Client> listeClient = clServ.getAllClientService();

		System.out.println("---------------------get all-------------------");
		for (Client client : listeClient) {
			System.out.println("> " + client);
		}
		System.out.println("---------------------------------------------------");

		// ================== TEST DELETE CLIENT =================================
		// clServ.deleteClientService(2);
		//
		// System.out.println("---------------------delete (id 2)-------------------");
		// Client clientFind2 = clServ.getClientService(2);
		//
		// System.out.println("---------------------get by id 2-------------------");
		// System.out.println("> Client à l'id 2: " + clientFind2);
		// System.out.println("---------------------------------------------------");

		// ================== TEST UPDATE CLIENT =================================

		Client clientFind3 = clServ.getClientService(3);

		System.out.println("---------------------update (id 3) nom = 'Jean'-------------------");
		clientFind3.setNom("Jean");
		clServ.updateClientService(clientFind3);

		System.out.println("---------------------get by id 3-------------------");
		System.out.println("> Client à l'id 3: " + clientFind3);
		System.out.println("---------------------------------------------------");

		// ================== TEST CLIENT 1 =================================
		Client clientout = clServ.getClientService(1);

		System.out.println("-----------------TEST : client 1-------------------");
		System.out.println("> mail client 1 : " + clientout.getMail());
		System.out.println("---------------------------------------------------");

		List<Role> listRole = clientout.getListeRoles();

		System.out.println("---------------------role client id=1-------------------");
		for (Role role : listRole) {
			System.out.println("> " + role);
		}
		System.out.println("---------------------------------------------------");

		// ================== TEST AJOUT USER =================================
		User user1 = new User("user1@mail.com", "admin", true);
		User user2 = new User("user2@mail.com", "admin", true);
		User user3 = new User("user3@mail.com", "admin", true);
		User user4 = new User("user4@mail.com", "admin", true);

		userServ.addUserService(user1);
		userServ.addUserService(user2);
		userServ.addUserService(user3);
		userServ.addUserService(user4);

		// ================== TEST GET USER =================================

		User userFind5 = userServ.getUserService(5);

		System.out.println("---------------------get by id 5-------------------");
		System.out.println("> User à l'id 5: " + userFind5);
		System.out.println("---------------------------------------------------");

		// ================== TEST GETALL USER =================================

		List<User> listeUser = userServ.getAllUserService();

		System.out.println("---------------------get all-------------------");
		for (User user : listeUser) {
			System.out.println("> " + user);
		}
		System.out.println("---------------------------------------------------");

		// ================== TEST DELETE USER =================================
		// userServ.deleteUserService(6);
		//
		// System.out.println("---------------------delete (id 6)-------------------");
		// User userFind6 = userServ.getUserService(6);
		//
		// System.out.println("---------------------get by id 6-------------------");
		// System.out.println("> User à l'id 6: " + userFind6);
		// System.out.println("---------------------------------------------------");

		// ================== TEST UPDATE USER =================================

		User userFind7 = userServ.getUserService(7);

		System.out.println("---------------------update (id 7) mail = 'jean@mail.com'-------------------");
		userFind7.setMail("jean@mail.com");
		userServ.updateUserService(userFind7);

		System.out.println("---------------------get by id 3-------------------");
		System.out.println("> User à l'id 3: " + userFind7);
		System.out.println("---------------------------------------------------");

		return "testClient";
	}

}
