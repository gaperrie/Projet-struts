package services;

import java.util.ArrayList;

import daos.ContactDAO;
import domain.Contact;

public class ContactService {
	
	public ContactService(){
		
	}
	
	public String addContact(Contact pContact){
		ContactDAO lContactDAO = new ContactDAO();
		return lContactDAO.addContact(pContact);
	}
	
	public ArrayList<Contact> readContact(){
		ContactDAO lContactDAO = new ContactDAO();
		ArrayList<Contact> listContact = lContactDAO.readContact();
		return listContact;
	}
	
	public Integer deleteContact(Integer pId){
		ContactDAO lContactDAO = new ContactDAO();
		return lContactDAO.deleteContact(pId);
	}
	
	public Contact showContact(Integer pId){
		ContactDAO lContactDAO = new ContactDAO();
		return lContactDAO.showContact(pId);
	}
	

	public Integer updateContact(Contact pContact){
		ContactDAO lContactDAO = new ContactDAO();
		return lContactDAO.updateContact(pContact);
	}

	public ArrayList<Contact> readContactE(){
		ContactDAO lContactDAO = new ContactDAO();
		ArrayList<Contact> listContact = lContactDAO.readContactE();
		return listContact;
	}
	
	public ArrayList<Contact> readContactByGroupe(Integer groupeId){
		ContactDAO lContactDAO = new ContactDAO();
		ArrayList<Contact> listContact = lContactDAO.readContactByGroupe(groupeId);
		return listContact;
	}
}

