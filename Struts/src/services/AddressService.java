package services;

import java.util.ArrayList;

import daos.AddressDAO;
import domain.Address;
import domain.Contact;

public class AddressService {
	public AddressService(){
		
	}
	
	public String addAddress(Address pAddress){
		System.out.println("lAddress service : "+pAddress.toString());
		AddressDAO lAddressDAO = new AddressDAO();
		return lAddressDAO.addAddress(pAddress);
	}
	
	public ArrayList<Address> readAddress(){
		AddressDAO lAddressDAO = new AddressDAO();
		ArrayList<Address> listAddress = lAddressDAO.readAddress();
		return listAddress;
	}
	
	public Address showAddressByContact(Integer lContactId){
		AddressDAO lAddressDAO = new AddressDAO();
		Address lAddress = lAddressDAO.showAddressByContact(lContactId);
		return lAddress;
	}
	
	public Integer deleteAddress(Integer pId){
		AddressDAO lAddressDAO = new AddressDAO();
		return lAddressDAO.deleteAddress(pId);
	}
	
	public Address showAddress(Integer pId){
		AddressDAO lAddressDAO = new AddressDAO();
		return lAddressDAO.showAddress(pId);
	}
	

	public Integer updateAddress(Address pAddress){
		AddressDAO lAddressDAO = new AddressDAO();
		return lAddressDAO.updateAddress(pAddress);
	}

}
