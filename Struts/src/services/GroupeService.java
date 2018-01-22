package services;

import java.util.ArrayList;

import daos.GroupeDAO;
import domain.Groupe;

public class GroupeService {
	public GroupeService(){
		
	}
	
	public String addGroupe(Groupe pGroupe){
		GroupeDAO lGroupeDAO = new GroupeDAO();
		return lGroupeDAO.addGroupe(pGroupe);
	}
	
	public ArrayList<Groupe> readGroupe(){
		GroupeDAO lGroupeDAO = new GroupeDAO();
		ArrayList<Groupe> listGroupe = lGroupeDAO.readGroupe();
		return listGroupe;
	}
	
	public Integer deleteGroupe(Integer pId){
		GroupeDAO lGroupeDAO = new GroupeDAO();
		return lGroupeDAO.deleteGroupe(pId);
	}
	
	public Groupe showGroupe(Integer pId){
		GroupeDAO lGroupeDAO = new GroupeDAO();
		return lGroupeDAO.showGroupe(pId);
	}
	

	public Integer updateGroupe(Groupe pGroupe){
		GroupeDAO lGroupeDAO = new GroupeDAO();
		return lGroupeDAO.updateGroupe(pGroupe);
	}

	public ArrayList<Groupe> readGroupeByContactId(Integer id) {
		GroupeDAO lGroupeDAO = new GroupeDAO();
		ArrayList<Groupe> listGroupe = lGroupeDAO.readGroupeByContactId(id);
		return listGroupe;
	}

}
