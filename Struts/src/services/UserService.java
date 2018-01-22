package services;

import daos.UserDAO;
import domain.Contact;

public class UserService {
	public UserService(){
		
	}
	
	public Integer check(String login, String password){
		UserDAO lUserDAO = new UserDAO();
		return lUserDAO.check(login,password);
	}
}
