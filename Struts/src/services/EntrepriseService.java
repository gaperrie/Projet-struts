package services;

import daos.EntrepriseDAO;
import daos.GroupeDAO;
import domain.Contact;
import domain.Entreprise;

public class EntrepriseService {
	public EntrepriseService(){
		
	}
	
	public String addEntreprise(Contact lContact, Integer lNumSiret){
		EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
		return lEntrepriseDAO.addEntreprise(lContact, lNumSiret);
	}
	/*	
	public ArrayList<Entreprise> readEntreprise(){
		EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
		ArrayList<Entreprise> listEntreprise = lEntrepriseDAO.readEntreprise();
		return listEntreprise;
	}
	
	public Integer deleteEntreprise(Integer pId){
		EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
		return lEntrepriseDAO.deleteEntreprise(pId);
	}
	
	public Entreprise showEntreprise(Integer pId){
		EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
		return lEntrepriseDAO.showEntreprise(pId);
	}
	

	public Integer updateEntreprise(Entreprise pEntreprise){
		EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
		return lEntrepriseDAO.updateEntreprise(pEntreprise);
	}
*/

	public String readNumSiret(Integer id) {
		EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
		return lEntrepriseDAO.readNumSiret(id);
	}

	public Integer updateEntreprise(Entreprise lEntreprise) {
		EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
		return lEntrepriseDAO.updateEntreprise(lEntreprise);
	}
}
