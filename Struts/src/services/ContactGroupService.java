package services;

import java.util.ArrayList;

import daos.ContactGroupDAO;
import daos.PhoneNumberDAO;
import domain.ContactGroup;
import domain.Groupe;

public class ContactGroupService {
	public String addContactGroup(ContactGroup pContactGroup){
		ContactGroupDAO lContactGroupDAO = new ContactGroupDAO();
		return lContactGroupDAO.addContactGroup(pContactGroup);
	}	
	public ArrayList<Groupe> readGroupeById(Integer pId){
		ContactGroupDAO lContactGroupDAO = new ContactGroupDAO();
		return lContactGroupDAO.readGroupeById(pId);
	}
	public Integer deleteContactGroup(ContactGroup lContactGroup){
		ContactGroupDAO lContactGroupDAO = new ContactGroupDAO();
		return lContactGroupDAO.deleteContactGroup(lContactGroup);
	}
}
