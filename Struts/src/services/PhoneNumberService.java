package services;

import java.util.ArrayList;

import daos.PhoneNumberDAO;
import domain.PhoneNumber;

public class PhoneNumberService {
	public PhoneNumberService(){
		
	}
	
	public String addPhoneNumber(PhoneNumber pPhoneNumber){
		PhoneNumberDAO lPhoneNumberDAO = new PhoneNumberDAO();
		return lPhoneNumberDAO.addPhoneNumber(pPhoneNumber);
	}
	
	public ArrayList<PhoneNumber> readPhoneNumber(){
		PhoneNumberDAO lPhoneNumberDAO = new PhoneNumberDAO();
		ArrayList<PhoneNumber> listPhoneNumber = lPhoneNumberDAO.readPhoneNumber();
		return listPhoneNumber;
	}
	
	public Integer deletePhoneNumber(Integer pId){
		PhoneNumberDAO lPhoneNumberDAO = new PhoneNumberDAO();
		return lPhoneNumberDAO.deletePhoneNumber(pId);
	}
	
	public PhoneNumber showPhoneNumber(Integer pId){
		PhoneNumberDAO lPhoneNumberDAO = new PhoneNumberDAO();
		return lPhoneNumberDAO.showPhoneNumber(pId);
	}
	

	public Integer updatePhoneNumber(PhoneNumber pPhoneNumber){
		PhoneNumberDAO lPhoneNumberDAO = new PhoneNumberDAO();
		return lPhoneNumberDAO.updatePhoneNumber(pPhoneNumber);
	}

	public ArrayList<PhoneNumber> readPhoneNumberByContact(Integer pId) {
		PhoneNumberDAO lPhoneNumberDAO = new PhoneNumberDAO();
		ArrayList<PhoneNumber> listPhoneNumber = lPhoneNumberDAO.readPhoneNumberByContact(pId);
		return listPhoneNumber;
	}
}
