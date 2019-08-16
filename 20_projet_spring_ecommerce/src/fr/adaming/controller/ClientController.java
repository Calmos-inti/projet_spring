package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.model.Client;
import fr.adaming.model.User;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.UserServiceImpl;

@Controller
public class ClientController {

	@Autowired
	private ClientServiceImpl clServ;
	
	@Autowired
	private UserServiceImpl userServ;
	
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

	@RequestMapping(value = "/client/test")
	public String tester() {
		
		// User user1 = new User("admin@mail.com", "a");
		Client client1 = new Client("client1@mail.com", "1111", "toto", "12 rue des pins", "0678596258");
		clServ.addClientService(client1);
		
		User user1 = new User("admin", "admin");
		userServ.addUserService(user1);
		
		
		return "test";
	}

}
